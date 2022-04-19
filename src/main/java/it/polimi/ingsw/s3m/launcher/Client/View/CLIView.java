package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.AskPlayersNumber;
import it.polimi.ingsw.s3m.launcher.Communication.Login;

import java.util.Scanner;

public class CLIView extends View{
	Scanner scanner;

	public CLIView(){
		this.scanner = new Scanner(System.in);
	}

	@Override
	public Login login(){
		System.out.println("please insert your nickname");
		String nickname = scanner.nextLine();
		return new Login(nickname);
	}

	@Override
	public void showLoginResult(Login loginResult){
		System.out.println(loginResult.getMessage());
	}

	@Override
	public AskPlayersNumber askPlayersNumber(){
		System.out.println("all the rooms are full, to create a new room please insert the number of players (2 or 3)");
		int playerNumber = scanner.nextInt();

		while(playerNumber != 2 && playerNumber != 3){
			System.out.println("you inserted an invalid input");
			playerNumber = scanner.nextInt();
		}

		return new AskPlayersNumber(playerNumber);
	}
}
