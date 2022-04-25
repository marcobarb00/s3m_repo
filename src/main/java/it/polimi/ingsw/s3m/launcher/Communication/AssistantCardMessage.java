package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Server.Model.AssistantCard;

import java.io.Serializable;
import java.util.ArrayList;

public class AssistantCardMessage implements Serializable{
	private String type;
	private int value;
	private int movements;

	public AssistantCardMessage(AssistantCard assistantCard){
		this.type = assistantCard.getType();
		this.value = assistantCard.getValue();
		this.movements = assistantCard.getMovements();
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

	public static ArrayList<AssistantCardMessage> toMessage(ArrayList<AssistantCard> assistantCardsardList){
		ArrayList<AssistantCardMessage> assistantCardMessageList = new ArrayList<>();
		for(AssistantCard assistantCard : assistantCardsardList){
			assistantCardMessageList.add(new AssistantCardMessage(assistantCard));
		}

		return assistantCardMessageList;
	}
}
