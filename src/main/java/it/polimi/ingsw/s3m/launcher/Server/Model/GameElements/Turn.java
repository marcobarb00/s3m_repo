package it.polimi.ingsw.s3m.launcher.Server.Model.GameElements;

import java.util.HashMap;

public class Turn{
	private String firstPlayerNickname;
	private String currentPlayerNickname;
	private String phaseName = "PlanningPhase";
	// Planning phase
	private int movedStudents = 0;
	private HashMap<String, AssistantCard> playedCards = new HashMap<>();
	// Action phase
	private boolean activatedCharacterCard = false;
	private int motherNatureMaxAllowedMovements = 0;

	public Turn(String firstPlayerNickname){
		this.firstPlayerNickname = firstPlayerNickname;
		this.currentPlayerNickname = firstPlayerNickname;
	}

	public void incrementMovedStudents(){
		movedStudents++;
	}

	public void resetMovedStudents(){
		movedStudents = 0;
	}

	public void addPlayedCard(String playerNickname, AssistantCard assistantCard){
		playedCards.put(playerNickname, assistantCard);
	}

	// GETTER
	public String getFirstPlayerNickname(){
		return firstPlayerNickname;
	}

	public String getCurrentPlayerNickname(){
		return currentPlayerNickname;
	}

	public String getPhaseName(){
		return phaseName;
	}

	public int getMovedStudents(){
		return movedStudents;
	}

	public HashMap<String, AssistantCard> getPlayedCards(){
		return playedCards;
	}

	public boolean isActivatedCharacterCard(){
		return activatedCharacterCard;
	}

	public int getMotherNatureMaxAllowedMovements(){
		return motherNatureMaxAllowedMovements;
	}

	// SETTER
	public void setFirstPlayerNickname(String firstPlayerNickname){
		this.firstPlayerNickname = firstPlayerNickname;
	}

	public void setCurrentPlayerNickname(String currentPlayerNickname){
		this.currentPlayerNickname = currentPlayerNickname;
	}

	public void setPhaseName(String phaseName){
		this.phaseName = phaseName;
	}

	public void setPlayedCards(HashMap<String, AssistantCard> playedCards){
		this.playedCards = playedCards;
	}

	public void setActivatedCharacterCard(boolean activatedCharacterCard){
		this.activatedCharacterCard = activatedCharacterCard;
	}

	public void setMotherNatureMaxAllowedMovements(int motherNatureMaxAllowedMovements){
		this.motherNatureMaxAllowedMovements = motherNatureMaxAllowedMovements;
	}
}
