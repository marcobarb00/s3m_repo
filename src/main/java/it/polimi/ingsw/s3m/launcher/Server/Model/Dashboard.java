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

    public void addStudentsInHall(ArrayList<Student> hall) {
        this.hall.addAll(hall);
    }

    // SETTER
    public void putStudentsInHall (ArrayList<Student> hall) { this.hall = hall; }



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

    /**
     * Students can have from 0 to 3 students. Method removes students from hall and puts them
     *         in tables
     * @param students
     * @throws Exception
     */
    public void moveStudentsFromHallToTables(ArrayList<Student> students) throws Exception {
        if(hall.isEmpty() || students.isEmpty()) {
            throw new Exception("Empty hall or students");
        }

        for (Student s : students) {
            tables.replace(s.getColor(), tables.get(s.getColor()) + 1);
            boolean studentFound = false;
            for(Student studentInHall : hall){
                if(studentInHall.getColor() == s.getColor()){
                    hall.remove(studentInHall);
                    studentFound = true;
                    break;
                }
            }
            //If there isn't a student of that color throws exception
            if(!studentFound){
                throw new Exception("No such student in hall");
            }
            if (tables.get(s.getColor()) % 3 == 0) {
                coins++;
            }
        }
    }



    //setters
    public void setCoins(int coins) { this.coins = coins; }


    //getters
    public ArrayList<Student> getHall() { return hall; }
    public int getCoins() { return coins; }
    public int getTables(PawnColor color) { return tables.get(color); }
}

