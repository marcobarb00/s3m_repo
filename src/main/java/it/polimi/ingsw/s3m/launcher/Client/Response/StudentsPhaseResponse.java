package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class StudentsPhaseResponse implements Response{
	int operationChoice;

	public StudentsPhaseResponse(int operationChoice){
		this.operationChoice = operationChoice;
	}

	public int getOperationChoice(){
		return operationChoice;
	}
}
