package it.polimi.ingsw.s3m.launcher.Client.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Network.Client;
import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.Login;

public class ClientController{
	Client client;
	View view;

	public ClientController(View view){
		this.view = view;
		this.client = new Client();
		client.start();
		login();
	}

	/**
	 * creates a login request to the server until a successful login
	 */
	public void login(){
		Login loginInfo;
		do{
			loginInfo = view.login();
			client.sendMessage(loginInfo);
			loginInfo = (Login) client.recieveMessage();
			view.showLoginResult(loginInfo);
		}while(!loginInfo.isSuccessful());
	}
}
