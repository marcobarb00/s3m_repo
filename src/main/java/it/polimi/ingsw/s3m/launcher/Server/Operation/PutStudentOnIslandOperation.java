package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.Player;
import it.polimi.ingsw.s3m.launcher.Server.Model.Student;

import java.util.HashMap;

public class PutStudentOnIslandOperation extends Operation{
    private int islandPosition;
    private PawnColor studentColor;

    public PutStudentOnIslandOperation(Game game, PlayerController playerController,
                                       int islandPosition, PawnColor studentColor) {
        super(game, playerController);
        this.islandPosition = islandPosition;
        this.studentColor = studentColor;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, IllegalArgumentException  {
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        //check if student can be moved
        checkMovableStudent();   

        //Checks if there are the selected students in entrance
        searchStudentsInEntrance();

        boolean checkIsland = 0 <= islandPosition && islandPosition < game.getIslandsList().size();
        if (!checkIsland){
            throw new IllegalArgumentException("Incorrect island value");
        }

        game.putStudentOnIslands(playerController.getNickname(), islandPosition, new Student(studentColor));
    }

    private void searchStudentsInEntrance(){
        Player player = game.getPlayerHashMap().get(playerController.getNickname());
        HashMap<PawnColor,Integer> entrance = player.getDashboard().getEntrance();

        //Check if at least one student of that color is present in hall
        boolean studentInEntrance = entrance.get(studentColor) > 0;
        if(!studentInEntrance){
            throw new IllegalArgumentException("Student not in entrance");
        }
    }

}
