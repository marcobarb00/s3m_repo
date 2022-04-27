package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class MotherNaturePhaseMessage implements Message{
	@Override
	public void apply(View view){
		view.motherNaturePhase(this);
	}
}
