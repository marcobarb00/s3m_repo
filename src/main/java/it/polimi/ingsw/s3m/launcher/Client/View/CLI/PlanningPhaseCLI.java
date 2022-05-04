package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;

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
	public Response execute(){
		if(playedAssistantCards.size() != 0){
			System.out.println("\ncards played by the other players:");
			for(AssistantCardDTO assistantCard : playedAssistantCards){
				printAssistantCard(assistantCard);
			}
		}

		System.out.println("\nyour hand:");
		for(int i = 0; i < hand.size(); i++){
			System.out.println("index: " + i);
			printAssistantCard(hand.get(i));
		}

		System.out.println("\nselect the index of the assistant card you want to play");
		Scanner scanner = new Scanner(System.in);
		int cardChoice;
		try{
			cardChoice = Integer.parseInt(scanner.nextLine());
		}catch (Exception e){
			cardChoice = -1;
		}
		while(cardChoice < 0 || cardChoice > hand.size()){
			System.out.println("\ninvalid choice, please select a valid index of the card");
			try{
				cardChoice = Integer.parseInt(scanner.nextLine());
			}catch (Exception e){
				cardChoice = -1;
			}
		}

		PlayAssistantCardResponse cardChosen = new PlayAssistantCardResponse();
		cardChosen.setCardChosen(cardChoice);
		return cardChosen;
	}

	private void printAssistantCard(AssistantCardDTO assistantCard){
		System.out.println("name: " + assistantCard.getType() + "\tvalue: " + assistantCard.getValue() + "\tmovements: " + assistantCard.getMovements());
	}
}
