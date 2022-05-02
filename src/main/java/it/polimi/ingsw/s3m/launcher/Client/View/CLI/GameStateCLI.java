package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.*;
import it.polimi.ingsw.s3m.launcher.Communication.GameStateMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

import java.util.ArrayList;
import java.util.HashMap;

public class GameStateCLI implements MessageCLI{
	GameDTO gameState;

	public GameStateCLI(GameStateMessage gameStateMessage){
		this.gameState = gameStateMessage.getGameState();
	}

	@Override
	public Message execute(){
		System.out.println("\nislands:");
		System.out.println("WIP");

		System.out.println("\nprofessors:");
		gameState.getProfessors().forEach((color, player) -> System.out.println(color + ": " + player.getNickname()));

		System.out.println("\ndashboards:");
		gameState.getPlayers().forEach((k, v) -> {
			System.out.println(k + "'s dashboard:");
			printDashboard(v.getDashboard());
		});

		System.out.println("\nyour hand:");
		ArrayList<AssistantCardDTO> hand = gameState.getPlayers().get(gameState.getCurrentPlayerTurn()).getHand();
		for(int i = 0; i < hand.size(); i++){
			System.out.println("index: " + i);
			printAssistantCard(hand.get(i));
		}

		//TODO print last played assistant card

		return null;
	}

	private void printIsland(IslandDTO island){
	}

	private void printDashboard(DashboardDTO dashboard){
		StringBuilder students;

		System.out.println("\nentrance:");
		HashMap<String, Integer> entrance = dashboard.getEntrance();
		students = new StringBuilder();
		for(String color : entrance.keySet()){
			students.append(color).append(": ").append(entrance.get(color)).append(" ");
		}
		System.out.println(students);

		System.out.println("\nhall:");
		HashMap<String, Integer> hall = dashboard.getTables();
		students = new StringBuilder();
		for(String color : hall.keySet()){
			students.append(color).append(": ").append(hall.get(color)).append(" ");
		}
		System.out.println(students);

		System.out.println("\nyou have " + dashboard.getNumberOfTowers() + " towers left");
	}

	private void printAssistantCard(AssistantCardDTO assistantCard){
		System.out.println("name: " + assistantCard.getType() + "\tvalue: " + assistantCard.getValue() + "\tmovements: " + assistantCard.getMovements());
	}
}
