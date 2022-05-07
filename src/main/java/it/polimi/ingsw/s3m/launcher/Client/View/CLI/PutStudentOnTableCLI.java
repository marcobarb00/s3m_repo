package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.PutStudentOnTableMessage;

public class PutStudentOnTableCLI implements MessageCLI{
	GameDTO gameState;

	public PutStudentOnTableCLI(PutStudentOnTableMessage putStudentOnTableMessage){
		this.gameState = putStudentOnTableMessage.getGameState();
	}

	@Override
	public Response execute(){
		//TODO MAKE THE CLI
		return null;
	}
}
