package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard {
    private Player player;
    private ArrayList<Student> hall;
    private ArrayList<Tower> towerList;
    private HashMap<PawnColor, Integer> tables;

    public Dashboard (Player player) {
        this.player = player;
    }
}
