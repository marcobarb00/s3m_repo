package it.polimi.ingsw.s3m.launcher.Client.View;

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
	public void showLoginInfo(Login loginInfo){
		System.out.println(loginInfo.getMessage());
	}
}
