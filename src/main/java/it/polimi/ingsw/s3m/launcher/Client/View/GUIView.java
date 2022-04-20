package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.EnterRoomMessage;
import it.polimi.ingsw.s3m.launcher.Communication.NewRoomMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Notification;
import it.polimi.ingsw.s3m.launcher.Communication.RoomMessage;

public class GUIView extends View{
	@Override
	public RoomMessage roomChoice(){
		return null;
	}

	@Override
	public EnterRoomMessage enterRoom(){
		return null;
	}

	@Override
	public NewRoomMessage newRoom(){
		return null;
	}

	@Override
	public void showEnterRoomResult(EnterRoomMessage enterRoomResult){

	}

	@Override
	public void showNewRoomResult(NewRoomMessage newRoomResult){

	}

	@Override
	public void waitingForPlayers(){

	}

	@Override
	public void showNotification(Notification notification){

	}
}
