package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Network.Client;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import javafx.application.Platform;

public class ClientGUI extends Thread{
	private Client client;
	private ControllerGUI controllerGUI;
	private GUIView view;
	private MessageGUI message;

	public ClientGUI(ControllerGUI controllerGUI){
		this.view = new GUIView(this, controllerGUI);
		this.controllerGUI = controllerGUI;
		this.client = new Client();
		this.client.start();
	}

	@Override
	public void run(){
		while(true){
			try{
				Message msg;
				msg = client.receiveMessage();
				msg.apply(view);
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

	public void setMessage(MessageGUI message){
		this.message = message;
	}

	public void communicate(Response response){
		client.sendResponse(response);
	}

	public void close(){
		client.close();
	}
}
