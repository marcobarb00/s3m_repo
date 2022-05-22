package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.StudentsPhaseResponse;
import it.polimi.ingsw.s3m.launcher.DTOs.GameDTO;
import it.polimi.ingsw.s3m.launcher.Client.Response.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.StudentsPhaseMessage;

public class MoveStudentsPhaseCLI extends MessageCLI{
	private final GameDTO gameState;

	public MoveStudentsPhaseCLI(StudentsPhaseMessage moveStudentsPhaseMessage){
		this.gameState = moveStudentsPhaseMessage.getGameState();
	}

	@Override
	public Response execute(){
		GameStateCLI gameStateCLI = new GameStateCLI(gameState);
		gameStateCLI.printState();

		System.out.println("student allocation phase");
		int maxOperationNumber = 2;

		//Options menu
		System.out.println("choose your operation:" +
				"\n1) move a student from the entrance to the tables" +
				"\n2) move a student from the entrance to an island");
		//If not activated you can play a character
		if(gameState.isExpertMode() && !gameState.getTurn().isCharacterCardActivated()){
			System.out.println("3) activate a character card");
			maxOperationNumber = 3;
		}

		int chosenPhase = getOperation(maxOperationNumber);
		return new StudentsPhaseResponse(chosenPhase);
	}
}