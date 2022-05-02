package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.PlayAssistantCardMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayAssistantCardCLI implements MessageCLI{
	private ArrayList<AssistantCardDTO> assistantCardDTOList;

	public PlayAssistantCardCLI(PlayAssistantCardMessage playAssistantCardMessage){
		this.assistantCardDTOList = playAssistantCardMessage.getAssistantCardMessageList();
	}

	@Override
	public Message execute(){
		System.out.println("your hand:");
		for(int i = 0; i < assistantCardDTOList.size(); i++){
			AssistantCardDTO assistantCardDTO = assistantCardDTOList.get(i);
			System.out.println(i + ") " + assistantCardDTO.getType() +
					"\n value: " + assistantCardDTO.getValue() +
					"\n movement: " + assistantCardDTO.getMovements());
		}

		Scanner scanner = new Scanner(System.in);
		int choice;
		try{
			choice = Integer.parseInt(scanner.nextLine());
		}catch(Exception e){
			choice = -1;
		}
		while(choice < 0 || choice >= assistantCardDTOList.size()){
			System.out.println("invalid input, to choose a card insert a number between 0 and " + assistantCardDTOList.size());
		}

		PlayAssistantCardMessage playAssistantCardMessage = new PlayAssistantCardMessage();
		playAssistantCardMessage.setCardChosen(choice);
		return playAssistantCardMessage;
	}
}
