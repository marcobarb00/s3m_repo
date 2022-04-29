package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Cloud;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.Student;

import java.util.ArrayList;

public class ActivateJesterEffectOperation extends Operation{
    private PlayerController playerController;
    private ArrayList<Student> requiredStudents;
    private ArrayList<Student> givenStudents;

    /**
     * Checks if activateJesterEffect method has safe parameters.
     * Required students are those the player wants from the card,
     * given students are those from the player hall.
     * @param game
     * @param playerController
     * @param requiredStudents
     * @param givenStudents
     */
    public ActivateJesterEffectOperation(Game game, PlayerController playerController,
                                         ArrayList<Student> requiredStudents,
                                         ArrayList<Student> givenStudents) {
        super(game);
        this.playerController = playerController;
        this.requiredStudents = requiredStudents;
        this.givenStudents = givenStudents;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, IllegalArgumentException{
        ArrayList<String> playersList = super.game.getPlayersNicknames();

        boolean playerControllerInList = playersList.contains(playerController.getNickname());
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        boolean checkRequired = requiredStudents.size() == 3;
        boolean checkGiven = givenStudents.size() == 3;

        if(checkGiven && checkRequired){
            super.game.activateJesterEffect(playerController.getNickname(),
                    requiredStudents, givenStudents);
        }else{
            throw new IllegalArgumentException();
        }
    }
}
