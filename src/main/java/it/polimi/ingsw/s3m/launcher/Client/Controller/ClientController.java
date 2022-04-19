package it.polimi.ingsw.s3m.launcher.Client.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Network.Client;
import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.*;

public class ClientController implements ControllerInterface{
	Client client;
	View view;

	public ClientController(View view){
		this.view = view;
		this.client = new Client();
		client.start();
		login();
	}

	/**
	 * creates a login request to the server until a successful login
	 */
	public void login(){
		RoomMessage loginResult;
		do{
			RoomMessage roomInfo = view.roomChoice();
			loginResult = roomInfo.execute(this);
		}while(!loginResult.isSuccessful());
	}

	@Override
	public NewRoomMessage executeNewRoom(NewRoomMessage newRoomMessage){
		NewRoomMessage newRoomInfo = view.newRoom();
		client.sendMessage(newRoomInfo);
		NewRoomMessage newRoomResult = (NewRoomMessage) client.recieveMessage();
		view.showNewRoomResult(newRoomResult);
		return newRoomResult;
	}

	@Override
	public EnterRoomMessage executeEnterRoom(EnterRoomMessage enterRoomMessage){
		EnterRoomMessage enterRoomResult;
		EnterRoomMessage enterRoomInfo = view.enterRoom();
		client.sendMessage(enterRoomInfo);
		enterRoomResult = (EnterRoomMessage) client.recieveMessage();
		view.showEnterRoomResult(enterRoomResult);
		return enterRoomResult;
	}
}
