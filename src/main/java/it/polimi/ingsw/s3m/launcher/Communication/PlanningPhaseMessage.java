package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;

public class PlanningPhaseMessage implements Message{
	private GameDTO game;

	public void setGame(GameDTO game){
		this.game = game;
	}

	@Override
	public void apply(View view){
		view.planningPhase(this);
	}
}
