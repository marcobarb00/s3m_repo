package it.polimi.ingsw.s3m.launcher.Client.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Network.Client;
import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Server.Communication.*;

public class ClientController{
	Client client;
	View view;

	public ClientController(View view){
		this.view = view;
		this.client = new Client();
		client.start();
		login();
		startGame();
	}

	/**
	 * creates a login request to the server until a successful login
	 */
	public void login(){
		LoginMessage loginResult;
		do{
			LoginMessage loginInfo = view.login();
			client.sendMessage(loginInfo);
			loginResult = (LoginMessage) client.recieveMessage();
			view.showLoginResult(loginResult);
		}while(!loginResult.isSuccessful());
	}

	public void startGame(){
		view.waitingForPlayers();
	}
}
