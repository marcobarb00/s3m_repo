package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.PlanningPhaseMessage;

public class PlanningPhaseCLI implements MessageCLI{
	public PlanningPhaseCLI(PlanningPhaseMessage planningPhaseMessage){
	}
	
	@Override
	public Message execute(){
		System.out.println("choose the assistant card you want to play");
		return null;
	}
}
