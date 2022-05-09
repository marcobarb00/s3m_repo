package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.HashMap;

public class Turn {
    private String firstPlayerNickname;
    private String currentPlayerNickname;
    private String phaseName;
    // Planning phase
    private int movedStudents = 0;
    private final HashMap<String, AssistantCard> playedCards = new HashMap<>();
    // Action phase
    private boolean activatedCharacterCard = false;

    public Turn(String firstPlayerNickname) {
        this.firstPlayerNickname = firstPlayerNickname;
        this.currentPlayerNickname = firstPlayerNickname;
        this.phaseName = "PlanningPhase";
    }

    public void incrementMovedStudents() { movedStudents++; }

    public void addPlayedCard(String playerNickname, AssistantCard assistantCard) {
        playedCards.put(playerNickname, assistantCard);
    }

    // GETTER
    public String getFirstPlayerNickname() { return firstPlayerNickname; }
    public String getCurrentPlayerNickname() { return currentPlayerNickname; }
    public String getPhaseName() { return phaseName; }
    public int getMovedStudents() { return movedStudents; }
    public HashMap<String, AssistantCard> getPlayedCards() { return playedCards; }
    public boolean isActivatedCharacterCard() { return activatedCharacterCard; }

    // SETTER
    public void setFirstPlayerNickname(String firstPlayerNickname) {
        this.firstPlayerNickname = firstPlayerNickname;
    }
    public void setCurrentPlayerNickname(String currentPlayerNickname) {
        this.currentPlayerNickname = currentPlayerNickname;
    }
    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }
    public void setActivatedCharacterCard(boolean activatedCharacterCard) {
        this.activatedCharacterCard = activatedCharacterCard;
    }
}
