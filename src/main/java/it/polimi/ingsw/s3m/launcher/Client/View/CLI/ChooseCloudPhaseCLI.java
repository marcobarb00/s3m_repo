package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.CloudPhaseMessage;

public class ChooseCloudPhaseCLI extends MessageCLI{
	public ChooseCloudPhaseCLI(CloudPhaseMessage cloudPhaseMessage){

	}

	@Override
	public Response execute(){
		System.out.println("choose the cloud to get the students from\n");
		return null;
	}
}
