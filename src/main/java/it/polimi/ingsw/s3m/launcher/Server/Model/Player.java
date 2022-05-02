package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private final String nickname;
    private final TowerColor color;
    private Dashboard dashboard;
    private ArrayList<AssistantCard> hand;
    private AssistantCard lastCardPlayed = null;
    private int coins = 0;

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

    // Coins
    public void addCoins (int earnCoins) {
        coins += earnCoins;
    }
    public void removeCoins (int usedCoins) {
        coins -= usedCoins;
    }

    // GETTER
    public String getNickname() { return nickname; }
    public TowerColor getColor() { return color; }
    public Dashboard getDashboard() { return dashboard; }
    public ArrayList<AssistantCard> getHand() { return hand; }
    public AssistantCard getLastCardPlayed() { return lastCardPlayed; }
    public int getCoins() { return coins; }

    // SETTER
    public void setLastCardPlayed(AssistantCard lastCardPlayed) { this.lastCardPlayed = lastCardPlayed; }
}
