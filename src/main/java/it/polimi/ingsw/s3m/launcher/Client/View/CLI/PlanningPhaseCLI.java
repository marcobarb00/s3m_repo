package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class PlanningPhaseCLI extends MessageCLI{
	GameDTO gameState;

	public PlanningPhaseCLI(PlanningPhaseMessage planningPhaseMessage){
		this.gameState = planningPhaseMessage.getGameState();
	}

	@Override
	public Response execute(){
		GameStateCLI gameStateCLI = new GameStateCLI(gameState);
		gameStateCLI.printState();

		HashMap<String, AssistantCardDTO> playedAssistantCards = gameState.getTurn().getPlayedCards();
		ArrayList<AssistantCardDTO> hand = gameState.getCurrentPlayer().getHand();

		if(playedAssistantCards.isEmpty()){
			System.out.println("\ncards played by the other players:");
			playedAssistantCards.forEach((nickname, assistantCard) -> {
				System.out.println("name: " + assistantCard.getType() + "\tvalue: " + assistantCard.getValue() +
						"\tmovements: " + assistantCard.getMovements());
			});
		}

		System.out.println("\nyour hand:");
		for(int i = 0; i < hand.size(); i++){
			AssistantCardDTO assistantCard = hand.get(i);
			System.out.println("index: " + (i + 1) + "\tname:	" + String.format("%-12s", assistantCard.getType()) +
					"value: " + assistantCard.getValue() + "	moves: " + assistantCard.getMovements());
		}

		System.out.println("\nselect the index of the assistant card you want to play");
		int cardChoice = getOperation(hand.size()) - 1;

		return new PlayAssistantCardResponse(cardChoice);
	}
}
