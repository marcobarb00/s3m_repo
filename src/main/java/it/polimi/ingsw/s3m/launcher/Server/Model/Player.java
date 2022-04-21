package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class Player {
    private String nickname;
    private int coins;
    private AssistantCard lastCardPlayed;
    private Dashboard dashboard;
    private ArrayList<AssistantCard> hand;

    public Player (String nickname) {
        this.nickname = nickname;
        this.coins = 1;
        this.dashboard = new Dashboard();
        this.hand = new ArrayList<>();
        for (AssistantCard card : AssistantCard.values()) {
            hand.add(card);
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public AssistantCard getLastCardPlayed() {
        return lastCardPlayed;
    }

    public void setLastCardPlayed(AssistantCard lastCardPlayed) {
        this.lastCardPlayed = lastCardPlayed;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public ArrayList<AssistantCard> getHand() {
        return hand;
    }

    public void setHand(ArrayList<AssistantCard> hand) {
        this.hand = hand;
    }

    /**
     * Method that return the AssistantCard played
     * by the player
     * @return hand.get(position)
     */
    public AssistantCard playAssistantCard (int position) {
        return hand.get(position);
    }

    /**
     *
     * @return
     */
    public void getStudentsFromCloud (Cloud cloud) {
    }

    /**
     * Method that update the value of coins (?)
     */
    public void addCoins () {
        coins++;
    }

    /**
     * Method that chooses a CharacterCard and active
     * its effect
     */
    public void activeCharacterCardEffect () {
    }
}
