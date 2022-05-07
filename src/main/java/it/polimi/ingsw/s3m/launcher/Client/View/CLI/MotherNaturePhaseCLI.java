package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.MotherNaturePhaseMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.AssistantCard;

public class MotherNaturePhaseCLI implements MessageCLI {
	private GameDTO gameState;

	public MotherNaturePhaseCLI(MotherNaturePhaseMessage motherNaturePhaseMessage){

	}

	//TODO Find out if gameState.isCharacterCardActivated() gets updated
	@Override
	public Response execute(){
		System.out.println("move mother nature phase phase");
		int maxMoves = getMaxMoves();
		System.out.println("choose mother nature's moves number from 1 to " + maxMoves +  ":");

		return null;
	}

	private int getMaxMoves(){
		String currentPlayer = gameState.getCurrentPlayerTurn();
		AssistantCardDTO assistantCard = gameState.getPlayers().get(currentPlayer).getLastCardPlayed();
		return assistantCard.getMovements();
	}
}
