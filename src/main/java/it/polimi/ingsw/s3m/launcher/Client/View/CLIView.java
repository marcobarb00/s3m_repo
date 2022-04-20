package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.*;

import java.util.Scanner;

public class CLIView extends View{
	Scanner scanner;

	public CLIView(){
		this.scanner = new Scanner(System.in);
	}

	@Override
	public RoomMessage roomChoice(){
		System.out.println("do you want to create a new room or join an existing one?");
		System.out.println("1. create a new room");
		System.out.println("2. join an existing room");

		//let player insert their choice
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
			return new NewRoomMessage();
		}
		else{
			return new EnterRoomMessage();
		}
	}

	@Override
	public EnterRoomMessage enterRoom(){
		System.out.println("please insert the room ID");
		int roomID;
		try{
			roomID = Integer.parseInt(scanner.nextLine());
		}catch (Exception e){
			roomID = -1;
		}
		while(roomID < 0){
			System.out.println("invalid room ID");
			try{
				roomID = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				roomID = -1;
			}
		}

		System.out.println("please insert your nickname");
		String nickname = scanner.nextLine();

		EnterRoomMessage enterRoomMessage = new EnterRoomMessage();
		enterRoomMessage.setNickname(nickname);
		enterRoomMessage.setRoomID(roomID);
		return enterRoomMessage;
	}

	@Override
	public NewRoomMessage newRoom(){
		System.out.println("please insert the number of players in your room (2 or 3)");
		int playersNumber;
		try{
			playersNumber = Integer.parseInt(scanner.nextLine());
		}catch(Exception e){
			playersNumber = 0;
		}
		while(playersNumber != 2 && playersNumber != 3){
			System.out.println("you inserted an invalid input");
			try{
				playersNumber = Integer.parseInt(scanner.nextLine());
			}catch(Exception e){
				playersNumber = 0;
			}
		}

		System.out.println("please insert your nickname");
		String nickname = scanner.nextLine();

		NewRoomMessage newRoomMessage = new NewRoomMessage();
		newRoomMessage.setNickname(nickname);
		newRoomMessage.setPlayersNumber(playersNumber);
		return newRoomMessage;
	}

	@Override
	public void showEnterRoomResult(EnterRoomMessage enterRoomResult){
		System.out.println(enterRoomResult.getMessage());
	}

	@Override
	public void showNewRoomResult(NewRoomMessage newRoomResult){
		System.out.println(newRoomResult.getMessage());
	}

	@Override
	public void waitingForPlayers(){
		System.out.println("waiting for other players to join");
	}

	@Override
	public void showNotification(Notification notification){
		System.out.println(notification.getMessage());
	}
}
