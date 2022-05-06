package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.HashMap;

public class PlanningPhase extends Phase {
    private HashMap<String, AssistantCard> playedCards = new HashMap<>();

    public void addPlayedCard(String playerNickname, AssistantCard assistantCard) {
        playedCards.put(playerNickname, assistantCard);
    }

    // GETTER
    public HashMap<String, AssistantCard> getPlayedCards() { return playedCards; }
}
