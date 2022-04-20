package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard {
    private ArrayList<Student> hall;
    private ArrayList<Tower> towerList;
    private HashMap<PawnColor, Integer> tables;
    private ArrayList<PawnColor> controlledColors;

    public Dashboard() {
        this.hall = new ArrayList<>();
        this.towerList = new ArrayList<>();
        this.tables = new HashMap<>();
        this.controlledColors = new ArrayList<>();

        this.initializeTables(tables);
    }

    /**
     * Every time a tower is moved towerList shrinks
     * @return
     */
    public Tower moveTower() {
        Tower t = towerList.get(0);
        towerList.remove(0);
        return t;
    }

    /**
     * Needed for computeInfluenceIndex in Island class.
     * This doesn't screw up the reference of controlledColors
     * @return
     */
    public ArrayList<PawnColor> getControlledColors(){
        ArrayList<PawnColor> colors = new ArrayList<>();
        for (PawnColor color : controlledColors){
            colors.add(color);
        }
        return colors;
    }

    private void initializeTables(HashMap<PawnColor,Integer> tables){
        tables.put(PawnColor.PINK,0);
        tables.put(PawnColor.RED,0);
        tables.put(PawnColor.BLUE,0);
        tables.put(PawnColor.GREEN,0);
        tables.put(PawnColor.YELLOW,0);
    }

}
