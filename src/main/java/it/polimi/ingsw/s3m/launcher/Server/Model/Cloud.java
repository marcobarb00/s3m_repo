package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class Cloud {
    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> returnStudents() {
        ArrayList<Student> returningStudents = new ArrayList<>(students);
        students.clear();
        return returningStudents;
    }

    // GETTER
    public ArrayList<Student> getStudents() { return students; }

    // SETTER
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
