package it.polimi.ingsw.s3m.launcher.Server.Model;

public class Turn {
    private String currentPlayerNickname;
    private Phase currentPhase;

    public Turn(String firstPlayerNickname) {
        this.currentPlayerNickname = firstPlayerNickname;
    }

    // GETTER
    public String getCurrentPlayerNickname() { return currentPlayerNickname; }
    public Phase getCurrentPhase() { return currentPhase; }
}
