package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private String nickname;
    private TowerColor color;
    private Dashboard dashboard;
    private ArrayList<AssistantCard> hand;
    private AssistantCard lastCardPlayed;

    public Player (String nickname, TowerColor color) {
        this.nickname = nickname;
        this.color = color;
        this.dashboard = new Dashboard();
        this.hand = new ArrayList<>();
        hand.addAll(Arrays.asList(AssistantCard.values()));
    }

    public void removeAssistantCardFromHand(int position) {
        hand.remove(position);
    }

    // GETTER
    public String getNickname() { return nickname; }
    public TowerColor getColor() { return color; }
    public Dashboard getDashboard() { return dashboard; }
    public ArrayList<AssistantCard> getHand() { return hand; }
    public AssistantCard getLastCardPlayed() { return lastCardPlayed; }

    // SETTER
    public void setLastCardPlayed(AssistantCard lastCardPlayed) { this.lastCardPlayed = lastCardPlayed; }
}
