package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.Login;

public abstract class View{
	String nickname;
	int playerId;

	/**
	 * show login screen, read login information from user
	 * @return login information
	 */
	public abstract Login login();

	/**
	 * show the response of the server to the login request, set nickname and playerId of the view
	 * @param loginInfo
	 */
	public abstract void showLoginInfo(Login loginInfo);
}
