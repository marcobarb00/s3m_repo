package it.polimi.ingsw.s3m.launcher.Client.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Network.Client;
import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.AskPlayersNumber;
import it.polimi.ingsw.s3m.launcher.Communication.Login;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

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
		Login loginResult = new Login("");
		do{
			Login loginInfo = view.login();
			client.sendMessage(loginInfo);

			Message recievedMessage = (Message) client.recieveMessage();
			if(recievedMessage instanceof AskPlayersNumber){
				loginResult.setSuccessful(false);
				AskPlayersNumber playersNumber = view.askPlayersNumber();
				client.sendMessage(playersNumber);
				recievedMessage = (Message) client.recieveMessage();
			}
			loginResult = (Login) recievedMessage;
			view.showLoginResult(loginResult);
		}while(!loginResult.isSuccessful());
	}
}
