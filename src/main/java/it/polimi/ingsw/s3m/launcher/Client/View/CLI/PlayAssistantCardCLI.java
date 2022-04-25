package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.AssistantCardMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.PlayAssistantCardMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayAssistantCardCLI implements MessageCLI{
	private ArrayList<AssistantCardMessage> assistantCardMessageList;

	public PlayAssistantCardCLI(PlayAssistantCardMessage playAssistantCardMessage){
		this.assistantCardMessageList = playAssistantCardMessage.getAssistantCardMessageList();
	}

	@Override
	public Message execute(){
		System.out.println("your hand:");
		for(int i = 0; i < assistantCardMessageList.size(); i++){
			AssistantCardMessage assistantCardMessage = assistantCardMessageList.get(i);
			System.out.println(i + ") " + assistantCardMessage.getType() +
					"\n value: " + assistantCardMessage.getValue() +
					"\n movement: " + assistantCardMessage.getMovements());
		}

		Scanner scanner = new Scanner(System.in);
		int choice;
		try{
			choice = Integer.parseInt(scanner.nextLine());
		}catch(Exception e){
			choice = -1;
		}
		while(choice < 0 || choice >= assistantCardMessageList.size()){
			System.out.println("invalid input, to choose a card insert a number between 0 and " + assistantCardMessageList.size());
		}

		PlayAssistantCardMessage playAssistantCardMessage = new PlayAssistantCardMessage();
		playAssistantCardMessage.setCardChosen(choice);
		return playAssistantCardMessage;
	}
}
