package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.EnterRoomMessage;
import it.polimi.ingsw.s3m.launcher.Communication.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.NewRoomMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginCLI implements MessageCLI{
	private int numberOfAvailableRooms;
	private ArrayList<Integer> availableRoomsID;
	private String message;

	LoginCLI(LoginMessage loginMessage){
		this.numberOfAvailableRooms = loginMessage.getNumberOfRooms();
		this.availableRoomsID = loginMessage.getAvailableRoomsID();
		this.message = loginMessage.getMessage();
	}

	@Override
	public Message execute(){
		System.out.println(message);
		if(numberOfAvailableRooms == 0){
			return newRoom();
		}

		System.out.println("do you want to create a new room or join an existing one?");
		System.out.println("1. create a new room");
		System.out.println("2. join an existing room");

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
			return newRoom();
		}else{
			return enterRoom();
		}
	}

	public NewRoomMessage newRoom(){
		System.out.println("please insert the number of players in your room (2 or 3)");
		Scanner scanner = new Scanner(System.in);
		int numbersOfPlayers;
		try{
			numbersOfPlayers = Integer.parseInt(scanner.nextLine());
		}catch(Exception e){
			numbersOfPlayers = 0;
		}
		while(numbersOfPlayers != 2 && numbersOfPlayers != 3){
			System.out.println("you inserted an invalid input");
			try{
				numbersOfPlayers = Integer.parseInt(scanner.nextLine());
			}catch(Exception e){
				numbersOfPlayers = 0;
			}
		}

		System.out.println("please insert your nickname");
		String nickname = scanner.nextLine();

		NewRoomMessage newRoomInfo = new NewRoomMessage();
		newRoomInfo.setNickname(nickname);
		newRoomInfo.setNumberOfPlayers(numbersOfPlayers);
		return newRoomInfo;
	}

	public EnterRoomMessage enterRoom(){
		System.out.println("ID's of rooms that are open");

		for(Integer roomID : availableRoomsID){
			System.out.println(roomID);
		}

		System.out.println("please insert the room ID to join that room");
		Scanner scanner = new Scanner(System.in);
		int roomID;
		try{
			roomID = Integer.parseInt(scanner.nextLine());
		}catch (Exception e){
			roomID = -1;
		}
		while(roomID < 0 || !availableRoomsID.contains(roomID)){
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
}
