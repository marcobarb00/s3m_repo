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
		startGame();
	}

	public void readNotificationFromServer(){
		Notification notification = (Notification) client.recieveMessage();
		notification.read(this);
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

	public void startGame(){
		view.waitingForPlayers();
		readNotificationFromServer();
		//START THE GAME
	}

	/**
	 * gets the information to create a new room and then returns the results
	 * @param newRoomMessage null
	 * @return result of the new room creation
	 */
	@Override
	public NewRoomMessage executeNewRoom(NewRoomMessage newRoomMessage){
		NewRoomMessage newRoomInfo = view.newRoom();
		client.sendMessage(newRoomInfo);
		NewRoomMessage newRoomResult = (NewRoomMessage) client.recieveMessage();
		view.showNewRoomResult(newRoomResult);
		return newRoomResult;
	}

	/**
	 * gets the information to join a new room and then returns the results
	 * @param enterRoomMessage null
	 * @return result of the attempt to join a new room
	 */
	@Override
	public EnterRoomMessage executeEnterRoom(EnterRoomMessage enterRoomMessage){
		EnterRoomMessage enterRoomResult;
		EnterRoomMessage enterRoomInfo = view.enterRoom();
		client.sendMessage(enterRoomInfo);
		enterRoomResult = (EnterRoomMessage) client.recieveMessage();
		view.showEnterRoomResult(enterRoomResult);
		return enterRoomResult;
	}

	@Override
	public void readNotification(Notification notification){
		view.showNotification(notification);
	}
}
