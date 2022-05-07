package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.PutStudentOnIslandMessage;

public class PutStudentOnIslandCLI implements MessageCLI{
	GameDTO gameState;

	public PutStudentOnIslandCLI(PutStudentOnIslandMessage putStudentOnIslandMessage){
		this.gameState = putStudentOnIslandMessage.getGameState();
	}

	@Override
	public Response execute(){
		//TODO MAKE THE CLI
		return null;
	}
}
