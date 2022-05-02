package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;

public class GameStateMessage implements Notification{
	GameDTO gameState;

	public GameStateMessage(GameDTO gameState){
		this.gameState = gameState;
	}

	public GameDTO getGameState(){
		return gameState;
	}

	@Override
	public void apply(View view){
		view.updateGameState(this);
	}
}
