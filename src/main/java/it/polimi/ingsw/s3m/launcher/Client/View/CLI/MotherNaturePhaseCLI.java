package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.MotherNaturePhaseResponse;
import it.polimi.ingsw.s3m.launcher.DTOs.GameDTO;
import it.polimi.ingsw.s3m.launcher.Client.Response.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.MotherNaturePhaseMessage;

public class MotherNaturePhaseCLI extends MessageCLI{
	private final GameDTO gameState;
	private final boolean characterCardActivated;

	public MotherNaturePhaseCLI(MotherNaturePhaseMessage motherNaturePhaseMessage){
		this.gameState = motherNaturePhaseMessage.getGameState();
		this.characterCardActivated = gameState.getTurn().isCharacterCardActivated();
	}

	@Override
	public Response execute(){
		int operation;
		if(!characterCardActivated){
			System.out.println("choose an operation:");
			System.out.println("1) move mother nature");
			System.out.println("2) play a character card");
			operation = getOperation(2);
		}else{
			operation = 1;
		}

		return new MotherNaturePhaseResponse(operation);
	}
}
