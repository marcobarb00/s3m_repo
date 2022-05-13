package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class TurnDTO implements Serializable{
	private final String firstPlayerNickname;
	private final String currentPlayerNickname;
	private final String currentPhase;
	private final HashMap<String, AssistantCardDTO> playedCards;
	private final boolean CharacterCardActivated;

	public TurnDTO(String firstPlayerNickname, String currentPlayerNickname, String currentPhase, HashMap<String, AssistantCardDTO> playedCards, boolean CharacterCardActivated){
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

	public HashMap<String, AssistantCardDTO> getPlayedCards(){
		return playedCards;
	}

	public boolean isCharacterCardActivated(){
		return CharacterCardActivated;
	}
}
