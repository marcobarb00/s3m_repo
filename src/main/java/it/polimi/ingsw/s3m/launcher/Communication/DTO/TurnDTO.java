package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.util.ArrayList;
import java.util.HashMap;

public class TurnDTO{
	private String firstPlayerNickname;
	private String currentPlayerNickname;
	private String currentPhase;
	private ArrayList<AssistantCardDTO> playedCards;
	private boolean activatedCharacterCard;

	public TurnDTO(String firstPlayerNickname, String currentPlayerNickname, String currentPhase, ArrayList<AssistantCardDTO> playedCards, boolean activatedCharacterCard){
		this.firstPlayerNickname = firstPlayerNickname;
		this.currentPlayerNickname = currentPlayerNickname;
		this.currentPhase = currentPhase;
		this.playedCards = playedCards;
		this.activatedCharacterCard = activatedCharacterCard;
	}

	public String getFirstPlayerNickname(){
		return firstPlayerNickname;
	}

	public String getCurrentPlayerNickname(){
		return currentPlayerNickname;
	}

	public String getCurrentPhase(){
		return currentPhase;
	}

	public ArrayList<AssistantCardDTO> getPlayedCards(){
		return playedCards;
	}

	public boolean isActivatedCharacterCard(){
		return activatedCharacterCard;
	}
}
