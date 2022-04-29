package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import it.polimi.ingsw.s3m.launcher.Server.Model.AssistantCard;

import java.io.Serializable;
import java.util.ArrayList;

public class AssistantCardDTO implements Serializable{
	private String type;
	private int value;
	private int movements;

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
