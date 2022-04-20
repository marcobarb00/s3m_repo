package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Server.Communication.*;

public class GUIView extends View{

	@Override
	public LoginMessage login(){
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
