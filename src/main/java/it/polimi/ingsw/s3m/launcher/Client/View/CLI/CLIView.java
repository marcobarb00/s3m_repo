package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;

import java.util.Scanner;

public class CLIView extends View{
	public CLIView(){}

	@Override
	public Message login(LoginMessage loginMessage){
		LoginCLI login = new LoginCLI(loginMessage);
		return login.execute();
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
	public void showLoginResult(LoginMessage loginResult){
		System.out.println(loginResult.getMessage());
	}

	@Override
	public void waitingForPlayers(){
		System.out.println("waiting for other players to join");
	}

	@Override
	public void showNotification(NotificationMessage notification){
		System.out.println(notification.getMessage());
	}
}
