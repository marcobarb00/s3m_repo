package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;

public class GUIView extends View{

	@Override
	public Message login(LoginMessage loginMessage){
		return null;
	}

	@Override
	public LoginMessage enterRoom(){
		return null;
	}

	@Override
	public LoginMessage newRoom(){
		return null;
	}

	@Override
	public void showLoginResult(LoginMessage loginResult){}

	@Override
	public void waitingForPlayers(){

	}

	@Override
	public void showNotification(NotificationMessage notification){

	}
}
