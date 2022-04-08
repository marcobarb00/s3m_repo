package it.polimi.ingsw.s3m.launcher.Server.Model;

public class Game {
    private int numberOfPlayer;

    public Game (int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public void startGame () {
        System.out.println("Game started with " + numberOfPlayer + " players");
    }
}
