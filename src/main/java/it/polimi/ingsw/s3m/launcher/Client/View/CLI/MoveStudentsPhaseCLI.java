package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.MoveStudentsPhaseResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.StudentMove;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.MoveStudentsPhaseMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class MoveStudentsPhaseCLI extends MessageCLI{
	private GameDTO gameState;

	public MoveStudentsPhaseCLI(MoveStudentsPhaseMessage moveStudentsPhaseMessage){
		this.gameState = moveStudentsPhaseMessage.getGameState();
	}

	@Override
	public Response execute(){
		System.out.println("student allocation phase");
		int maxOperationNumber = 2;

		//Options menu
		System.out.println("choose your operation:" +
						   "\n1) move a student from the hall to the tables" +
						   "\n2) move a student from the hall to an island");
		//If not activated you can play a character
		if(gameState.isExpertMode() && !gameState.getTurn().isCharacterCardActivated()) {
			System.out.println("3) activate a character card" );
			maxOperationNumber = 3;
		}

		int operationChoice = getOperation(maxOperationNumber);
		return new MoveStudentsPhaseResponse(operationChoice);
	}
}