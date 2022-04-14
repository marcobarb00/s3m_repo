package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;

import java.util.HashMap;

public class Bag {
    private HashMap<PawnColor, Integer> students;

    public Bag () {
        students = new HashMap<PawnColor, Integer>();
        students.put(PawnColor.BLUE, 26);
        students.put(PawnColor.GREEN, 26);
        students.put(PawnColor.PINK, 26);
        students.put(PawnColor.RED, 26);
        students.put(PawnColor.YELLOW, 26);
    }

    public HashMap<PawnColor, Integer> getStudents () { return students; }

    /**
     * Method that extract a random color from the bag
     * @return a color of a student
     */
    private PawnColor extractColor () {
        float percent = (float) Math.random();
        if (percent < 0.2) {
            return PawnColor.BLUE;
        } else if (percent >= 0.2 && percent < 0.4) {
            return PawnColor.GREEN;
        } else if (percent >= 0.4 && percent < 0.6) {
            return PawnColor.PINK;
        } else if (percent >= 0.6 && percent < 0.8) {
            return PawnColor.RED;
        } else {
            return PawnColor.YELLOW;
        }
    }

    /**
     * Method that extract a random student from the bag
     * and return it to the game
     * @return Student Object
     */
    //TODO create EmptyBagExcepton in bag
    public Student pickStudent() throws EmptyBagException {
        if (getNumberOfStudents() <= 0) {
            throw new EmptyBagException();
        }
        PawnColor color = extractColor();
        while (students.get(color) == 0) {
            color = extractColor();
        }
        students.put(color, students.get(color)-1);
        return new Student(color);
    }

    /**
     * Method that returns the total number of students in the bag
     * @return actualNumberOfStudents
     */
    public int getNumberOfStudents () {
        int actualNumberOfStudents = 0;
        for (PawnColor color : PawnColor.values()) {
            actualNumberOfStudents += students.get(color);
        }
        return actualNumberOfStudents;
    }
}
