package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

import java.util.ArrayList;

public class PlanningPhaseMessage implements Message{
	ArrayList<AssistantCardDTO> playedAssistantCards;
	ArrayList<AssistantCardDTO> hand;

	public void setPlayedAssistantCards(ArrayList<AssistantCardDTO> playedAssistantCards){
		this.playedAssistantCards = playedAssistantCards;
	}

	public void setHand(ArrayList<AssistantCardDTO> hand){
		this.hand = hand;
	}

	public ArrayList<AssistantCardDTO> getPlayedAssistantCards(){
		return playedAssistantCards;
	}

	public ArrayList<AssistantCardDTO> getHand(){
		return hand;
	}

	@Override
	public void apply(View view){
		view.planningPhase(this);
	}
}
