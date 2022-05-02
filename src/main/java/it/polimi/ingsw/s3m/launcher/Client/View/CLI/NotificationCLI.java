package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;

public class NotificationCLI implements MessageCLI{
	String message;

	public NotificationCLI(NotificationMessage notification){
		this.message = notification.getMessage();
	}

	@Override
	public Message execute(){
		System.out.println("\n" + message);
		return null;
	}
}
