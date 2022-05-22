package it.polimi.ingsw.s3m.launcher.Client.Response;

public class MotherNaturePhaseResponse implements Response{
	int operationChoice;

	public MotherNaturePhaseResponse(int operationChoice){
		this.operationChoice = operationChoice;
	}

	public int getOperationChoice(){
		return operationChoice;
	}
}
