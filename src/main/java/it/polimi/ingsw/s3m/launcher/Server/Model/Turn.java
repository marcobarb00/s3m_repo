package it.polimi.ingsw.s3m.launcher.Server.Model;

public class Turn {
    private String currentPlayerNickname;
    private Phase currentPhase;

    public Turn(String firstPlayerNickname) {
        this.currentPlayerNickname = firstPlayerNickname;
    }

    // GETTER
    public Phase getCurrentPhase() { return currentPhase; }
}
