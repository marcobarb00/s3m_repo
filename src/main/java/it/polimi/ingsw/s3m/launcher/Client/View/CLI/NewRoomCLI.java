package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.NewRoomMessage;

import java.util.Scanner;

public class NewRoomCLI implements MessageCLI{
	private String nickname;
	private Integer roomID;
	private int numberOfPlayers;
	private String message;

	public NewRoomCLI(NewRoomMessage newRoomMessage){
		this.nickname = newRoomMessage.getNickname();
		this.roomID = newRoomMessage.getRoomID();
		this.numberOfPlayers = newRoomMessage.getNumberOfPlayers();
		this.message = newRoomMessage.getMessage();
	}

	@Override
	public Message execute(){
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

		System.out.println("do you want to play expert mode? Y/N");
		String expertModeChoice = scanner.nextLine();
		while(!expertModeChoice.equalsIgnoreCase("Y") && !expertModeChoice.equalsIgnoreCase("N")){
			System.out.println("you inserted an invalid input");
			expertModeChoice = scanner.nextLine();
		}

		boolean expertChoice = expertModeChoice.equalsIgnoreCase("Y");

		System.out.println("please insert your nickname");
		String nickname = scanner.nextLine();

		NewRoomMessage newRoomInfo = new NewRoomMessage();
		newRoomInfo.setNickname(nickname);
		newRoomInfo.setNumberOfPlayers(numbersOfPlayers);
		newRoomInfo.setExpertMode(expertChoice);
		return newRoomInfo;
	}
}
