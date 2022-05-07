package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.io.Serializable;
import java.util.ArrayList;

public class TurnDTO implements Serializable{
	private String firstPlayerNickname;
	private String currentPlayerNickname;
	private String currentPhase;
	private ArrayList<AssistantCardDTO> playedCards;
	private boolean CharacterCardActivated;

	public TurnDTO(String firstPlayerNickname, String currentPlayerNickname, String currentPhase, ArrayList<AssistantCardDTO> playedCards, boolean CharacterCardActivated){
		this.firstPlayerNickname = firstPlayerNickname;
		this.currentPlayerNickname = currentPlayerNickname;
		this.currentPhase = currentPhase;
		this.playedCards = playedCards;
		this.CharacterCardActivated = CharacterCardActivated;
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

	public boolean isCharacterCardActivated(){
		return CharacterCardActivated;
	}
}
