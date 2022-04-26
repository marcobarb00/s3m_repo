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

    public void addStudentsInHall (ArrayList<Student> hall) {
        this.hall.addAll(hall);
    }

    public void deleteStudentsFromTables (ArrayList<Student> deletingStudents) {
        for (Student student : deletingStudents) {
            hall.remove(student);
        }
    }

    // GETTER
    public ArrayList<Student> getHall() { return hall; }
    public HashMap<PawnColor, Integer> getTables() { return tables; }
    public int getNumberOfTowers() { return numberOfTowers; }

    // SETTER
    public void putStudentsInHall (ArrayList<Student> hall) { this.hall = hall; }
    public void setNumberOfTowers (int numberOfTowers) { this.numberOfTowers = numberOfTowers; }


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
            }
        }
    }
}

