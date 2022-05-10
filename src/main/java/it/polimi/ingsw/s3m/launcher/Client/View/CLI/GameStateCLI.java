package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.DashboardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.IslandDTO;

import java.util.ArrayList;
import java.util.HashMap;

public class GameStateCLI{
	GameDTO gameState;

	public GameStateCLI(GameDTO gameState){
		this.gameState = gameState;
	}

	public void printState(){
		System.out.println("CHARACTER CARDS");
		printCharacterCards();

		//TODO print islands
		System.out.println("\nISLANDS:");
		printIslands();

		System.out.println("\nMother Nature position: " + gameState.getMotherNaturePosition());

		System.out.println("\nprofessors:");
		gameState.getProfessors().forEach((color, player) -> System.out.println(color + ": " + player.getNickname()));

		System.out.println("\ndashboards:");
		gameState.getDashboards().forEach((nickname, dashboard) -> {
			System.out.println("\n" + nickname + "'s dashboard:");
			printDashboard(dashboard);
		});
	}

	private void printIslands(){
		ArrayList<IslandDTO> islands = gameState.getIslands();
		int islandsNumber = islands.size();
		for (int i = 0; i < islandsNumber; i++) {
			System.out.println("island " + (i+1));
			HashMap<String, Integer> studentsOnIsland = islands.get(i).getStudents();
			studentsOnIsland.forEach((color, number) -> System.out.print(color + "	:" + number + "	"));
		}
	}

	private void printCharacterCards(){
		ArrayList<CharacterCardDTO> characterCardsDTO = gameState.getCharacterCards();
		for(CharacterCardDTO cardDTO : characterCardsDTO){
			System.out.println(cardDTO.getName() + " cost:	" + cardDTO.getCost());
			if(cardDTO.getName().equals("Jester")){
				//printing the hashmap of Jester
				HashMap<String, Integer> studentsOnJester = cardDTO.getStudentsOnCard();
				studentsOnJester.forEach((color, number) -> System.out.print(color + "	:" + number + "	"));
			}
		}

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
