package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.HashMap;

public class Bag {
    private HashMap<PawnColor, Integer> students;
    private PawnColor color;

    public Bag () {
        students = new HashMap<PawnColor, Integer>();
        students.put(PawnColor.BLUE, 10);
        students.put(PawnColor.GREEN, 10);
        students.put(PawnColor.PINK, 10);
        students.put(PawnColor.RED, 10);
        students.put(PawnColor.YELLOW, 10);
    }

    /**
     * Method that extract a random color
     * @return a color
     */
    private PawnColor extractColor () {
        return PawnColor.BLUE;
    }

    /**
     * Method that extract a random student from the bag
     * and return it to the game
     * @return a student
     */
    public Student pickStudent () {
        // prova
        color = extractColor();
        students.put(color, students.get(color)-1);
        return new Student(color);
    }

    /**
     * Method that returns the total number of students in the bag
     * @return actualNumberOfStudents
     */
    public int returnNumberOfStudents () {
        int actualNumberOfStudents = 0;
        for (PawnColor color : PawnColor.values()) {
            actualNumberOfStudents += students.get(color);
        }
        return actualNumberOfStudents;
    }
}
