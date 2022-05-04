package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.Player;
import it.polimi.ingsw.s3m.launcher.Server.Model.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class PutStudentsOnTablesOperation extends Operation{
    ArrayList<Student> selectedStudents;

    public PutStudentsOnTablesOperation(Game game, PlayerController playerController, ArrayList<Student> selectedStudents) {
        super(game, playerController);
        this.selectedStudents = selectedStudents;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, IllegalArgumentException {
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        //checking 3 players mode
        boolean checkSelectedStudentsNumber;
        int numberOfPlayers = game.getNumberOfPlayers();
        if(numberOfPlayers == 3){
            checkSelectedStudentsNumber = selectedStudents.size() <= 4;
        }else{
            checkSelectedStudentsNumber = selectedStudents.size() <= 3;
        }

        if (!checkSelectedStudentsNumber){
            throw new IllegalArgumentException("Incorrect selected students number");
        }
        //Checking students in hall
        searchStudentsInEntrance();

        game.putStudentsOnTables(playerController.getNickname(), selectedStudents);
    }

    private void searchStudentsInEntrance(){
        Player player = game.getPlayerHashMap().get(playerController.getNickname());
        HashMap<PawnColor,Integer> entrance = player.getDashboard().getEntrance();

        //For each color looks how many students of that color and compares
        // with entrance of that color
        for(PawnColor color : PawnColor.values()){
            int numberOfSelectedStudents = (int) selectedStudents.stream().filter(
                    student -> student.getColor() == color ).count();
            boolean notEnoughStudentsInEntrance =
                    numberOfSelectedStudents > entrance.get(color);
            if(notEnoughStudentsInEntrance){
                throw new IllegalArgumentException("Not enough students in entrance");
            }
        }
    }
}
