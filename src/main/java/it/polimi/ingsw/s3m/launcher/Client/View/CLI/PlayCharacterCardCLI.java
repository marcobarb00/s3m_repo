package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.PlayCharacterCardResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlayCharacterCardMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayCharacterCardCLI extends MessageCLI{
	private GameDTO gameState;
	private ArrayList<String> studentsToPutOnJester;
	private ArrayList<String> studentsToGetFromJester;

	private ArrayList<String> studentsToPutOnTables;
	private ArrayList<String> studentsToGetFromTables;

	private String notInfluencingColor;


	public PlayCharacterCardCLI(PlayCharacterCardMessage playCharacterCardMessage){
		this.gameState = playCharacterCardMessage.getGameState();
	}

	@Override
	public Response execute(){
		ArrayList<CharacterCardDTO> characterCardDTOList = gameState.getCharacterCards();

		System.out.println("choose a character card:");
		int cardsNumber = characterCardDTOList.size();
		for (int i = 0; i < cardsNumber; i++) {
			CharacterCardDTO card = characterCardDTOList.get(i);
			System.out.println((i+1) + ") " + card.getName() + " cost: " + card.getCost());
		}

		int characterCardPosition = getOperation(characterCardDTOList.size()) - 1;
		String characterType = characterCardDTOList.get(characterCardPosition).getName();
		if(characterType.equals("Jester")){
			getJesterInputs();
			return new PlayCharacterCardResponse(characterCardPosition,
					studentsToPutOnJester, studentsToGetFromJester);
		}
		if(characterType.equals("Mushroomer")){
			getMushroomerInputs();
			return new PlayCharacterCardResponse(characterCardPosition,
					studentsToPutOnTables, studentsToGetFromTables);
		}
		if(characterType.equals("Minstrel")){
			getMinstrelInputs();
			return new PlayCharacterCardResponse(characterCardPosition, notInfluencingColor);
		}

		return new PlayCharacterCardResponse(characterCardPosition);
	}

	private void getMinstrelInputs(){
		this.studentsToPutOnTables = new ArrayList<>();
		this.studentsToGetFromTables = new ArrayList<>();

		System.out.println("select how many students do you want to exchange from 1 to 2 " +
				"between your entrance and your hall:");
		int studentsNumber = getOperation(2);

		for (int i = 0; i < studentsNumber; i++) {
			System.out.println("select " +(i+1)+"° student in your entrance to put in your hall");
			chooseColor();
			String chosenColor = getCLIColor(getOperation(5));
			studentsToPutOnTables.add(chosenColor);
		}
		for (int i = 0; i < studentsNumber; i++) {
			System.out.println("select " +(i+1)+"° student in your hall to put in your entrance");
			chooseColor();
			String chosenColor = getCLIColor(getOperation(5));
			studentsToGetFromTables.add(chosenColor);
		}
	}

	private void getMushroomerInputs(){
		System.out.println("Select a color that won't influence dominance in your turn:");
		chooseColor();
		notInfluencingColor = getCLIColor(getOperation(5));
	}

	private void getJesterInputs(){
		this.studentsToPutOnJester = new ArrayList<>();
		this.studentsToGetFromJester = new ArrayList<>();

		System.out.println("select how many students do you want to exchange from 1 to 3:");
		int studentsNumber = getOperation(3);

		for (int i = 0; i < studentsNumber; i++) {
			System.out.println("select " +(i+1)+"° student in your entrance to put on jester:");
			chooseColor();
			String chosenColor = getCLIColor(getOperation(5));
			studentsToPutOnJester.add(chosenColor);
		}
		for (int i = 0; i < studentsNumber; i++) {
			System.out.println("select " +(i+1)+"° student on jester to put in your entrance:");
			chooseColor();
			String chosenColor = getCLIColor(getOperation(5));
			studentsToPutOnJester.add(chosenColor);
		}
	}

	private void chooseColor(){
		System.out.println("1) RED	2) GREEN");
		System.out.println("3) BLUE	4) PINK");
		System.out.println("5) YELLOW");
	}

	private String getCLIColor(int code){
		//Do not modify order
		ArrayList<String> colors = new ArrayList<>(
				Arrays.asList("RED", "GREEN", "BLUE",
						"PINK", "YELLOW"));
		return colors.get(code - 1);
	}
}
