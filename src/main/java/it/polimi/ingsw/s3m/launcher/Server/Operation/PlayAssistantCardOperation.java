package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotEnoughAssistantCardsException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.AssistantCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;
import java.util.ArrayList;

//Done
public class PlayAssistantCardOperation extends Operation{
	private final int assistantCardPosition;

	public PlayAssistantCardOperation(Game game, PlayerController playerController, int assistantCardPosition){
		super(game, playerController);
		this.assistantCardPosition = assistantCardPosition;
	}

	/**
	 * checks if the arguments of the operation are valid, if so the game plays the selected assistant card
	 */
	@Override
	public void executeOperation() throws PlayerNotInListException,
			NotEnoughAssistantCardsException, IncorrectOperationException {
		//check args
		boolean checkArgs = game != null && playerController != null;
		if(!checkArgs) throw new IncorrectOperationException("Invalid arguments");

		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList) throw new PlayerNotInListException();

		ArrayList<AssistantCard> hand = game.getPlayerHand(playerController.getNickname());
		boolean checkAssistantCard = 0 <= assistantCardPosition && assistantCardPosition < hand.size();
		if(!checkAssistantCard) throw new IncorrectOperationException("Incorrect card position value");

		//check if already played in turn
		boolean checkCard = checkPlayableCard();
		if(!checkCard) throw new IncorrectOperationException("Assistant card already played");

		game.playAssistantCard(playerController.getNickname(), assistantCardPosition);
	}

	/**
	 * @return true if the selected assistant card is playable by the player
	 */
	private boolean checkPlayableCard(){
		ArrayList<AssistantCard> cardsPlayedInTurn = game.getTurnPlayedCards();
		Player player = game.getPlayerHashMap().get(playerController.getNickname());
		String handCardType = player.getHand().get(assistantCardPosition).getType();

		return cardsPlayedInTurn.stream().map(AssistantCard::getType).
				noneMatch(type -> type.equals(handCardType));
	}
}
