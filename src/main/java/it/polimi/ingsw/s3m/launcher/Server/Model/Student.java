package it.polimi.ingsw.s3m.launcher.Server.Model;

public class Student {
    private final PawnColor color;

    /**
     * Constructor of the Student class
     * @param color color assigned to the student
     */
    public Student (PawnColor color) {
        this.color = color;
    }

    public PawnColor getColor () { return color; }
}
