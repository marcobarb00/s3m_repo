package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

import java.util.Scanner;

public abstract class MessageCLI{
	public abstract Response execute();

	protected int getOperation(int maxOperationNumber){
		Scanner scanner = new Scanner(System.in);
		int operationChoice;
		try{
			operationChoice = Integer.parseInt(scanner.nextLine());
		}catch(Exception e){
			operationChoice = 0;
		}

		while(operationChoice < 1 || operationChoice > maxOperationNumber){
			System.out.println("\ninvalid choice, please select a valid input");
			try{
				operationChoice = Integer.parseInt(scanner.nextLine());
			}catch(Exception e){
				operationChoice = 0;
			}
		}
		return operationChoice;
	}
}
