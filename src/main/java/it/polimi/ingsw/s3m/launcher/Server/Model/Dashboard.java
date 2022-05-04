package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard {
    private HashMap<PawnColor, Integer> entrance;
    private HashMap<PawnColor, Integer> tables;
    private int numberOfTowers;

    public Dashboard() {
        this.entrance = new HashMap<>();
        this.tables = new HashMap<>();
        for (PawnColor color : PawnColor.values()) {
            entrance.put(color, 0);
            tables.put(color, 0);
        }
    }

    // Entrance
    public void addStudentsInEntrance (ArrayList<Student> enteringStudents) {
        for (Student student : enteringStudents) {
            PawnColor color = student.getColor();
            entrance.replace(color, entrance.get(color)+1);
        }
    }

    public void deleteStudentsFromEntrance (ArrayList<Student> deletingStudents) {
        for (Student student : deletingStudents) {
            PawnColor color = student.getColor();
            entrance.replace(color, entrance.get(color)-1);
        }
    }

    // Tables
    public void deleteStudentsFromTables (ArrayList<Student> deletingStudents) {
        for (Student student : deletingStudents) {
            PawnColor color = student.getColor();
            tables.replace(color, tables.get(color)-1);
        }
    }

    public int moveStudentsFromEntranceToTables (ArrayList<Student> movingStudents) {
        int earnCoins = 0;
        for (Student student : movingStudents) {
            PawnColor color = student.getColor();
            entrance.replace(color, entrance.get(color)-1);
            tables.replace(color, tables.get(color)+1);
            if (tables.get(color) % 3 == 0) earnCoins++;
        }
        return earnCoins;
    }

    // Towers
    public void incrementTowers() { numberOfTowers++; }
    public void decrementTowers() { numberOfTowers--; }

    // GETTER
    public HashMap<PawnColor, Integer> getEntrance() { return entrance; }
    public HashMap<PawnColor, Integer> getTables() { return tables; }
    public int getNumberOfTowers() { return numberOfTowers; }

    // SETTER
    public void setNumberOfTowers (int numberOfTowers) { this.numberOfTowers = numberOfTowers; }
}

