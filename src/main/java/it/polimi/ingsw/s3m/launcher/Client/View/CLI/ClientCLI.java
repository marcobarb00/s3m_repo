package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Network.Client;
import it.polimi.ingsw.s3m.launcher.Server.Message.Message;
import it.polimi.ingsw.s3m.launcher.Server.Message.Notification;
import it.polimi.ingsw.s3m.launcher.Client.Response.Response;

public class ClientCLI{
	private Client client;
	private CLIView view;
	private MessageCLI message;

	public void start(){
		this.view = new CLIView(this);
		this.client = new Client();
		client.start();

		while(true){
			try{
				Message receivedMessage = client.receiveMessage();
				receivedMessage.apply(view);
				if(receivedMessage instanceof Notification){
					message.execute();
				}else{
					Response toSendMessage = message.execute();
					client.sendResponse(toSendMessage);
				}
			}catch(NullPointerException e){
				System.out.println("received a null message, the application is closing");
				break;
			}catch(Exception e){
				e.printStackTrace();
				break;
			}
		}
	}

	public void setMessage(MessageCLI message){
		this.message = message;
	}
}
