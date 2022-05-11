package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GameStateCLI{
	GameDTO gameState;

	public GameStateCLI(GameDTO gameState){
		this.gameState = gameState;
	}

	public void printState(){
		System.out.println("CHARACTER CARDS");
		printCharacterCards();

		System.out.println("\nISLANDS:");
		printIslands();

		System.out.print("\n");
		printClouds();

		System.out.println("\nMother Nature position: " + (gameState.getMotherNaturePosition() + 1));

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
			System.out.print("island " + (i+1) + "	");
			HashMap<String, Integer> studentsOnIsland = islands.get(i).getStudents();
			studentsOnIsland.forEach((color, number) -> System.out.print(color + ":	" + number + "	"));
			System.out.print("\n");
		}
	}

	private void printCharacterCards(){
		ArrayList<CharacterCardDTO> characterCardsDTO = gameState.getCharacterCards();
		for(CharacterCardDTO cardDTO : characterCardsDTO){
			System.out.println(cardDTO.getName() + " cost:	" + cardDTO.getCost());
			if(cardDTO.getName().equals("Jester")){
				//printing the hashmap of Jester
				HashMap<String, Integer> studentsOnJester = cardDTO.getStudentsOnCard();
				studentsOnJester.forEach((color, number) -> System.out.print(color + ":	" + number + "	"));
				System.out.print("\n");
			}
		}

	}

	private void printDashboard(DashboardDTO dashboard){
		StringBuilder students;

		//System.out.println("\nentrance:");
		HashMap<String, Integer> entrance = dashboard.getEntrance();
		HashMap<String, Integer> hall = dashboard.getTables();
		System.out.println("ENTRANCE				HALL");
		for(String color : entrance.keySet()){
			System.out.println(color + ":	" + entrance.get(color) + "				" + color
								+ ":	" + hall.get(color));

		}

		System.out.println("\nyou have " + dashboard.getNumberOfTowers() + " towers left\n");
	}

	private void printClouds(){
		ArrayList<CloudDTO> cloudsDTO = gameState.getClouds();
		int cloudsNumber = cloudsDTO.size();
		StringBuilder stringToPrint = new StringBuilder();
		for (int i = 0; i < cloudsNumber; i++) {
			stringToPrint.append("CLOUD " + (i+1) + "				");
		}
		System.out.println(stringToPrint);
		stringToPrint.setLength(0);

		ArrayList<String> colors = new ArrayList<>(
				Arrays.asList("RED", "GREEN", "BLUE",
						"PINK", "YELLOW"));
		for(String color : colors){
			for(CloudDTO cloud : cloudsDTO){
				int studentsOfColor = (int) cloud.getStudents().stream().
						filter(studentColor -> studentColor.equals(color)).count();
				stringToPrint.append(color + ":		" + studentsOfColor + "		");
			}
			System.out.println(stringToPrint);
			stringToPrint.setLength(0);
		}
	}
}
