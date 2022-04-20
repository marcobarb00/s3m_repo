package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;

import java.util.ArrayList;

public class Cloud {
    private Game game;
    private final int id;
    private ArrayList<Student> studentList;

    public Cloud (Game game, int id) {
        this.game = game;
        this.id = id;
        this.studentList = new ArrayList<Student>();
    }

    public void refillThreeStudents () {
        if (studentList.size() != 0) return;
        for (int i = 0; i < 3; i++) {
            try {
                studentList.add(game.getBag().pickStudent());
            } catch (EmptyBagException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Student> returnThreeStudents() { return studentList; }

    public int getId() { return id; }
}
