package it.polimi.ingsw.s3m.launcher.Client.Response;

public class PlayAssistantCardResponse implements Response{
	private final int cardChosen;

	public PlayAssistantCardResponse(int cardChosen){
		this.cardChosen = cardChosen;
	}

	public int getCardChosen(){
		return cardChosen;
	}
}
