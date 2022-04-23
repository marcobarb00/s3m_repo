package it.polimi.ingsw.s3m.launcher.Server.Model;

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
        ArrayList<Student> returningStudents = new ArrayList<>(students);
        students.clear();
        return returningStudents;
    }

    // GETTER
    public int getId() { return id; }
    public ArrayList<Student> getStudents() { return students; }

    // SETTER
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
