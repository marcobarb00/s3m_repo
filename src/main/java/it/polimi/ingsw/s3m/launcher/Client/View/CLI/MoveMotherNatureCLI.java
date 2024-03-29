package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.MoveMotherNatureResponse;
import it.polimi.ingsw.s3m.launcher.DTOs.GameDTO;
import it.polimi.ingsw.s3m.launcher.Client.Response.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.MoveMotherNatureMessage;

public class MoveMotherNatureCLI extends MessageCLI{
	private final GameDTO gameState;

	public MoveMotherNatureCLI(MoveMotherNatureMessage moveMotherNatureMessage){
		this.gameState = moveMotherNatureMessage.getGameState();
	}

	@Override
	public Response execute(){
		int maxMoves = gameState.getTurn().getMotherNatureMaxAllowedMovements();
		System.out.println("select how many moves to make from 1 to " + maxMoves);

		int moves = getOperation(maxMoves);
		return new MoveMotherNatureResponse(moves);
	}
}
