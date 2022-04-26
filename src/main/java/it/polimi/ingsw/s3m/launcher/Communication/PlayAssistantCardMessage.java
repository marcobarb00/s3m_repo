package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

import java.util.ArrayList;

public class PlayAssistantCardMessage implements Message{
	private ArrayList<AssistantCardMessage> assistantCardMessageList;
	private int cardChosen;

	public void setAssistantCardMessageList(ArrayList<AssistantCardMessage> assistantCardMessageList){
		this.assistantCardMessageList = assistantCardMessageList;
	}

	public ArrayList<AssistantCardMessage> getAssistantCardMessageList(){
		return assistantCardMessageList;
	}

	public void setCardChosen(int cardChosen){
		this.cardChosen = cardChosen;
	}

	public int getCardChosen(){
		return cardChosen;
	}

	@Override
	public void apply(View view){

	}
}
