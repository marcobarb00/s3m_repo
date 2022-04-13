package it.polimi.ingsw.s3m.launcher.Client.Network;

import it.polimi.ingsw.s3m.launcher.Server.Network.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client{
	private final String SERVERIP = "localhost";
	private final int PORT = Server.PORT;
	private Socket socket;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outPutStream;

	public static void main(String[] args){
		//TODO CLIclient/GUIclient
		Client client = new Client();
	}

	public void startClient(){
		try{
			socket = new Socket(SERVERIP, PORT);
			inputStream = new ObjectInputStream(socket.getInputStream());
			outPutStream = new ObjectOutputStream(socket.getOutputStream());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
