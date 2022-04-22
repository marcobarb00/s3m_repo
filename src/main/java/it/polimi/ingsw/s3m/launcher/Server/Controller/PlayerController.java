package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;

public class PlayerController{
	private ClientHandler client;
	private String nickname;
	private int RoomID;

	public PlayerController(ClientHandler client){
		this.client = client;
	}

	public String getNickname(){
		return nickname;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public int getRoomID(){
		return RoomID;
	}

	public void setRoomID(int roomID){
		RoomID = roomID;
	}

	public void sendMessage(Message message){
		System.out.println("XXX"+message);
		client.sendMessage(message);
	}

	public Message readMessage(){
		return client.readMessage();
	}

	public void login(){
		RoomsController.instance().login(this);
	}
}
