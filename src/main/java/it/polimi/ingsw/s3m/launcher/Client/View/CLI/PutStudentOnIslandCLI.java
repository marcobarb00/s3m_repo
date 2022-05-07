package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnIslandResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.PutStudentOnIslandMessage;

import java.util.ArrayList;
import java.util.Arrays;

public class PutStudentOnIslandCLI extends MessageCLI{
	GameDTO gameState;

	public PutStudentOnIslandCLI(PutStudentOnIslandMessage putStudentOnIslandMessage){
		this.gameState = putStudentOnIslandMessage.getGameState();
	}

	@Override
	public Response execute(){
		int islandsNumber = gameState.getIslands().size();
		System.out.println("choose an island from 1 to " + islandsNumber);
		int islandPosition = getOperation(islandsNumber) - 1;

		//Do not modify order
		System.out.println("choose a color");
		System.out.println("1) RED	2) GREEN");
		System.out.println("3) BLUE	4) PINK");
		System.out.println("5) YELLOW");
		int colorCodeChoice = getOperation(5);
		String studentColor = getCLIColor(colorCodeChoice);

		return new PutStudentOnIslandResponse(studentColor, islandPosition);
	}

	private String getCLIColor(int code){
		//Do not modify order
		ArrayList<String> colors = new ArrayList<>(
				Arrays.asList("RED", "GREEN", "BLUE",
						"PINK", "YELLOW"));
		return colors.get(code - 1);
	}
}
