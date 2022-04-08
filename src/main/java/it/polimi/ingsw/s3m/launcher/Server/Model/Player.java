package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class Player {
    private String nickname;
    private int coins;
    private AssistantCard lastCardPlayed;
    private Dashboard dashboard;
    private ArrayList<AssistantCard> hand;
    private Cloud cloud;

    public Player (Dashboard dashboard, String nickname) {
        this.nickname = nickname;
        this.dashboard = dashboard;
        this.coins = 1;
        hand = new ArrayList<AssistantCard>();
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
    public void getStudentsFromCloud () {
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
