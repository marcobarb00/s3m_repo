package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;

import java.util.ArrayList;

public class Cloud {
    private final int id;
    private ArrayList<Student> students;

    public Cloud (int id) {
        this.id = id;
        this.students = new ArrayList<>();
    }

    /* public void refillThreeStudents () {
        if (studentList.size() != 0) return;
        for (int i = 0; i < 3; i++) {
            try {
                studentList.add(game.getBag().pickStudent());
            } catch (EmptyBagException e) {
                e.printStackTrace();
            }
        }
    } */

    public int getId() { return id; }

    public ArrayList<Student> returnThreeStudents() { return students; }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
