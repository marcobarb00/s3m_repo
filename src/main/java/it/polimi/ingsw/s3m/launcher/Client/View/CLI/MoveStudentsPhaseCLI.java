package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.MoveStudentsPhaseMessage;

public class MoveStudentsPhaseCLI implements MessageCLI{
	public MoveStudentsPhaseCLI(MoveStudentsPhaseMessage moveStudentsPhaseMessage){

	}

	@Override
	public Message execute(){
		System.out.println("student allocation phase" +
				"\nchoose your operation:" +
				"\n1) activate a character card" +
				"\n2) move a student from the hall to the tables" +
				"\n3) move a student from the hall to an island");
		return null;
	}
}
