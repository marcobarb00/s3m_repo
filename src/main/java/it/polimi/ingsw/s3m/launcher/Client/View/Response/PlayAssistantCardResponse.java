package it.polimi.ingsw.s3m.launcher.Client.View.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class PlayAssistantCardResponse implements Response{
	private int cardChosen;

	public PlayAssistantCardResponse(int cardChosen){
		this.cardChosen = cardChosen;
	}

	public int getCardChosen(){
		return cardChosen;
	}
}
