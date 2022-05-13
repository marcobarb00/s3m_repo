package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.AssistantCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

public class MoveMotherNatureOperation extends Operation{
	private final int movements;

	public MoveMotherNatureOperation(Game game, PlayerController playerController, int movements){
		super(game, playerController);
		this.movements = movements;
	}

	@Override
	public void executeOperation() throws PlayerNotInListException,
			NotPlayerTurnException, ZeroTowersRemainedException,
			NotEnoughIslandsException, IncorrectOperationException {

		//check args
		boolean checkArgs = game != null && playerController != null;
		if(!checkArgs){
			throw new IncorrectOperationException("Invalid arguments");
		}

		//check nickname
		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList){
			throw new PlayerNotInListException();
		}

		//check current player in turn
		boolean playerControllersTurn = checkCurrentPlayer();
		if(!playerControllersTurn){
			throw new NotPlayerTurnException();
		}

		//check if movements are legal given currentPlayer's assistantCard
		String playerNickname = playerController.getNickname();
		AssistantCard lastPlayedAssistantCard = game.getPlayerHashMap().get(playerNickname).getLastPlayedCard();
		int maxMoves = lastPlayedAssistantCard.getMovements();
		boolean checkMoves = 0 < movements && movements <= maxMoves;
		if(!checkMoves){
			throw new IncorrectOperationException("Incorrect mother nature moves value");
		}

		//these exceptions are handled in Room
		game.moveMotherNature(movements);
	}
}
