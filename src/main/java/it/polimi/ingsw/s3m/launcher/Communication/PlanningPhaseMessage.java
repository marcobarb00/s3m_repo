package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.IslandDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.PlayerDTO;

import java.util.ArrayList;
import java.util.HashMap;

public class PlanningPhaseMessage implements Message{
	private ArrayList<IslandDTO> islandList;
	private HashMap<String, String> professors;
	private HashMap<String, PlayerDTO> players;
	private ArrayList<AssistantCardDTO> playedCards;
	private String currentPlayer;

	public ArrayList<IslandDTO> getIslandList(){
		return islandList;
	}

	public void setIslandList(ArrayList<IslandDTO> islandList){
		this.islandList = islandList;
	}

	public HashMap<String, String> getProfessors(){
		return professors;
	}

	public void setProfessors(HashMap<String, String> professors){
		this.professors = professors;
	}

	public HashMap<String, PlayerDTO> getPlayers(){
		return players;
	}

	public void setPlayers(HashMap<String, PlayerDTO> players){
		this.players = players;
	}

	public ArrayList<AssistantCardDTO> getPlayedCards(){
		return playedCards;
	}

	public void setPlayedCards(ArrayList<AssistantCardDTO> playedCards){
		this.playedCards = playedCards;
	}

	public String getCurrentPlayer(){
		return currentPlayer;
	}

	public void setCurrentPlayer(String currentPlayer){
		this.currentPlayer = currentPlayer;
	}

	@Override
	public void apply(View view){
		view.planningPhase(this);
	}
}
