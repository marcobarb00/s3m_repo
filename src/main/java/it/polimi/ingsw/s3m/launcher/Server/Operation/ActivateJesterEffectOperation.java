package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotEnoughCoinsException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.*;

import java.util.ArrayList;
import java.util.HashMap;

// DONE
public class ActivateJesterEffectOperation extends Operation{
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
        super(game, playerController);
        this.requiredStudents = requiredStudents;
        this.givenStudents = givenStudents;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, IllegalArgumentException, NotExpertModeException, NotEnoughCoinsException {
        //Check for double nicknames
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        //checking expert mode
        boolean checkExpertMode = game.isExpertMode();
        if(!checkExpertMode){
            throw new NotExpertModeException();
        }

        //checking if player has enough coins
        boolean checkCost = checkCharacterCardCost("Jester");
        if(!checkCost){
            throw new NotEnoughCoinsException();
        }

        boolean checkRequired = requiredStudents.size() == 3;
        boolean checkGiven = givenStudents.size() == 3;
        if(!(checkGiven && checkRequired)){
            throw new IllegalArgumentException("Incorrect exchange students value");
        }

        //Search students on card
        searchStudentsOnCard();

        //Search students in dashboard hall
        //Method looks like crap but should work
        searchStudentsInEntrance();

        super.game.activateJesterEffect(playerController.getNickname(),
                requiredStudents, givenStudents);
    }

    /**
     * Checks if on Jester card the students are enough
     */
    private void searchStudentsOnCard() throws IllegalArgumentException{
        HashMap<PawnColor, Integer> studentsOnJester = game.getJesterStudentsOnCard();

        //checking on Jester card
        for(PawnColor color : PawnColor.values()){
            int numberOfRequiredStudents = (int) requiredStudents.stream().filter(
                    student -> student.getColor() == color ).count();
            boolean notEnoughStudentsOnCard =
                    numberOfRequiredStudents > studentsOnJester.get(color);
            if(notEnoughStudentsOnCard){
                throw new IllegalArgumentException("Not enough students on jester card");
            }
        }
    }

    private void searchStudentsInEntrance() throws IllegalArgumentException{
        Player player = game.getPlayerHashMap().get(playerController.getNickname());
        HashMap<PawnColor,Integer> entrance = player.getDashboard().getEntrance();

        //For each color looks how many students of that color and compares
        // with entrance of that color
        for(PawnColor color : PawnColor.values()){
            int numberOfGivenStudents = (int) givenStudents.stream().filter(
                    student -> student.getColor() == color ).count();
            boolean notEnoughStudentsInEntrance =
                    numberOfGivenStudents > entrance.get(color);
            if(notEnoughStudentsInEntrance){
                throw new IllegalArgumentException("Not enough students in entrance");
            }
        }

    }
}
