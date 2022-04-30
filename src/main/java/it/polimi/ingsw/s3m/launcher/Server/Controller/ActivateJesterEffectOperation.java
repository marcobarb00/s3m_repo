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

    private void searchStudentsOnCard(){
        HashMap<PawnColor, Integer> studentsOnJester = game.getJesterStudentsOnCard();
        for(Student requiredStudent : requiredStudents){
            PawnColor requiredStudentColor = requiredStudent.getColor();
            boolean checkOnCard = studentsOnJester.get(requiredStudentColor) > 0;
            if(checkOnCard){
                int oldValue = studentsOnJester.get(requiredStudent.getColor());
                studentsOnJester.replace(requiredStudentColor, oldValue - 1);
            }else{
                throw new IllegalArgumentException("Student not on Jester");
            }
        }
    }

    private void searchStudentsInHall(){
        String playerNickname = playerController.getNickname();
        Player player = game.getPlayerHashMap().get(playerNickname);
        ArrayList<Student> hall = player.getDashboard().getHall();

        for(Student givenStudent: givenStudents){
            boolean checkStudentInHall = false;
            for(Student studentInHall : hall){
                checkStudentInHall = studentInHall.getColor() == givenStudent.getColor();
                if(checkStudentInHall){
                    hall.remove(studentInHall);
                    break;
                }
            }
            if(!checkStudentInHall)
                throw new IllegalArgumentException("Student not in hall");
        }
    }
}
