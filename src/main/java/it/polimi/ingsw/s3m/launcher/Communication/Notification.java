package it.polimi.ingsw.s3m.launcher.Communication;

public class Notification implements Message{
	private String message;

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public void read(ControllerInterface controller){
		controller.readNotification(this);
	}
}
