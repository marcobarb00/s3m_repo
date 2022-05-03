package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.MotherNaturePhaseMessage;

public class MotherNaturePhaseCLI implements MessageCLI{
	public MotherNaturePhaseCLI(MotherNaturePhaseMessage motherNaturePhaseMessage){

	}

	@Override
	public Message execute(){
		System.out.println("movement phase" +
				"\nchoose your operation:" +
				"\n1) activate a character card" +
				"\n2) move mother nature");
		return null;
	}
}