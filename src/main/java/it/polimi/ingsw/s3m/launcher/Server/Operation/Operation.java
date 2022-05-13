package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.CharacterCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

public abstract class Operation{
	//Game is instantiated in room.start() method
	protected Game game;
	protected PlayerController playerController;

	public Operation(Game game, PlayerController playerController){
		this.playerController = playerController;
		this.game = game;
	}

	public abstract void executeOperation() throws PlayerNotInListException, CloudNotInListException,
			NotExpertModeException,
			NotEnoughCoinsException, NotPlayerTurnException,
			ZeroTowersRemainedException, NotEnoughIslandsException, NotEnoughAssistantCardsException, CharacterCardAlreadyActivatedException, IncorrectOperationException;

	public boolean checkNickname(){
		ArrayList<String> playersList = game.getPlayersNicknames();
		boolean playerControllerInList = playersList.contains(playerController.getNickname());
		return playerControllerInList;
	}

	public boolean checkCharacterCardCost(String cardName){
		ArrayList<CharacterCard> cards = game.getCharacterCardsList();
		CharacterCard card = null;
		for(CharacterCard c : cards){
			if(c.getName().equals(cardName))
				card = c;
		}
		String nickname = playerController.getNickname();
		int coins = game.getPlayerHashMap().get(nickname).getCoins();

		return coins >= card.getCost();
	}

	public boolean checkCurrentPlayer(){
		String currentPlayer = game.getTurn().getCurrentPlayerNickname();
		return playerController.getNickname().equals(currentPlayer);
	}

	public void checkMovableStudent() throws IncorrectOperationException {
		// TODO talk about this
		//3 players mode check
		int maxMovableStudents = 3;
		boolean threePlayersMode = game.getNumberOfPlayers() == 3;
		if(threePlayersMode){
			maxMovableStudents = 4;
		}
		int movedStudentsInTurn = game.getTurnMovedStudents();
		if(movedStudentsInTurn >= maxMovableStudents){
			throw new IncorrectOperationException("Cannot move another student");
		}
	}
}
