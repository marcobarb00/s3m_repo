package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.NotDominatedIslandException;

import java.util.ArrayList;
import java.util.HashMap;


//TODO Decide where to instantiate
public class Island{
    private int id;               //from 0 to 11
    private Island previousIsland;
    private Island nextIsland;
    private int towers = 0;
    private HashMap<PawnColor,Integer> students;
    private Player dominator = null;

    //TODO Setting next and prev islands for each one (setters)
    public Island(int id) {
        this.id = id;
        this.students = new HashMap<>();
        this.students.put(PawnColor.BLUE,0);
        this.students.put(PawnColor.RED,0);
        this.students.put(PawnColor.GREEN,0);
        this.students.put(PawnColor.YELLOW,0);
        this.students.put(PawnColor.PINK,0);
    }

    public void setPreviousIsland(Island previousIsland) {
        this.previousIsland = previousIsland;
    }

    public void setNextIsland(Island nextIsland) {
        this.nextIsland = nextIsland;
    }


    /*
    * if(island.getNext() != islands.get(n).getNext())
    *
    *
    * currentIsland
    * for(1<moves)
    *   currentIsland = currentIsland.getNext()
    *
    * currentIsland
    *
    * */

    /**
     * Could be called inside Game
     * @param players
     */
    public void computeDominance(ArrayList<Player> players){
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
        //mergeIsland call

    }

    /**
     * Computes influenceIndex for that player
     * @param player
     * @return
     */
    private int computeInfluenceIndex(Player player){
        int influenceIndex = 0;
        ArrayList<PawnColor> controlledColors = player.getDashboard().getControlledColors();

        for (PawnColor color : controlledColors){
            influenceIndex += getStudents(color);
        }

        if(player != null){
            if(player == this.dominator){
                influenceIndex += this.towers;
            }
        }

        return influenceIndex;
    }


    /**
     * Method to merge islands, TODO how to remove merged island from implementation (in game class)?
     * Works for 3 islands too.
     */
    public void mergeIslands() throws NotDominatedIslandException {
        //Checks if it's the same Island

        if(this.dominator == null)
            throw new NotDominatedIslandException();

        if(this.dominator == this.nextIsland.getDominator()){
           this.towers += this.nextIsland.getTowers();
           this.sumStudentsNextIsland();
           this.nextIsland = this.nextIsland.getNextIsland();
         }
        if(this.dominator == this.previousIsland.getDominator()){
            this.towers = this.towers + this.previousIsland.getTowers();
            this.sumStudentsPreviousIsland();
            this.previousIsland = this.previousIsland.getPreviousIsland();
        }
    }

    /**
     * For each color of student the method sums them to merge islands
     */
    private void sumStudentsNextIsland(){
        for (PawnColor color : this.students.keySet()){
            this.students.replace(color,this.getStudents(color) + this.nextIsland.getStudents(color));
        }
    }

    private void sumStudentsPreviousIsland(){
        for (PawnColor color : this.students.keySet()){
            this.students.replace(color,this.getStudents(color) + this.previousIsland.getStudents(color));

        }
    }

    /**
     * Dominator must be set after computeDominance call
     * @param dominator
     */
    public void setDominator(Player dominator) {
        this.dominator = dominator;
        this.setTower(dominator.getDashboard().moveTower());
    }

    /**
     * Adds one tower to the island, it is called inside setDominator
     * @param tower
     */
    private void setTower(Tower tower){
        this.towers += 1;
    }

    public int getId() {
        return id;
    }

    /**
     *
     * @param pawnColor
     * @return
     */
    public int getStudents(PawnColor pawnColor) {
        return this.students.get(pawnColor);
    }

    public int getTowers() {
        return towers;
    }

    public Player getDominator() {
        return dominator;
    }

    public Island getPreviousIsland() {
        return previousIsland;
    }

    public Island getNextIsland() {
        return nextIsland;
    }
}
