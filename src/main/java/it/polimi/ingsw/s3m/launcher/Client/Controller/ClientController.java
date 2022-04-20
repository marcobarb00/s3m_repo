package it.polimi.ingsw.s3m.launcher.Client.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Network.Client;
import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;

public class ClientController{
	Client client;
	View view;

	public ClientController(View view){
		this.view = view;
		this.client = new Client();
		client.start();
		start();
	}

	public void start(){
		while (true) {
			try {
				Message receivedMessage = client.recieveMessage();
				if(receivedMessage instanceof NotificationMessage){
					receivedMessage.execute(view);
				}else{
					Message toSendMessage = receivedMessage.execute(view);
					if(toSendMessage != null)
						client.sendMessage(toSendMessage);
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void startGame(){
		view.waitingForPlayers();
	}
}
