package it.polimi.ingsw.s3m.launcher.Client.Network;

import it.polimi.ingsw.s3m.launcher.Client.View.CLI.ClientCLI;
import it.polimi.ingsw.s3m.launcher.Client.View.GuiController.StartGUI;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Network.Server;
import javafx.application.Platform;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{
	private final String serverip = Server.SERVERIP;
	private final int port = Server.PORT;
	private Socket socket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;

	public static void main(String[] args){
		System.out.println("do you want to use CLI or GUI?" +
				"\n1) CLI" +
				"\n2) GUI");

		Scanner scanner = new Scanner(System.in);
		int choiceView;
		try{
			choiceView = Integer.parseInt(scanner.nextLine());
		}catch (Exception e){
			choiceView = 0;
		}
		while(choiceView != 1 && choiceView != 2){
			System.out.println("\ninvalid choice, please press press 1 or 2 to choose");
			try{
				choiceView = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				choiceView = 0;
			}
		}

		switch(choiceView){
			case 1:
				ClientCLI client = new ClientCLI();
				client.start();
				break;
			case 2:
				StartGUI GUI = new StartGUI();
				GUI.startGUI();
				break;
			default:
				System.out.println("error");
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
