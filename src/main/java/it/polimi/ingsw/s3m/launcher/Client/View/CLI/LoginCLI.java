package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.EnterRoomMessage;
import it.polimi.ingsw.s3m.launcher.Communication.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.NewRoomMessage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class LoginCLI implements MessageCLI{
	private int numberOfAvailableRooms;

	LoginCLI(LoginMessage loginMessage){
		this.numberOfAvailableRooms = loginMessage.getNumberOfRooms();
	}

	@Override
	public Message execute(){
		LoginMessage loginInfo = new LoginMessage();
		if(numberOfAvailableRooms == 0){
			System.out.println("there are no rooms available, create a new room!");
			loginInfo.setNewRoom(true);
			return loginInfo;
		}

		System.out.println("do you want to create a new room or join an existing one?" +
				"\n1) create a new room" +
				"\n2) join an existing room");

		//let player insert their choice
		Scanner scanner = new Scanner(System.in);
		int choiceRoom;
		try{
			choiceRoom = Integer.parseInt(scanner.nextLine());
		}catch (Exception e){
			choiceRoom = 0;
		}
		while(choiceRoom != 1 && choiceRoom != 2){
			System.out.println("invalid choice, please press press 1 or 2 to choose");
			try{
				choiceRoom = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				choiceRoom = 0;
			}
		}

		if(choiceRoom == 1){
			loginInfo.setNewRoom(true);
			return loginInfo;
		}else{
			loginInfo.setNewRoom(false);
			return loginInfo;
		}
	}
}
