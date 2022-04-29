package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;

import java.util.ArrayList;

public class PlayAssistantCardMessage implements Message{
	private ArrayList<AssistantCardDTO> assistantCardDTOList;
	private int cardChosen;

	public void setAssistantCardMessageList(ArrayList<AssistantCardDTO> assistantCardDTOList){
		this.assistantCardDTOList = assistantCardDTOList;
	}

	public ArrayList<AssistantCardDTO> getAssistantCardMessageList(){
		return assistantCardDTOList;
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
