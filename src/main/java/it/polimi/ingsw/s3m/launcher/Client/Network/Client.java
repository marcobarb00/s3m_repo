package it.polimi.ingsw.s3m.launcher.Client.Network;

import it.polimi.ingsw.s3m.launcher.Server.Network.Server;

public class Client{
	private final String SERVERIP;
	private final int PORT = Server.PORT;

	public Client(String SERVERIP, int PORT){
		this.SERVERIP = SERVERIP;
	}

	public static void main(String[] args){
		Client client = new Client("127.0.0.1", 12000);
	}
}
