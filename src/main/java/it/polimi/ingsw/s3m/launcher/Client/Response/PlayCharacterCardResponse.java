package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class PlayCharacterCardResponse implements Response{
	private int characterCardPosition;

	public PlayCharacterCardResponse(int characterCardPosition){
		this.characterCardPosition = characterCardPosition;
	}

	public int getCharacterCardPosition(){
		return characterCardPosition;
	}
}
