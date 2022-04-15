package it.polimi.ingsw.s3m.launcher.Client.Network;

import it.polimi.ingsw.s3m.launcher.Client.Controller.ClientController;
import it.polimi.ingsw.s3m.launcher.Client.View.CLIView;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIView;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Server.Network.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client{
	private final String serverip = Server.SERVERIP;
	private final int port = Server.PORT;
	private Socket socket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outPutStream;

	public static void main(String[] args){
		ClientController clientController;
		if(args[1].equals("CLI"))
			 clientController = new ClientController(new CLIView());
		else
			clientController = new ClientController(new GUIView());
	}

	/**
	 * creates socket and Input/OutputObjectStream
	 */
	public void start(){
		try{
			socket = new Socket(serverip, port);
			inputStream = new ObjectInputStream(socket.getInputStream());
			outPutStream = new ObjectOutputStream(socket.getOutputStream());
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * sends a message to the server
	 * @param message message to be sent
	 */
	public void sendMessage(Message message){
		try{
			outPutStream.writeObject(message);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * recieve a message from the server
	 * @return message recieved
	 */
	public Message recieveMessage(){
		try{
			return (Message) inputStream.readObject();
		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
}
