package it.polimi.ingsw.s3m.launcher.Server.Model;

public class Island{
    private int id;             //from 0 to 11
    private int previousIslandId;
    private int nextIslandId;
    private int towers;
    private Player dominator = null;

    static private int idGen = 0;

    public Island() {
        this.id = idGen;
        idGen++;

        if(this.id == 11){
            this.nextIslandId = 0;
        }else{
            this.nextIslandId = this.id + 1;
        }

        if(this.id == 0){
            this.previousIslandId = 11;
        }else{
            this.nextIslandId = this.id - 1;
        }
    }

    public Player computeDominance(){

    }

    /**
     * Adds one tower to the island, it is called inside computeDominance()
     * @param tower
     */
    public void setTower(Tower tower){
       this.towers += 1;
    }

    /**
     * Method to merge islands, how to remove merged island from implementation?
     * @param islandToMerge
     */
    public void mergeIslands(Island islandToMerge){
        
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
}
