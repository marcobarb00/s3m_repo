package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard {
    private ArrayList<Student> hall;
    private HashMap<PawnColor, Integer> tables;
    private int numberOfTowers;

    public Dashboard() {
        this.hall = new ArrayList<>();
        this.tables = new HashMap<>();
        for (PawnColor color : PawnColor.values()) {
            tables.put(color, 0);
        }
    }

    // Hall
    public void addStudentsInHall (ArrayList<Student> hall) {
        this.hall.addAll(hall);
    }

    public void deleteStudentsFromHall (ArrayList<Student> deletingStudents) {
        for (Student student : deletingStudents) hall.remove(student);
    }

    // Tables
    public void deleteStudentsFromTables (ArrayList<Student> deletingStudents) {
        for (Student student : deletingStudents) {
            PawnColor color = student.getColor();
            tables.replace(color, tables.get(color)-1);
        }
    }

    public int moveStudentsFromHallToTables (ArrayList<Student> movingStudents) {
        int earnCoins = 0;
        for (Student student : movingStudents) {
            PawnColor color = student.getColor();
            tables.replace(color, tables.get(color)+1);
            if (tables.get(color) % 3 == 0) earnCoins++;
            hall.remove(student);
        }
        return earnCoins;
    }

    // GETTER
    public ArrayList<Student> getHall() { return hall; }
    public HashMap<PawnColor, Integer> getTables() { return tables; }
    public int getNumberOfTowers() { return numberOfTowers; }

    // SETTER
    public void putStudentsInHall (ArrayList<Student> hall) { this.hall = hall; }
    public void setNumberOfTowers (int numberOfTowers) { this.numberOfTowers = numberOfTowers; }
}

