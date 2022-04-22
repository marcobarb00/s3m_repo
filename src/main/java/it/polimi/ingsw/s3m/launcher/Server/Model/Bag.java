package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import java.util.HashMap;

public class Bag {
    private HashMap<PawnColor, Integer> students;

    public Bag() {
        students = new HashMap<PawnColor, Integer>();
        for (PawnColor color : PawnColor.values()) {
            students.put(color, 24);
        }
    }

    public HashMap<PawnColor, Integer> getStudents () { return students; }

    public int getTotalNumberOfStudents() {
        int sum = 0;
        for (PawnColor color : PawnColor.values()) {
            sum += students.get(color);
        }
        return sum;
    }

    public void decrementStudentsColor (Student student) {
        PawnColor currentColor = student.getColor();
        students.replace(currentColor, students.get(currentColor)-1);
    }
}
