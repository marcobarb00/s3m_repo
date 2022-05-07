package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

import java.util.ArrayList;

public class MoveStudentsPhaseResponse implements Response{
	int operationChoice;

	public MoveStudentsPhaseResponse(int operationChoice){
		this.operationChoice = operationChoice;
	}

	public int getOperationChoice(){
		return operationChoice;
	}
}
