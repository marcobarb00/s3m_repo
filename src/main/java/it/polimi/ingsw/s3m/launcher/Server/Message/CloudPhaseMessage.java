package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

public class CloudPhaseMessage implements Message{
	@Override
	public void apply(View view){
		view.chooseCloudPhase(this);
	}
}
