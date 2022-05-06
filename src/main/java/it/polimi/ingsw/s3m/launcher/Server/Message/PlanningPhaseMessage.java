package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

import java.util.ArrayList;

public class PlanningPhaseMessage implements Message{
	GameDTO gameState;

	public PlanningPhaseMessage(GameDTO gameState){
		this.gameState = gameState;
	}

	public GameDTO getGameState(){
		return gameState;
	}

	@Override
	public void apply(View view){
		view.planningPhase(this);
	}
}
