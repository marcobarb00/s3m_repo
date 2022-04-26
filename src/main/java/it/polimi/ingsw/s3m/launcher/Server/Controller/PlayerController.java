package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;

public class PlayerController{
	private ClientHandler client;
	private String nickname;
	private int roomID;

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
		return roomID;
	}

	public void setRoomID(int roomID){
		this.roomID = roomID;
	}

	public Message communicateWithClient(Message message){
		return client.communicateWithClient(message);
	}

	public void login(){
		RoomsController.instance().login(this);
	}

	public void disconnect(){
		RoomsController.instance().deleteRoom(roomID, this);
	}
}
