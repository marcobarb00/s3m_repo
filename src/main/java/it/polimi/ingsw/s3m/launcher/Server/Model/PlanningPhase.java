package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class PlanningPhase extends Phase{
    private Player player;
    private ArrayList<AssistantCard> playedCards;

    public PlanningPhase(Player player) {
        this.player = player;
    }

    @Override
    public void startPhase() {

    }

    private void playAssistantCard(){

    }
}
