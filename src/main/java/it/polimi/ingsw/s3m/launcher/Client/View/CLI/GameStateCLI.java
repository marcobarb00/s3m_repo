package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.*;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.GameStateMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

import java.util.HashMap;

public class GameStateCLI implements MessageCLI{
	GameDTO gameState;

	public GameStateCLI(GameStateMessage gameStateMessage){
		this.gameState = gameStateMessage.getGameState();
	}

	@Override
	public Response execute(){
		System.out.println("\nislands:");
		System.out.println("WIP");
		//TODO print islands

		System.out.println("\nprofessors:");
		gameState.getProfessors().forEach((color, player) -> System.out.println(color + ": " + player.getNickname()));

		System.out.println("\ndashboards:");
		gameState.getPlayers().forEach((nickname, player) -> {
			System.out.println("\n" + nickname + "'s dashboard:");
			printDashboard(player.getDashboard());
		});

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
}
