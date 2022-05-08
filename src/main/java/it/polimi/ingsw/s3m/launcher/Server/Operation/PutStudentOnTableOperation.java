package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.Player;
import it.polimi.ingsw.s3m.launcher.Server.Model.Student;

import java.util.HashMap;

public class PutStudentOnTableOperation extends Operation{
    Student selectedStudent;

    public PutStudentOnTableOperation(Game game, PlayerController playerController, Student selectedStudent) {
        super(game, playerController);
        this.selectedStudent = selectedStudent;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, IllegalArgumentException {
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        //check movable student
        checkMovableStudent();

        //Checking students in hall
        searchStudentsInEntrance();

        game.putStudentOnTables(playerController.getNickname(), selectedStudent);
    }

    private void searchStudentsInEntrance(){
        Player player = game.getPlayerHashMap().get(playerController.getNickname());
        HashMap<PawnColor,Integer> entrance = player.getDashboard().getEntrance();

        //Check if at least one student of that color is present in entrance
        boolean studentInEntrance = entrance.get(selectedStudent.getColor()) > 0;
        if(!studentInEntrance){
            throw new IllegalArgumentException("Student not in entrance");
        }
    }
}
