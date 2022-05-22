package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.LoginResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.LoginMessage;

import java.util.Scanner;

public class LoginCLI extends MessageCLI{
	LoginCLI(LoginMessage loginMessage){
	}

	@Override
	public Response execute(){
		System.out.println("\ndo you want to create a new room or join an existing one?" +
				"\n1) create a new room" +
				"\n2) join an existing room");

		//let player insert their choice
		Scanner scanner = new Scanner(System.in);
		int choiceRoom;
		try{
			choiceRoom = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e){
			choiceRoom = 0;
		}
		while(choiceRoom != 1 && choiceRoom != 2){
			System.out.println("\ninvalid choice, please press press 1 or 2 to choose");
			try{
				choiceRoom = Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e){
				choiceRoom = 0;
			}
		}

		return new LoginResponse(choiceRoom == 1);
	}
}
