package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

public class ActivateCharacterCardMessage implements Message{
	private GameDTO gameState;

	public ActivateCharacterCardMessage(GameDTO gameState){
		this.gameState = gameState;
	}

	public GameDTO getGameState(){
		return gameState;
	}

	@Override
	public void apply(View view){
		//TODO view.activateCharacterCardMessage(this)
	}
}
