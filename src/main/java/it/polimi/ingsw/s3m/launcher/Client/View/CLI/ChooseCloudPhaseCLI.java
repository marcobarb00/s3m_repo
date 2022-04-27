package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.ChooseCloudPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

public class ChooseCloudPhaseCLI implements MessageCLI{
	public ChooseCloudPhaseCLI(ChooseCloudPhaseMessage chooseCloudPhaseMessage){

	}

	@Override
	public Message execute(){
		System.out.println("choose the cloud to get the students from\n");
		return null;
	}
}
