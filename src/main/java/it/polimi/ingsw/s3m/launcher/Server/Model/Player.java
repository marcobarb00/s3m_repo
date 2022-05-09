package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Player{
	private final String nickname;
	private final TowerColor color;
	private final Dashboard dashboard;
	private final ArrayList<AssistantCard> hand;
	private AssistantCard lastPlayedCard = null;
	private int coins = 0;

	/**
	 * Constructor used to initialize player's attributes
	 *
	 * @param nickname unique nickname of the player
	 * @param color    color of the player's towers
	 */
	public Player(String nickname, TowerColor color){
		this.nickname = nickname;
		this.color = color;
		this.dashboard = new Dashboard();
		this.hand = new ArrayList<>();
		hand.addAll(Arrays.asList(AssistantCard.values()));
	}

	/**
	 * Method used to remove an assistant card from the player's hand when played
	 * in the planning phase
	 *
	 * @param position position in hand of the card to be removed
	 */
	public void removeAssistantCardFromHand(int position){
		hand.remove(position);
	}

	// Coins
	public void addCoins(int earnCoins){
		coins += earnCoins;
	}

	public void removeCoins(int usedCoins){
		coins -= usedCoins;
	}

	// GETTER
	public String getNickname(){
		return nickname;
	}

	public TowerColor getColor(){
		return color;
	}

	public Dashboard getDashboard(){
		return dashboard;
	}

	public ArrayList<AssistantCard> getHand(){
		return hand;
	}

	public AssistantCard getLastPlayedCard(){
		return lastPlayedCard;
	}

	public int getCoins(){
		return coins;
	}

	// SETTER
	public void setLastPlayedCard(AssistantCard lastPlayedCard){
		this.lastPlayedCard = lastPlayedCard;
	}
}
