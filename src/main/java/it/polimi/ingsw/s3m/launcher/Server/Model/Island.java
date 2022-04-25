package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;

import java.util.ArrayList;
import java.util.HashMap;


//TODO Decide where to instantiate
public class Island{
    private int id;
    private Island previousIsland;
    private Island nextIsland;
    private HashMap<PawnColor,Integer> students;

    private Player dominator = null;
    private int towers = 0;

    //TODO Setting next and prev islands for each one (setters)
    public Island(int id) {
        this.id = id;
        students = new HashMap<>();
        for (PawnColor color : PawnColor.values()) {
            students.put(color, 0);
        }
    }

    // GETTER
    public int getId() { return id; }
    public Island getPreviousIsland() { return previousIsland; }
    public Island getNextIsland() { return nextIsland; }
    public HashMap<PawnColor, Integer> getStudents() { return students; }
    public int getTowers() {
        return towers;
    }
    public int getStudentsPerColor(PawnColor pawnColor) { return students.get(pawnColor); }
    public Player getDominator() {
        return dominator;
    }

    // SETTER
    public void setPreviousIsland(Island previousIsland) { this.previousIsland = previousIsland; }
    public void setNextIsland(Island nextIsland) { this.nextIsland = nextIsland; }
    private void setTower(Tower tower){
        this.towers += 1;
    }

    public void addStudent(Student student){
        PawnColor color = student.getColor();
        Integer oldValue = students.get(student.getColor());
        students.replace(color, oldValue + 1);
    }

    public void setDominator(Player dominator) {
        this.dominator = dominator;
        this.setTower(dominator.getDashboard().moveTower());
    }


    // Thing to change

    /*public int computeDominance(ArrayList<Player> players){
        Player possibleDominator = null;
        int maxInfluenceIndex = 0;

        for(Player p : players){
            int index = this.computeInfluenceIndex(p);
            if(index > maxInfluenceIndex){
                maxInfluenceIndex = index;
                possibleDominator = p;
            }
        }

        setDominator(possibleDominator);
        return this.mergeIslands();         //exit code of mergeIslands
    }*/

    /*private int computeInfluenceIndex(Player player){
        int influenceIndex = 0;

        //TODO game not more passed to island
        ArrayList<Professor> professorsList = game.getProfessorsList();
        ArrayList<PawnColor> controlledColors = new ArrayList<>();

        for (Professor professor : professorsList){
            if(professor.getPlayer() == player){
                controlledColors.add(professor.getColor());
            }
        }

        for (PawnColor color : controlledColors){
            influenceIndex += getStudents(color);
        }

        if(player != null){
            if(player == this.dominator){
                influenceIndex += this.towers;
            }
        }

        return influenceIndex;
    }*/

    /*private int mergeIslands(){
        int exitCode = 0;   //do nothing case
        if(this.dominator == this.previousIsland.getDominator()){
            this.towers = this.towers + this.previousIsland.getTowers();
            this.sumStudentsPreviousIsland();
            this.previousIsland = this.previousIsland.getPreviousIsland();
            exitCode = 1;           //only previous island merged
        }
        if(this.dominator == this.nextIsland.getDominator()){
            this.towers += this.nextIsland.getTowers();
            this.sumStudentsNextIsland();
            this.nextIsland = this.nextIsland.getNextIsland();
            if(exitCode == 1){
                exitCode = 3;       //both prev and next merged
            }else {
                exitCode = 2;       //only next island merged
            }
        }

        return exitCode;
    }*/

    private void sumStudentsNextIsland(){
        for (PawnColor color : this.students.keySet()){
            this.students.replace(color,this.getStudentsPerColor(color) + this.nextIsland.getStudentsPerColor(color));
        }
    }

    private void sumStudentsPreviousIsland(){
        for (PawnColor color : this.students.keySet()){
            this.students.replace(color,this.getStudentsPerColor(color) + this.previousIsland.getStudentsPerColor(color));

        }
    }
}
