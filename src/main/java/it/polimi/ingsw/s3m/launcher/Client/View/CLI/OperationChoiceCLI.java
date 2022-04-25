package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.OperationChoiceMessage;

public class OperationChoiceCLI implements MessageCLI{
	private String phase;

	public OperationChoiceCLI(OperationChoiceMessage operationChoice){
		this.phase = operationChoice.getPhase();
	}

	@Override
	public Message execute(){
		//TODO the messages based on every choice
		switch(phase){
			case "PlanningPhase":
				System.out.println("choose the assistant card you want to play");
				break;
			case "MoveStudentsPhase":
				System.out.println("student allocation phase\n" +
						"choose tour operation:\n" +
						"1) activate a character card\n" +
						"2) move a student from the hall to the tables\n" +
						"3) move a student from the hall to an island\n");
				break;
			case "MotherNaturePhase":
				System.out.println("movement phase\n" +
						"choose tour operation:\n" +
						"1) activate a character card\n" +
						"2) move mother nature\n");
				break;
			case "ChooseCloudPhase":
				System.out.println("choose the cloud to get the students from\n");
				break;
			default:
				System.out.println("something went wrong during communication");
		}
		//TODO remove return null
		return null;
	}
}
