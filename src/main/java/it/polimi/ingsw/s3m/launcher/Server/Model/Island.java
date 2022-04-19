package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.NotDominatedIslandException;

import java.util.ArrayList;

public class Island{
    private final int id;               //from 0 to 11
    private Island previousIsland;
    private Island nextIsland;
    private int towers;
    private int blueStudents;               //
    private int yellowStudents;               //
    private int greenStudents;               //
    private int redStudents;               //
    private int pinkStudents;               //
    private Player dominator = null;

    static private int idGen = 0;

    //TODO Setting next and prev islands for each one (setters)
    public Island() {
        this.id = idGen;
        idGen++;
    }

    public Player computeDominance(){

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
           this.towers = this.towers + this.nextIsland.getTowers();
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
        this.blueStudents = this.blueStudents + this.nextIsland.getStudents(PawnColor.BLUE);
        this.greenStudents = this.greenStudents + this.nextIsland.getStudents(PawnColor.GREEN);
        this.yellowStudents = this.yellowStudents + this.nextIsland.getStudents(PawnColor.YELLOW);
        this.pinkStudents = this.pinkStudents + this.nextIsland.getStudents(PawnColor.PINK);
        this.redStudents = this.redStudents + this.nextIsland.getStudents(PawnColor.RED);
    }

    private void sumStudentsPreviousIsland(){
        this.blueStudents = this.blueStudents + this.previousIsland.getStudents(PawnColor.BLUE);
        this.greenStudents = this.greenStudents + this.previousIsland.getStudents(PawnColor.GREEN);
        this.yellowStudents = this.yellowStudents + this.previousIsland.getStudents(PawnColor.YELLOW);
        this.pinkStudents = this.pinkStudents + this.previousIsland.getStudents(PawnColor.PINK);
        this.redStudents = this.redStudents + this.previousIsland.getStudents(PawnColor.RED);
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
        if (pawnColor == PawnColor.BLUE){
            return blueStudents;
        }
        if (pawnColor == PawnColor.YELLOW){
            return yellowStudents;
        }
        if (pawnColor == PawnColor.GREEN){
            return greenStudents;
        }
        if (pawnColor == PawnColor.RED){
            return redStudents;
        }
        if (pawnColor == PawnColor.PINK){
            return pinkStudents;
        }
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
