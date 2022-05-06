package it.polimi.ingsw.s3m.launcher.Server.Model;

public class Turn {
    private String firstPlayerNickname;
    private String currentPlayerNickname;
    private Phase currentPhase;
    private boolean activatedCharacterCard;

    public Turn(String firstPlayerNickname) {
        this.currentPlayerNickname = firstPlayerNickname;
        this.currentPhase = new PlanningPhase();
    }

    // GETTER
    public String getFirstPlayerNickname() { return firstPlayerNickname; }
    public String getCurrentPlayerNickname() { return currentPlayerNickname; }
    public Phase getCurrentPhase() { return currentPhase; }
    public boolean isActivatedCharacterCard() { return activatedCharacterCard; }

    // SETTER
    public void setFirstPlayerNickname(String firstPlayerNickname) {
        this.firstPlayerNickname = firstPlayerNickname;
    }
    public void setCurrentPlayerNickname(String currentPlayerNickname) {
        this.currentPlayerNickname = currentPlayerNickname;
    }
    public void setCurrentPhase(Phase currentPhase) {
        this.currentPhase = currentPhase;
    }
    public void setActivatedCharacterCard(boolean activatedCharacterCard) {
        this.activatedCharacterCard = activatedCharacterCard;
    }
}
