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

    public void changePlayer (Player player) {
        this.player = player;
    }
}
