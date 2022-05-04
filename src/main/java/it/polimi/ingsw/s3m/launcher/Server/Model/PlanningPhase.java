package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class PlanningPhase extends Phase{
    private ArrayList<AssistantCard> playedCards = new ArrayList<>();

    public void addPlayedCard(AssistantCard assistantCard) {
        playedCards.add(assistantCard);
    }

    // GETTER
    public ArrayList<AssistantCard> getPlayedCards() { return playedCards; }
}
