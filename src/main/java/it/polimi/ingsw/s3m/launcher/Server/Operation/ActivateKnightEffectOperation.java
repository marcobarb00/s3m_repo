package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

//DONE
public class ActivateKnightEffectOperation extends Operation{

	public ActivateKnightEffectOperation(Game game, PlayerController playerController){
		super(game, playerController);
	}

	/**
	 * checks if the arguments of the operation are valid, if so the game activates the knight card effect
	 */
	@Override
	public void executeOperation() throws PlayerNotInListException, NotExpertModeException, NotEnoughCoinsException, CharacterCardAlreadyActivatedException, IncorrectOperationException{
		//check args
		boolean checkArgs = game != null && playerController != null;
		if(!checkArgs) throw new IncorrectOperationException("Invalid arguments");

		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList) throw new PlayerNotInListException();

		boolean checkExpertMode = game.isExpertMode();
		if(!checkExpertMode) throw new NotExpertModeException();

		//checks if CharacterCard already active
		boolean activatedCharacterCard = game.isCharacterCardActivated();
		if(activatedCharacterCard) throw new CharacterCardAlreadyActivatedException();

		//checking if player has enough coins
		boolean checkCost = checkCharacterCardCost("Knight");
		if(!checkCost) throw new NotEnoughCoinsException();

		super.game.activateKnightEffect(playerController.getNickname());
	}
}
