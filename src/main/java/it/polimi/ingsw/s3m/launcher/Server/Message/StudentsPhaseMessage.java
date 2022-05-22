package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.DTOs.GameDTO;

public class StudentsPhaseMessage implements Message{
	private final GameDTO gameState;

	public StudentsPhaseMessage(GameDTO gameState){
		this.gameState = gameState;
	}

	public GameDTO getGameState(){
		return gameState;
	}

	@Override
	public void apply(View view){
		view.moveStudentsPhase(this);
	}
}
