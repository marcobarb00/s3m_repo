package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.*;

import java.util.ArrayList;
import java.util.HashMap;

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

    //TODO
    @Override
    public void executeOperation() throws PlayerNotInListException, IllegalArgumentException{
        //Check for double nicknames
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        boolean checkRequired = requiredStudents.size() == 3;
        boolean checkGiven = givenStudents.size() == 3;
        if(!(checkGiven && checkRequired)){
            //throw new IllegalArgumentException("Must exchange only 3 students");
        }

        //Search students on card
        searchStudentsOnCard();

        //Search students in dashboard hall
        //Smells soooo bad
        searchStudentsInHall();

        super.game.activateJesterEffect(playerController.getNickname(),
                requiredStudents, givenStudents);
    }

    /**
     * Checks if on Jester card the students are enough
     */
    private void searchStudentsOnCard(){
        HashMap<PawnColor, Integer> studentsOnJester = game.getJesterStudentsOnCard();

        HashMap<PawnColor, Integer> requiredStudentsHashMap = new HashMap<>();
        for(PawnColor p : PawnColor.values()){
            requiredStudentsHashMap.put(p,0);
        }

        for(Student requiredStudent : requiredStudents){
            PawnColor requiredStudentColor = requiredStudent.getColor();
            int oldValue = requiredStudentsHashMap.get(requiredStudentColor);
            requiredStudentsHashMap.replace(requiredStudentColor, oldValue  + 1);
        }

        for(PawnColor color : PawnColor.values()){
            boolean notEnoughStudentsOnCard =
                    requiredStudentsHashMap.get(color) > studentsOnJester.get(color);
            if(notEnoughStudentsOnCard){
                throw new IllegalArgumentException("Not enough students on jester card");
            }
        }
    }

    private void searchStudentsInHall(){
        HashMap<PawnColor, Integer> givenStudentsHashMap = new HashMap<>();

        for(PawnColor p : PawnColor.values()){
            givenStudentsHashMap.put(p,0);
        }

        for(Student givenStudent : givenStudents){
            PawnColor givenStudentColor = givenStudent.getColor();
            int oldValue = givenStudentsHashMap.get(givenStudentColor);
            givenStudentsHashMap.replace(givenStudentColor, oldValue  + 1);
        }

        Player player = game.getPlayerHashMap().get(playerController.getNickname());
        ArrayList<Student> hall = player.getDashboard().getHall();

        HashMap<PawnColor, Integer> hallHashMap = new HashMap<>();

        for(PawnColor p : PawnColor.values()){
            hallHashMap.put(p,0);
        }

        for(Student hallStudent : hall){
            PawnColor hallStudentColor = hallStudent.getColor();
            int oldValue = hallHashMap.get(hallStudentColor);
            hallHashMap.replace(hallStudentColor, oldValue  + 1);
        }

        for(PawnColor color : PawnColor.values()){
            boolean notEnoughStudentsInHall =
                    givenStudentsHashMap.get(color) > hallHashMap.get(color);
            if(notEnoughStudentsInHall){
                throw new IllegalArgumentException("Not enough students in hall");
            }
        }

    }
}
