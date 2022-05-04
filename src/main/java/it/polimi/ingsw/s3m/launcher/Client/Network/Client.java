package it.polimi.ingsw.s3m.launcher.Client.Network;

import it.polimi.ingsw.s3m.launcher.Client.View.CLI.ClientCLI;
import it.polimi.ingsw.s3m.launcher.Client.View.GuiController.StartGUI;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Network.Server;
import javafx.application.Platform;

import java.io.*;
import java.net.Socket;

public class Client{
	private final String serverip = Server.SERVERIP;
	private final int port = Server.PORT;
	private Socket socket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;

	public static void main(String[] args){
		if(args[0].equals("CLI")) {
			ClientCLI client = new ClientCLI();
			client.start();
		}else{
			StartGUI GUI = new StartGUI();
			GUI.startGUI();
		}
	}

	/**
	 * creates socket and Input/OutputObjectStream
	 */
	public void start(){
		try{
			socket = new Socket(serverip, port);
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream = new ObjectInputStream(socket.getInputStream());
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * sends a response to the server
	 * @param response response to be sent
	 */
	public void sendResponse(Response response){
		try{
			outputStream.writeObject(response);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * receive a message from the server
	 * @return message received
	 */
	public Message receiveMessage(){
		try{
			return (Message) inputStream.readObject();
		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}

	public void close() {
		try {
			inputStream.close();
			outputStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
