package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.MoveStudentsResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.StudentMove;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.MoveStudentsPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.Student;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MoveStudentsPhaseCLI implements MessageCLI{
	private GameDTO gameState;
	private int selectedCharacterCard;			//To put in response constructor
	private boolean characterCardActivated;
	private int studentsMoved;
	private int studentsToBeMoved;
	private ArrayList<StudentMove> studentToMove;

	public MoveStudentsPhaseCLI(MoveStudentsPhaseMessage moveStudentsPhaseMessage){
		this.gameState = moveStudentsPhaseMessage.getGameState();
	}

	@Override
	public Response execute(){
		System.out.println("student allocation phase");

		//Checking if 3 or 4 mode game
		int studentsToBeMoved = 3;
		if(gameState.getPlayersNumber() == 3){
			studentsToBeMoved = 4;
		}

		while(studentsMoved < studentsToBeMoved){
			int maxOperationNumber = 2;

			//Options menu
			System.out.println("choose your operation:");
			System.out.println("1) move a student from the hall to the tables" +
							   "\n2) move a student from the hall to an island");
			if(gameState.isExpertMode()) {
				System.out.println("3) activate a character card" );
				maxOperationNumber = 3;
			}

			int operationChoice = getOperation();
			checkOperation(operationChoice, maxOperationNumber);

			HashMap<Integer, Runnable> operations = setOperations();
			operations.get(operationChoice).run();
			}

		//TODO return students response
		//return new MoveStudentsResponse(characterCardActivated, selectedCharacterCard, studentsToBeMoved );
		return null;
	}

	public void chooseCharacterCard(){
		ArrayList<CharacterCardDTO> characterCardDTOList = gameState.getCharacterCards();

		System.out.println("choose character card:");
		int cardsNumber = characterCardDTOList.size();
		for (int i = 0; i < cardsNumber; i++) {
			CharacterCardDTO card = characterCardDTOList.get(i);
			System.out.println((i+1) + ") " + card.getName() + " cost: " + card.getCost());
		}

		selectedCharacterCard = getOperation() - 1;
		checkOperation(selectedCharacterCard, characterCardDTOList.size());
		characterCardActivated = true;
	}

	private int getOperation(){
		Scanner scanner = new Scanner(System.in);
		int operationChoice;
		try{
			operationChoice = Integer.parseInt(scanner.nextLine());
		}catch (Exception e){
			operationChoice = 0;
		}
		return operationChoice;
	}

	private void checkOperation(int operationChoice, int maxOperationNumber){
		Scanner scanner = new Scanner(System.in);
		while(operationChoice < 1 || operationChoice > maxOperationNumber){
			System.out.println("\ninvalid choice, please select a valid input");
			try{
				operationChoice = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				operationChoice = 0;
			}
		}
	}

	//TODO needs gameState
	private void chooseIsland(){
		//System.out.println("choose an island from 1 to " + (islandList.size() - 1));

		System.out.println("choose a color");
		System.out.println("1) RED	2) GREEN");
		System.out.println("3) BLUE	4) PINK");
		System.out.println("5) YELLOW");

		//studentsToMove.add(new StudentMove(studentColor, true, islandPosition));
		this.studentsMoved++;
	}

	private void chooseColor(){
		System.out.println("choose a color");
		this.studentsMoved++;
	}

	private HashMap<Integer, Runnable> setOperations(){
		HashMap<Integer, Runnable> operations = new HashMap<>();
		operations.put(1, () -> chooseIsland() );
		operations.put(2, () ->  chooseColor());
		operations.put(3, () -> chooseCharacterCard() );
		return operations;
	}
}