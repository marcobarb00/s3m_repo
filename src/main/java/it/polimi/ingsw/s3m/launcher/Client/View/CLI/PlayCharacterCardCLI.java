package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlayCharacterCardMessage;

public class PlayCharacterCardCLI implements MessageCLI{
	GameDTO gameState;

	public PlayCharacterCardCLI(PlayCharacterCardMessage playCharacterCardMessage){
		this.gameState = playCharacterCardMessage.getGameState();
	}

	@Override
	public Response execute(){
		//TODO MAKE THE CLI
		return null;
	}
}