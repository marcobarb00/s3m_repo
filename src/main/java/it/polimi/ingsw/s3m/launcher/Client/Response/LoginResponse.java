package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class LoginResponse implements Response{
	private final boolean isNewRoom;

	public LoginResponse(boolean isNewRoom){
		this.isNewRoom = isNewRoom;
	}

	public boolean isNewRoom(){
		return isNewRoom;
	}
}
