package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.MoveStudentsPhaseMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveStudentsPhaseCLI implements MessageCLI{
	private ArrayList<CharacterCardDTO> characterCardDTOList;
	private boolean expertMode;
	private boolean threePlayerMode;
	private boolean characterCardActivated;

	public MoveStudentsPhaseCLI(MoveStudentsPhaseMessage moveStudentsPhaseMessage){}

	@Override
	public Response execute(){
		int studentsMoved = 0;

		System.out.println("student allocation phase");

		//Checking if 3 or 4 mode game
		int studentsToBeMoved = 3;
		if(threePlayerMode){
			studentsToBeMoved = 4;
		}

		while(studentsMoved < studentsToBeMoved){
			//Options menu
			System.out.println("choose your operation:");
			System.out.println(	"1) move a student from the hall to the tables" +
								"2) move a student from the hall to an island\"");
			if(expertMode) {
				System.out.println("3) activate a character card" );
			}

			Scanner scanner = new Scanner(System.in);
			int operationChoice;
			try{
				operationChoice = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				operationChoice = 0;
			}

			while(operationChoice < 1 || operationChoice > 3){
				System.out.println("\ninvalid choice, please select a valid operation");
				try{
					operationChoice = Integer.parseInt(scanner.nextLine());
				}catch (Exception e){
					operationChoice = 0;
				}
			}

			switch(operationChoice){
				case 1:
					chooseCharacterCard();
					break;
				case 2:
					studentsMoved++;
					break;
				case 3:
					studentsMoved++;
					break;
				default:
			}
		}

		return null;
	}

	public void chooseCharacterCard(){
		characterCardActivated = true;
	}

	public void setThreePlayerMode(boolean threePlayerMode){
		this.threePlayerMode = threePlayerMode;
	}

	public void setExpertMode(boolean expertMode) {
		this.expertMode = expertMode;
	}
}