package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class NotificationMessage implements Message{
	private String message;

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}

	@Override
	public void apply(View view){
		view.notification(this);
	}
}
