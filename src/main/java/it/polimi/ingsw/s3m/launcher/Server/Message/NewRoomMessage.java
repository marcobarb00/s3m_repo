package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class NewRoomMessage implements Message{
	@Override
	public void apply(View view){
		view.newRoom(this);
	}
}
