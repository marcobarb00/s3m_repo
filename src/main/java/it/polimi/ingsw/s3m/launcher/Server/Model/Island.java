package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Island {
    private Player dominator = null;
    private HashMap<PawnColor, Integer> students;
    private int numberOfTowers;

    public Island() {
        students = new HashMap<>();
        for (PawnColor color : PawnColor.values()) {
            students.put(color, 0);
        }
        this.numberOfTowers = 0;
    }

    // Adding students
    public void addStudent(Student student){
        PawnColor color = student.getColor();
        students.replace(color, students.get(color)+1);
    }

    public void addStudentsOnIsland(ArrayList<Student> islandStudents) {
        for (Student student : islandStudents) {
            PawnColor color = student.getColor();
            students.replace(color, students.get(color)+1);
        }
    }

    // Towers
    public void sumTower(int addend) { numberOfTowers += addend; }

    // GETTER
    public Player getDominator() { return dominator; }
    public HashMap<PawnColor, Integer> getStudents() { return students; }
    public int getStudentsPerColor(PawnColor pawnColor) { return students.get(pawnColor); }
    public int getNumberOfTowers() { return numberOfTowers; }

    // SETTER
    public void setDominator(Player dominator) { this.dominator = dominator; }
    public void addTower() { numberOfTowers++; }
}
