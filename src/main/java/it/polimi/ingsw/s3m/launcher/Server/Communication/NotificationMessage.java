package it.polimi.ingsw.s3m.launcher.Server.Communication;

public class NotificationMessage implements Message{
	private String message;

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}
}
