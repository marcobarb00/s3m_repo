package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

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

    //TODO Asking for a HashMap implementation of hall
    @Override
    public void executeOperation() throws PlayerNotInListException, IllegalArgumentException, NotExpertModeException {
        //Check for double nicknames
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }
        boolean checkExpertMode = game.isExpertMode();

        if(!checkExpertMode){
            throw new NotExpertModeException();
        }

        boolean checkRequired = requiredStudents.size() == 3;
        boolean checkGiven = givenStudents.size() == 3;
        if(!(checkGiven && checkRequired)){
            new IllegalArgumentException("Must exchange only 3 students");
        }

        //Search students on card
        searchStudentsOnCard();

        //Search students in dashboard hall
        //Method looks like crap but should work
        searchStudentsInHall();

        super.game.activateJesterEffect(playerController.getNickname(),
                requiredStudents, givenStudents);
    }

    /**
     * Checks if on Jester card the students are enough
     */
    private void searchStudentsOnCard(){
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

    private void searchStudentsInHall(){
        Player player = game.getPlayerHashMap().get(playerController.getNickname());
        ArrayList<Student> hall = player.getDashboard().getHall();

        //For each color looks how many students of that color and compares
        // with hall of that color
        for(PawnColor color : PawnColor.values()){
            int numberOfGivenStudents = (int) givenStudents.stream().filter(
                    student -> student.getColor() == color ).count();
            int numberOfHallStudents = (int) hall.stream().filter(
                    student -> student.getColor() == color ).count();
            boolean notEnoughStudentsInHall =
                    numberOfGivenStudents > numberOfHallStudents;
            if(notEnoughStudentsInHall){
                throw new IllegalArgumentException("Not enough students in hall");
            }
        }

    }
}
