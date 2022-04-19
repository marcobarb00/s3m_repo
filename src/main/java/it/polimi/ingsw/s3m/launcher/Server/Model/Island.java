package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.NotDominatedIslandException;

public class Island{
    private int id;             //from 0 to 11
    private Island previousIsland;
    private Island nextIsland;
    private int towers;
    private Player dominator = null;

    static private int idGen = 0;

    //TODO Setting next and prev islands for each one (setters)
    public Island() {
        this.id = idGen;
        idGen++;

    }

    public Player computeDominance(){
        return null;
    }

    /**
     * Adds one tower to the island, it is called inside computeDominance()
     * @param tower
     */
    public void setTower(Tower tower){
       this.towers += 1;
    }

    //TODO Merging with 3 islands if gets dominated the one in the middle of 2 dominated
    /**
     * Method to merge islands, how to remove merged island from implementation (in game class)?
     * Works for 3 islands too.
     */
    public void mergeIslands() throws NotDominatedIslandException {
        //Checks if it's the same Island

        if(this.dominator == null)
            throw new NotDominatedIslandException();

        if(this.dominator == this.nextIsland.getDominator()){
           this.towers = this.towers + this.nextIsland.getTowers();
           this.nextIsland = this.nextIsland.getNextIsland();
         }
        if(this.dominator == this.previousIsland.getDominator()){
            this.towers = this.towers + this.previousIsland.getTowers();
            this.previousIsland = this.previousIsland.getPreviousIsland();
        }
    }

    public int getId() {
        return id;
    }

    public int getTowers() {
        return towers;
    }

    /**
     * Dominator must be set after computeDominance call
     * @param dominator
     */
    public void setDominator(Player dominator) {
        this.dominator = dominator;
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
