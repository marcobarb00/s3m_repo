package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class GameDTO implements Serializable{
	private int playersNumber;
	private boolean expertMode;
	private int motherNaturePosition;
	private PlayerDTO currentPlayer;
	private ArrayList<String> playerNicknames;
	private HashMap<String, DashboardDTO> dashboards;
	private HashMap<String, Integer> coins;
	private HashMap<String, String> towerColor;
	private ArrayList<CloudDTO> clouds;
	private HashMap<String, String> professors;
	private ArrayList<IslandDTO> islands;
	private ArrayList<CharacterCardDTO> characterCards;
	private TurnDTO turn;
	private HashMap<String, AssistantCardDTO> lastPlayedCards;

	public GameDTO(int playersNumber, boolean expertMode, int motherNaturePosition, PlayerDTO currentPlayer,
				   ArrayList<String> playerNicknames, HashMap<String, DashboardDTO> dashboards,
				   HashMap<String, Integer> coins, HashMap<String, String> towerColor, ArrayList<CloudDTO> clouds,
				   HashMap<String, String> professors, ArrayList<IslandDTO> islands, ArrayList<CharacterCardDTO> characterCards,
				   TurnDTO turn, HashMap<String, AssistantCardDTO> lastPlayedCards){
		this.expertMode = expertMode;
		this.motherNaturePosition = motherNaturePosition;
		this.currentPlayer = currentPlayer;
		this.playerNicknames = playerNicknames;
		this.dashboards = dashboards;
		this.coins = coins;
		this.towerColor = towerColor;
		this.clouds = clouds;
		this.professors = professors;
		this.islands = islands;
		this.characterCards = characterCards;
		this.turn = turn;
		this.playersNumber = playersNumber;
		this.lastPlayedCards = lastPlayedCards;
	}

	public HashMap<String, AssistantCardDTO> getLastPlayedCards() {
		return lastPlayedCards;
	}

	public int getPlayersNumber(){
		return playersNumber;
	}

	public boolean isExpertMode(){
		return expertMode;
	}

	public int getMotherNaturePosition(){
		return motherNaturePosition;
	}

	public PlayerDTO getCurrentPlayer(){
		return currentPlayer;
	}

	public ArrayList<String> getPlayerNicknames(){
		return playerNicknames;
	}

	public HashMap<String, DashboardDTO> getDashboards(){
		return dashboards;
	}

	public HashMap<String, Integer> getCoins(){
		return coins;
	}

	public HashMap<String, String> getTowerColor(){
		return towerColor;
	}

	public ArrayList<CloudDTO> getClouds(){
		return clouds;
	}

	public HashMap<String, String> getProfessors(){
		return professors;
	}

	public ArrayList<IslandDTO> getIslands(){
		return islands;
	}

	public ArrayList<CharacterCardDTO> getCharacterCards(){
		return characterCards;
	}

	public TurnDTO getTurn(){
		return turn;
	}
}
