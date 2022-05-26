package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

public class MoveMotherNatureOperation extends Operation{
	private final int movements;

	/**
	 * @param game             the game state in which the player is in
	 * @param playerController the player who's executing the operation
	 * @param movements        movements of mother nature selected by the player
	 */
	public MoveMotherNatureOperation(Game game, PlayerController playerController, int movements){
		super(game, playerController);
		this.movements = movements;
	}

	/**
	 * checks if the arguments of the operation are valid, if so the game moves mother nature
	 */
	@Override
	public void executeOperation() throws PlayerNotInListException,
			NotPlayerTurnException, ZeroTowersRemainedException,
			NotEnoughIslandsException, IncorrectOperationException{

		//check args
		boolean checkArgs = game != null && playerController != null;
		if(!checkArgs) throw new IncorrectOperationException("Invalid arguments");

		//check nickname
		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList) throw new PlayerNotInListException();

		//check if movements are legal given currentPlayer's assistantCard
		int maxMoves = game.getTurn().getMotherNatureMaxAllowedMovements();
		boolean checkMoves = 0 < movements && movements <= maxMoves;
		if(!checkMoves) throw new IncorrectOperationException("Incorrect mother nature movement value");

		//these exceptions are handled in Room
		game.moveMotherNature(movements);
	}
}
