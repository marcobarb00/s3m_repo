package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;

public abstract class View{
	String nickname;

	public abstract LoginMessage login();

	public abstract LoginMessage enterRoom();

	public abstract LoginMessage newRoom();

	public abstract void showLoginResult(LoginMessage loginResult);

	public abstract void waitingForPlayers();

	public abstract void showNotification(NotificationMessage notification);
}
