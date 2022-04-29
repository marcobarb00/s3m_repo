package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.DashboardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.IslandDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.PlayerDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.PlanningPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Communication.PlayAssistantCardMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.Dashboard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PlanningPhaseCLI implements MessageCLI{
	ArrayList<IslandDTO> islandList;
	HashMap<String, String> professors;
	HashMap<String, PlayerDTO> players;
	ArrayList<AssistantCardDTO> playedCards;
	String currentPlayer;

	public PlanningPhaseCLI(PlanningPhaseMessage planningPhaseMessage){
		this.islandList = planningPhaseMessage.getIslandList();
		this.professors = planningPhaseMessage.getProfessors();
		this.players = planningPhaseMessage.getPlayers();
		this.playedCards = planningPhaseMessage.getPlayedCards();
		this.currentPlayer = planningPhaseMessage.getCurrentPlayer();
	}
	
	@Override
	public Message execute(){
		System.out.println("islands:");
		System.out.println("WIP");

		System.out.println("professors:");
		professors.forEach((k, v) -> System.out.println(k + ": " + v));

		System.out.println("dashboards");
		players.forEach((k, v) -> {
			System.out.println(k + "'s dashboard:");
			printDashboard(v.getDashboard());
		});

		System.out.println("already played cards");
		playedCards.forEach(this::printAssistantCard);

		System.out.println("your hand");
		ArrayList<AssistantCardDTO> hand = players.get(currentPlayer).getHand();
		for(int i = 0; i < hand.size(); i++){
			System.out.println("index: " + i);
			printAssistantCard(hand.get(i));
		}

		System.out.println("select the index of the assistant card you want to play");
		Scanner scanner = new Scanner(System.in);
		int cardChoice;
		try{
			cardChoice = Integer.parseInt(scanner.nextLine());
		}catch (Exception e){
			cardChoice = -1;
		}
		while(cardChoice < 0 || cardChoice > hand.size()){
			System.out.println("invalid choice, please select a valid index of the card");
			try{
				cardChoice = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				cardChoice = -1;
			}
		}

		PlayAssistantCardMessage cardChosen = new PlayAssistantCardMessage();
		cardChosen.setCardChosen(cardChoice);
		return cardChosen;
	}

	private void printIsland(IslandDTO island){
	}

	private void printDashboard(DashboardDTO dashboard){
		System.out.println("entrance");
		ArrayList<String> hall = dashboard.getHall();
		for(int i = 0; i < hall.size(); i++){
			System.out.println(i + ": " + hall.get(i));
		}

		System.out.println("hall");
		dashboard.getTables().forEach((k, v) -> System.out.println(k + ": " + v));

		System.out.println("you have " + dashboard.getNumberOfTowers() + " towers left");
	}

	private void printAssistantCard(AssistantCardDTO assistantCard){
		System.out.println("name: " + assistantCard.getType());
		System.out.println("value: " + assistantCard.getValue());
		System.out.println("movements: " + assistantCard.getMovements());
	}
}
