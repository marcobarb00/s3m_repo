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

		System.out.println("\nISLANDS:");
		printIslands();

		System.out.println("\nMother Nature position: " + (gameState.getMotherNaturePosition() + 1));

		System.out.println("\nprofessors:");
		gameState.getProfessors().forEach((color, nickname) -> System.out.println(color + ": " + nickname));

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
		System.out.println("ENTRANCE			HALL");
		for(String color : entrance.keySet()){
			System.out.println(color + ":	" + entrance.get(color) + "				" + color
								+ ":	" + hall.get(color));

		}

		System.out.println("\nyou have " + dashboard.getNumberOfTowers() + " towers left\n");
	}
}
