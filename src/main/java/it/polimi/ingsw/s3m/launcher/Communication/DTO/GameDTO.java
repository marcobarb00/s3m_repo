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
	private ArrayList<CloudDTO> clouds;
	private HashMap<String, String> professors;
	private ArrayList<IslandDTO> islands;
	private ArrayList<CharacterCardDTO> characterCards;
	private TurnDTO turn;

	public GameDTO(int playersNumber, boolean expertMode, int motherNaturePosition, PlayerDTO currentPlayer, ArrayList<String> playerNicknames, HashMap<String, DashboardDTO> dashboards, HashMap<String, Integer> coins, ArrayList<CloudDTO> clouds, HashMap<String, String> professors, ArrayList<IslandDTO> islands, ArrayList<CharacterCardDTO> characterCards, TurnDTO turn){
		this.expertMode = expertMode;
		this.motherNaturePosition = motherNaturePosition;
		this.currentPlayer = currentPlayer;
		this.playerNicknames = playerNicknames;
		this.dashboards = dashboards;
		this.coins = coins;
		this.clouds = clouds;
		this.professors = professors;
		this.islands = islands;
		this.characterCards = characterCards;
		this.turn = turn;
		this.playersNumber = playersNumber;
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
