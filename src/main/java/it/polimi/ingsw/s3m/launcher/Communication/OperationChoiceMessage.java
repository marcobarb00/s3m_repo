package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class OperationChoiceMessage implements Message{
	private String phase;

	public void setPhase(String phase){
		this.phase = phase;
	}

	public String getPhase(){
		return phase;
	}

	@Override
	public void apply(View view){
		view.operationChoice(this);
	}
}
