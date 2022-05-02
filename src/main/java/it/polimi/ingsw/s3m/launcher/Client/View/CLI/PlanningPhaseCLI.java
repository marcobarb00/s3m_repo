package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.PlanningPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Communication.PlayAssistantCardMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class PlanningPhaseCLI implements MessageCLI{
	ArrayList<AssistantCardDTO> playedAssistantCards;
	ArrayList<AssistantCardDTO> hand;

	public PlanningPhaseCLI(PlanningPhaseMessage planningPhaseMessage){
		this.playedAssistantCards = planningPhaseMessage.getPlayedAssistantCards();
		this.hand = planningPhaseMessage.getHand();
	}

	@Override
	public Message execute(){
		System.out.println("cards played by the other players");
		for(AssistantCardDTO assistantCard : playedAssistantCards){
			printAssistantCard(assistantCard);
		}

		System.out.println("select the index of the assistant card you want to play");
		Scanner scanner = new Scanner(System.in);
		int cardChoice;
		try{
			cardChoice = Integer.parseInt(scanner.nextLine());
		}catch (Exception e){
			cardChoice = -1;
		}
		while(cardChoice < 0 || cardChoice > hand.size()){
			System.out.println("invalid choice, please select a valid index of the card");
			try{
				cardChoice = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				cardChoice = -1;
			}
		}

		PlayAssistantCardMessage cardChosen = new PlayAssistantCardMessage();
		cardChosen.setCardChosen(cardChoice);
		return cardChosen;
	}

	private void printAssistantCard(AssistantCardDTO assistantCard){
		System.out.println("name: " + assistantCard.getType());
		System.out.println("value: " + assistantCard.getValue());
		System.out.println("movements: " + assistantCard.getMovements());
	}
}
