package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class ActivateCharacterCardResponse implements Response{
	private int characterCardPosition;

	public ActivateCharacterCardResponse(int characterCardPosition){
		this.characterCardPosition = characterCardPosition;
	}

	public int getCharacterCardPosition(){
		return characterCardPosition;
	}
}
