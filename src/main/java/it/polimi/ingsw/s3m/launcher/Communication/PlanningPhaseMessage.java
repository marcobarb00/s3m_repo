package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class PlanningPhaseMessage implements Message{
	@Override
	public void apply(View view){
		view.planningPhase(this);
	}
}
