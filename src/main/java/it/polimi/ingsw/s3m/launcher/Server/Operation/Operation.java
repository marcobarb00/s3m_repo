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

	/**
	 * common method to execute an operation
	 * @throws PlayerNotInListException thrown if the player that executed the operation is not in the player list of the room
	 * @throws CloudNotInListException thrown if the cloud selected is not in the list of clouds in the game
	 * @throws NotExpertModeException thrown if the player tries to play a character card but the game is not in expert mode
	 * @throws NotEnoughCoinsException thrown if the player doesn't have enough coins to play the selected character card
	 * @throws NotPlayerTurnException thrown if the server receives an operation from a player that is not the current player turn
	 * @throws ZeroTowersRemainedException thrown if a player finishes his towers
	 * @throws NotEnoughIslandsException thrown if there are less than four islands in the game
	 * @throws NotEnoughAssistantCardsException thrown if a player finishes his assistant cards
	 * @throws CharacterCardAlreadyActivatedException thrown if a player tries to activate a character card that has already been played in the current turn
	 * @throws IncorrectOperationException thrown if a player tries to do an operation that should not be done in the current phase or the player gives an invalid input
	 */
	public abstract void executeOperation() throws PlayerNotInListException, CloudNotInListException,
			NotExpertModeException,
			NotEnoughCoinsException, NotPlayerTurnException,
			ZeroTowersRemainedException, NotEnoughIslandsException, NotEnoughAssistantCardsException, CharacterCardAlreadyActivatedException, IncorrectOperationException;

	public boolean checkNickname(){
		ArrayList<String> playersList = game.getPlayersNicknames();
		return playersList.contains(playerController.getNickname());
	}

	public boolean checkCharacterCardCost(String cardName){
		ArrayList<CharacterCard> cards = game.getCharacterCardsList();
		CharacterCard card = null;
		for(CharacterCard c : cards)
			if(c.getName().equals(cardName)) card = c;
		String nickname = playerController.getNickname();
		int coins = game.getPlayerHashMap().get(nickname).getCoins();

		return coins >= card.getCost();
	}

	public boolean checkCurrentPlayer(){
		String currentPlayer = game.getTurn().getCurrentPlayerNickname();
		return playerController.getNickname().equals(currentPlayer);
	}

	public void checkMovableStudent() throws IncorrectOperationException {
		//3 players mode check
		int maxMovableStudents = 3;
		boolean threePlayersMode = game.getNumberOfPlayers() == 3;
		if(threePlayersMode) maxMovableStudents = 4;
		int movedStudentsInTurn = game.getTurnMovedStudents();
		if(movedStudentsInTurn >= maxMovableStudents)
			throw new IncorrectOperationException("Cannot move another student");
	}
}
