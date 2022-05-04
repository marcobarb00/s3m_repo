package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.ActivateCharacterCardMessage;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.MoveStudentsPhaseMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class MoveStudentsPhaseCLI implements MessageCLI{
	private ArrayList<CharacterCardDTO> characterCardDTOList;
	private boolean expertMode;
	private boolean characterCardActivated;

	public MoveStudentsPhaseCLI(MoveStudentsPhaseMessage moveStudentsPhaseMessage){}

	@Override
	public Message execute(){
		int studentsMoved = 0;

		System.out.println("student allocation phase");

		while(studentsMoved < 3){
			System.out.println("choose your operation:");

			if(expertMode)
				System.out.println("1) activate a character card");

			System.out.println("2) move a student from the hall to the tables" +
					"\n3) move a student from the hall to an island");

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
}