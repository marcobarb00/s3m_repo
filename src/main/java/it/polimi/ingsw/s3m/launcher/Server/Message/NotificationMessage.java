package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class NotificationMessage implements Notification{
	private final String message;

	public NotificationMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
	public void apply(View view){
		view.notification(this);
	}
}
