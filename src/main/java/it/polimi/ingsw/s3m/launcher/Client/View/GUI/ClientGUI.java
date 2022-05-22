package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Network.Client;
import it.polimi.ingsw.s3m.launcher.Server.Message.Message;
import it.polimi.ingsw.s3m.launcher.Client.Response.Response;
import javafx.application.Platform;

public class ClientGUI extends Thread{
	private final Client client;
	private final GUIView view;

	public ClientGUI(){
		this.view = new GUIView(this);
		this.client = new Client();
		this.client.start();
	}

	@Override
	public void run(){
		while(true){
			try{
				Message receivedMessage = client.receiveMessage();
				receivedMessage.apply(view);
			}catch(Exception e){
				try{
					Thread.sleep(3000);
					close();
					Platform.exit();
					System.exit(1);
				}catch(InterruptedException e1){
					//e1.printStackTrace();
				}
			}
		}
	}

	public void communicate(Response response){
		client.sendResponse(response);
	}

	public void close(){
		client.close();
	}
}
