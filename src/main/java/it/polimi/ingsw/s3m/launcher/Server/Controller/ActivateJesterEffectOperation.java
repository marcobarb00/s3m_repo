package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.Student;

import java.util.ArrayList;

public class ActivateJesterEffectOperation extends Operation{
    private PlayerController playerController;
    private ArrayList<Student> requiredStudents;
    private ArrayList<Student> givenStudents;

    /**
     * Checks if activateJesterEffect method has safe parameters
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

    //TODO Do controls on parameters of activateJesterEffect (game line 140)
    @Override
    public void executeOperation() throws PlayerNotInListException, CloudNotInListException {

    }
}
