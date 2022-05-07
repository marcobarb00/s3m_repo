package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.MotherNatureResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.MotherNaturePhaseMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class MotherNaturePhaseCLI extends MessageCLI {
	private GameDTO gameState;
	private int selectedCharacterCard;
	private boolean characterCardActivated;

	public MotherNaturePhaseCLI(MotherNaturePhaseMessage motherNaturePhaseMessage){
		this.gameState = motherNaturePhaseMessage.getGameState();
		this.characterCardActivated = gameState.getTurn().isCharacterCardActivated();
	}

	@Override
	public Response execute(){
		System.out.println("move mother nature phase");
		int maxMoves = getMaxMoves();
		System.out.println("choose mother nature's moves number from 1 to " + maxMoves +  ":");
		int moves = getOperation(maxMoves);

		System.out.println("do you want to play a character card? y: yes n: no");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();
		while(!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N")){
			System.out.println("\nyou inserted an invalid input");
			choice = scanner.nextLine();
		}
		if(choice.equalsIgnoreCase("y")){
			chooseCharacterCard();
		}

		return new MotherNatureResponse(characterCardActivated, selectedCharacterCard, moves);
	}

	private int getMaxMoves(){
		AssistantCardDTO assistantCard = gameState.getCurrentPlayer().getLastCardPlayed();
		return assistantCard.getMovements();
	}

	private void chooseCharacterCard() {

		ArrayList<CharacterCardDTO> characterCardDTOList = gameState.getCharacterCards();
		System.out.println("choose character card:");
		int cardsNumber = characterCardDTOList.size();
		for (int i = 0; i < cardsNumber; i++) {
			CharacterCardDTO card = characterCardDTOList.get(i);
			System.out.println((i + 1) + ") " + card.getName() + " cost: " + card.getCost());
		}
		int operation = getOperation(3);
		this.selectedCharacterCard = operation - 1;
		this.characterCardActivated = true;
	}
}
