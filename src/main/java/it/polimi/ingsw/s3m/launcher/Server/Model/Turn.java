package it.polimi.ingsw.s3m.launcher.Server.Model;


public class Turn {
    private Player player;
    private Phase phase;
    private int winCondition;

    public Turn(Player player, Phase phase, int winCondition) {
        this.player = player;
        this.phase = phase;
        this.winCondition = winCondition;
    }
}
