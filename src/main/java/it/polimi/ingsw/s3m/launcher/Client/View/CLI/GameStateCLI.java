package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.DashboardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.IslandDTO;
import it.polimi.ingsw.s3m.launcher.Communication.GameStateMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

import java.util.ArrayList;

public class GameStateCLI implements MessageCLI{
	GameDTO gameState;

	public GameStateCLI(GameStateMessage gameStateMessage){
		this.gameState = gameStateMessage.getGameState();
	}

	@Override
	public Message execute(){
		System.out.println("islands:");
		System.out.println("WIP");

		System.out.println("professors:");
		gameState.getProfessors().forEach((k, v) -> System.out.println(k + ": " + v));

		System.out.println("dashboards");
		gameState.getPlayers().forEach((k, v) -> {
			System.out.println(k + "'s dashboard:");
			printDashboard(v.getDashboard());
		});

		System.out.println("your hand");
		//TODO get current player hand
		ArrayList<AssistantCardDTO> hand = new ArrayList<>();
		for(int i = 0; i < hand.size(); i++){
			System.out.println("index: " + i);
			printAssistantCard(hand.get(i));
		}

		return null;
	}

	private void printIsland(IslandDTO island){
	}

	private void printDashboard(DashboardDTO dashboard){
		System.out.println("entrance");
		dashboard.getEntrance().forEach((k, v) -> System.out.println(k + ": " + v));

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
