package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GameDTO implements Serializable{
	private boolean expertMode;
	private int motherNaturePosition;
	private HashMap<String, PlayerDTO> players;
	private ArrayList<CloudDTO> clouds;
	private HashMap<String, PlayerDTO> professors;
	private ArrayList<IslandDTO> islands;
	private ArrayList<CharacterCardDTO> characterCards;
	private ArrayList<AssistantCardDTO> playedAssistantCardsList;
	private String currentPlayerTurn;

	public GameDTO(boolean expertMode, int motherNaturePosition, HashMap<String, PlayerDTO> players, ArrayList<CloudDTO> clouds, HashMap<String, PlayerDTO> professors, ArrayList<IslandDTO> islands, ArrayList<CharacterCardDTO> characterCards, ArrayList<AssistantCardDTO> playedAssistantCardsList, String currentPlayerTurn){
		this.expertMode = expertMode;
		this.motherNaturePosition = motherNaturePosition;
		this.players = players;
		this.clouds = clouds;
		this.professors = professors;
		this.islands = islands;
		this.characterCards = characterCards;
		this.playedAssistantCardsList = playedAssistantCardsList;
		this.currentPlayerTurn = currentPlayerTurn;
	}

	public boolean isExpertMode(){
		return expertMode;
	}

	public int getMotherNaturePosition(){
		return motherNaturePosition;
	}

	public HashMap<String, PlayerDTO> getPlayers(){
		return players;
	}

	public ArrayList<CloudDTO> getClouds(){
		return clouds;
	}

	public HashMap<String, PlayerDTO> getProfessors(){
		return professors;
	}

	public ArrayList<IslandDTO> getIslands(){
		return islands;
	}

	public ArrayList<CharacterCardDTO> getCharacterCards(){
		return characterCards;
	}

	public ArrayList<AssistantCardDTO> getPlayedAssistantCardsList(){
		return playedAssistantCardsList;
	}

	public String getCurrentPlayerTurn(){
		return currentPlayerTurn;
	}
}