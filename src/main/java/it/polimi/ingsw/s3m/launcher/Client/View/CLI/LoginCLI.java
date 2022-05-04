package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.View.Response.LoginResponse;
import it.polimi.ingsw.s3m.launcher.Server.Message.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Response;

import java.util.Scanner;

public class LoginCLI implements MessageCLI{
	LoginCLI(LoginMessage loginMessage){}

	@Override
	public Response execute(){
		LoginResponse loginInfo = new LoginResponse();

		System.out.println("\ndo you want to create a new room or join an existing one?" +
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
			System.out.println("\ninvalid choice, please press press 1 or 2 to choose");
			try{
				choiceRoom = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				choiceRoom = 0;
			}
		}

		loginInfo.setNewRoom(choiceRoom == 1);
		return loginInfo;
	}
}
