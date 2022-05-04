package it.polimi.ingsw.s3m.launcher.Client.View.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class LoginResponse implements Response{
	private boolean isNewRoom;

	public void setNewRoom(boolean newRoom) {
		isNewRoom = newRoom;
	}

	public boolean isNewRoom() {
		return isNewRoom;
	}
}
