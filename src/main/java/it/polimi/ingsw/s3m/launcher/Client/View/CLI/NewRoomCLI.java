package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.NewRoomResponse;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.NewRoomMessage;

import java.util.Scanner;

public class NewRoomCLI extends MessageCLI{

	public NewRoomCLI(NewRoomMessage newRoomMessage){
	}

	@Override
	public Response execute(){
		System.out.println("\nplease insert the number of players in your room (2 or 3)");
		Scanner scanner = new Scanner(System.in);
		int numbersOfPlayers;
		try{
			numbersOfPlayers = Integer.parseInt(scanner.nextLine());
		}catch(Exception e){
			numbersOfPlayers = 0;
		}
		while(numbersOfPlayers != 2 && numbersOfPlayers != 3){
			System.out.println("\nyou inserted an invalid input");
			try{
				numbersOfPlayers = Integer.parseInt(scanner.nextLine());
			}catch(Exception e){
				numbersOfPlayers = 0;
			}
		}

		System.out.println("\ndo you want to play expert mode? Y/N");
		String expertModeChoice = scanner.nextLine();
		while(!expertModeChoice.equalsIgnoreCase("Y") && !expertModeChoice.equalsIgnoreCase("N")){
			System.out.println("\nyou inserted an invalid input");
			expertModeChoice = scanner.nextLine();
		}

		boolean expertChoice = expertModeChoice.equalsIgnoreCase("Y");

		System.out.println("\nplease insert your nickname");
		String nickname = scanner.nextLine();

		return new NewRoomResponse(nickname, numbersOfPlayers, expertChoice);
	}
}
