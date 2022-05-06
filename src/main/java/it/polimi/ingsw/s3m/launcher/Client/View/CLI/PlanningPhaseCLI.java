package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;

import java.util.ArrayList;
import java.util.Scanner;

public class PlanningPhaseCLI implements MessageCLI{
	GameDTO gameState;

	public PlanningPhaseCLI(PlanningPhaseMessage planningPhaseMessage){
		this.gameState = planningPhaseMessage.getGameState();
	}

	@Override
	public Response execute(){
		GameStateCLI gameStateCLI = new GameStateCLI(gameState);
		gameStateCLI.printState();

		String currentPlayer = gameState.getCurrentPlayerTurn();
		ArrayList<AssistantCardDTO> playedAssistantCards = gameState.getTurn().getPlayedCards();
		ArrayList<AssistantCardDTO> hand = gameState.getPlayers().get(currentPlayer).getHand();

		if(playedAssistantCards.size() != 0){
			System.out.println("\ncards played by the other players:");
			for(AssistantCardDTO assistantCard : playedAssistantCards){
				printAssistantCard(assistantCard);
			}
		}

		System.out.println("\nyour hand:");
		for(int i = 0; i < hand.size(); i++){
			System.out.println("index: " + i);
			printAssistantCard(hand.get(i));
		}

		System.out.println("\nselect the index of the assistant card you want to play");
		Scanner scanner = new Scanner(System.in);
		int cardChoice;
		try{
			cardChoice = Integer.parseInt(scanner.nextLine());
		}catch (Exception e){
			cardChoice = -1;
		}
		while(cardChoice < 0 || cardChoice > hand.size()){
			System.out.println("\ninvalid choice, please select a valid index of the card");
			try{
				cardChoice = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				cardChoice = -1;
			}
		}

		return new PlayAssistantCardResponse(cardChoice);
	}

	private void printAssistantCard(AssistantCardDTO assistantCard){
		System.out.println("name: " + assistantCard.getType() + "\tvalue: " + assistantCard.getValue() + "\tmovements: " + assistantCard.getMovements());
	}
}
