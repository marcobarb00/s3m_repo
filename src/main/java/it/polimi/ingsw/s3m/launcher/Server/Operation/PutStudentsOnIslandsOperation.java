package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.Player;
import it.polimi.ingsw.s3m.launcher.Server.Model.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class PutStudentsOnIslandsOperation extends Operation{
    private int islandPosition;
    private Student selectedStudent;

    public PutStudentsOnIslandsOperation(Game game, PlayerController playerController,
                                         int islandPosition, Student selectedStudent) {
        super(game, playerController);
        this.islandPosition = islandPosition;
        this.selectedStudent = selectedStudent;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, IllegalArgumentException  {
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        //3 players mode check REMOVED

        //Checks if there are the selected students in entrance
        searchStudentsInEntrance();

        boolean checkIsland = 0 <= islandPosition && islandPosition < game.getIslandsList().size();
        if (!checkIsland){
            throw new IllegalArgumentException("Incorrect island value");
        }

        game.putStudentOnIslands(playerController.getNickname(), islandPosition, selectedStudent);
    }

    private void searchStudentsInEntrance(){
        Player player = game.getPlayerHashMap().get(playerController.getNickname());
        HashMap<PawnColor,Integer> entrance = player.getDashboard().getEntrance();

        //Check if at least one student of that color is present in hall
        boolean studentInEntrance = entrance.get(selectedStudent.getColor()) > 0;
        if(!studentInEntrance){
            throw new IllegalArgumentException("Student not in entrance");
        }
    }
}
