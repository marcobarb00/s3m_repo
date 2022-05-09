package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class MotherNaturePhaseResponse implements Response{
	int operationChoice;

	public MotherNaturePhaseResponse(int operationChoice){
		this.operationChoice = operationChoice;
	}

	public int getOperationChoice(){
		return operationChoice;
	}
}
