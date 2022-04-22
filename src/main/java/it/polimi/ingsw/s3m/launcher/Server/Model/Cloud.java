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

    public ArrayList<Student> returnThreeStudents() {
        if (students.size() != 3) return null;
        ArrayList<Student> returningStudents = students;
        for (int i = 0; i < returningStudents.size(); i++) {
            students.remove(i);
        }
        return returningStudents;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getId() { return id; }
}
