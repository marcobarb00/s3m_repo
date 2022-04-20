package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;

import java.util.Scanner;

public class CLIView extends View{
	Scanner scanner;

	public CLIView(){
		this.scanner = new Scanner(System.in);
	}

	@Override
	public LoginMessage login(){
		System.out.println("do you want to create a new room or join an existing one?");
		System.out.println("1. create a new room");
		System.out.println("2. join an existing room");

		//let player insert their choice
		int roomChoice;
		try{
			roomChoice = Integer.parseInt(scanner.nextLine());
		}catch (Exception e){
			roomChoice = 0;
		}
		while(roomChoice != 1 && roomChoice != 2){
			System.out.println("invalid choice, please press press 1 or 2 to choose");
			try{
				roomChoice = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				roomChoice = 0;
			}
		}

		if(roomChoice == 1){
			return newRoom();
		}
		else{
			return enterRoom();
		}
	}

	@Override
	public LoginMessage enterRoom(){
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

		LoginMessage loginInfo = new LoginMessage();
		loginInfo.setNewRoom(false);
		loginInfo.setNickname(nickname);
		loginInfo.setRoomID(roomID);
		return loginInfo;
	}

	@Override
	public LoginMessage newRoom(){
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

		LoginMessage loginInfo = new LoginMessage();
		loginInfo.setNewRoom(true);
		loginInfo.setNickname(nickname);
		loginInfo.setPlayersNumber(playersNumber);
		return loginInfo;
	}

	@Override
	public void showLoginResult(LoginMessage loginResult){
		System.out.println(loginResult.getMessage());
	}

	@Override
	public void waitingForPlayers(){
		System.out.println("waiting for other players to join");
	}

	@Override
	public void showNotification(NotificationMessage notification){
		System.out.println(notification.getMessage());
	}
}
