package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.io.Serializable;

public class AssistantCardDTO implements Serializable{
	private final String type;
	private final int value;
	private final int movements;

	public AssistantCardDTO(String type, int value, int movements){
		this.type = type;
		this.value = value;
		this.movements = movements;
	}

	public String getType(){
		return type;
	}

	public int getMovements(){
		return movements;
	}

	public int getValue(){
		return value;
	}
}
