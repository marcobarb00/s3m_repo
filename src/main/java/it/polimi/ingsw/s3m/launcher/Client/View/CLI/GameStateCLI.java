package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.*;

import java.util.HashMap;

public class GameStateCLI{
	GameDTO gameState;

	public GameStateCLI(GameDTO gameState){
		this.gameState = gameState;
	}

	public void printState(){
		//TODO print characterCard

		System.out.println("\nislands:");
		System.out.println("WIP");
		//TODO print islands

		System.out.println("\nmother nature position: " + gameState.getMotherNaturePosition());

		System.out.println("\nprofessors:");
		gameState.getProfessors().forEach((color, player) -> System.out.println(color + ": " + player.getNickname()));

		System.out.println("\ndashboards:");
		gameState.getDashboards().forEach((nickname, dashboard) -> {
			System.out.println("\n" + nickname + "'s dashboard:");
			printDashboard(dashboard);
		});
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
