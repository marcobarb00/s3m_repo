package it.polimi.ingsw.s3m.launcher.Server.Model;

public class Professor {
    private PawnColor color;
    private Player player;

    public Professor (PawnColor color) {
        this.color = color;
        player = null;
    }

    public Player getPlayer () { return player; }

    public PawnColor getColor () { return color; }

    /**
     * Method that change the player having the Professor
     * @param player
     */
    public void changePlayer (Player player) {
        this.player = player;
    }
}
