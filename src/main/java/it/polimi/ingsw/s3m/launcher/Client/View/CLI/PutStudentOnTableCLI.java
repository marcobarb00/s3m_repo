package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.PutStudentOnTableMessage;

import java.util.ArrayList;
import java.util.Arrays;

public class PutStudentOnTableCLI extends MessageCLI{
	GameDTO gameState;

	public PutStudentOnTableCLI(PutStudentOnTableMessage putStudentOnTableMessage){
		this.gameState = putStudentOnTableMessage.getGameState();
	}

	@Override
	public Response execute(){
		System.out.println("choose a color");
		System.out.println("1) RED	2) GREEN");
		System.out.println("3) BLUE	4) PINK");
		System.out.println("5) YELLOW");
		int colorCodeChoice = getOperation(5);
		String studentColor = getCLIColor(colorCodeChoice);

		return new PutStudentOnTableResponse(studentColor);
	}

	private String getCLIColor(int code){
		//Do not modify order
		ArrayList<String> colors = new ArrayList<>(
				Arrays.asList("RED", "GREEN", "BLUE",
						"PINK", "YELLOW"));
		return colors.get(code - 1);
	}
}
