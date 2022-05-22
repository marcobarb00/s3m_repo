package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.CloudResponse;
import it.polimi.ingsw.s3m.launcher.DTOs.GameDTO;
import it.polimi.ingsw.s3m.launcher.Client.Response.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.CloudPhaseMessage;

public class CloudPhaseCLI extends MessageCLI{
	private final GameDTO gameState;

	public CloudPhaseCLI(CloudPhaseMessage cloudPhaseMessage){
		this.gameState = cloudPhaseMessage.getGameState();
	}

	@Override
	public Response execute(){
		int maxOperationNumber = gameState.getClouds().size();
		System.out.println("choose a cloud from 1 to " +
				maxOperationNumber + " to get the students from: ");
		int chosenCloudPosition = getOperation(maxOperationNumber) - 1;

		return new CloudResponse(chosenCloudPosition);
	}
}
