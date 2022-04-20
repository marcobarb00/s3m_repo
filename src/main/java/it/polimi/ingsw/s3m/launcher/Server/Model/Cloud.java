package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class Cloud {
    private final int id;
    private ArrayList<Student> studentList;

    public Cloud (int id) {
        this.id = id;
    }

    /**
     * Method that return a list of the students in
     * the cloud when this is chosen by a player
     */
    public ArrayList<Student> giveThreeStudents () {
        return studentList;
    }

    /**
     * Method that takes three students from the bag and
     * put them on the cloud, refilling the array of students
     */
    public void refillThreeStudents () {
    }
}
