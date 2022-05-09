package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.StudentsPhaseResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.StudentsPhaseMessage;

public class MoveStudentsPhaseCLI extends MessageCLI{
	private GameDTO gameState;

	public MoveStudentsPhaseCLI(StudentsPhaseMessage moveStudentsPhaseMessage){
		this.gameState = moveStudentsPhaseMessage.getGameState();
	}

	//TODO Action phase doesn't start in CLI
	@Override
	public Response execute(){
		GameStateCLI gameStateCLI = new GameStateCLI(gameState);
		gameStateCLI.printState();

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

		int chosenPhase = getOperation(maxOperationNumber);
		return new StudentsPhaseResponse(chosenPhase);
	}
}