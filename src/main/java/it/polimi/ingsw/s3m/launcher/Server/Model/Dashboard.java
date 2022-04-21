package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard {
    private ArrayList<Student> hall;
    private ArrayList<Tower> towerList;
    private HashMap<PawnColor, Integer> tables;
    private int coins;


    public Dashboard() {
        this.hall = new ArrayList<>();
        this.towerList = new ArrayList<>();
        this.tables = new HashMap<>();
        for (PawnColor color : PawnColor.values()) {
            tables.put(color, 0);
        }
        this.coins = 1;
    }


    /**
     * Every time a tower is moved towerList shrinks
     *
     * @return
     */
    public Tower moveTower() {
        Tower t = towerList.get(0);
        towerList.remove(0);
        return t;
    }

    public void putStudentsInTables(ArrayList<Student> students) {
        for (Student s : students) {
            tables.replace(s.getColor(), tables.get(s.getColor()) + 1);
            if (tables.get(s.getColor()) % 3 == 0) {
                coins++;
            }
        }
    }

    /**
     * Given an Arraylist
     *
     * @param students
     */
    public void putStudentsInHall(ArrayList<Student> students) {
        for (Student s : students) {
            this.hall.add(s);
        }
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }


    public int getCoins() {
        return coins;
    }
}

