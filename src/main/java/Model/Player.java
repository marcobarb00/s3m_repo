package Model;

import java.util.ArrayList;

public class Player {
    private String nickname;
    private int coins;
    private AssistantCard lastCardPlayed;
    private Dashboard dashboard;
    private ArrayList<AssistantCard> hand;

    public Player (Dashboard dashboard, String nickname) {
        this.nickname = nickname;
        this.dashboard = dashboard;
        this.coins = 1;
        hand = new ArrayList<AssistantCard>();
    }

    public AssistantCard playAssistantCard () {

    }
}
