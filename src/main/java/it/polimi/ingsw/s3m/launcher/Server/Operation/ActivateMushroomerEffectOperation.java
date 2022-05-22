package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;

public class ActivateMushroomerEffectOperation extends Operation{
	private final PawnColor notInfluencingColor;

	/**
	 * @param game                the game state in which the player is in
	 * @param playerController    the player who's executing the operation
	 * @param notInfluencingColor color that should not be considered during the calculation of the influence
	 */
	public ActivateMushroomerEffectOperation(Game game, PlayerController playerController, PawnColor notInfluencingColor){
		super(game, playerController);
		this.notInfluencingColor = notInfluencingColor;
	}

	/**
	 * checks if the arguments of the operation are valid, if so the game activates the mushroomer card effect
	 */
	@Override
	public void executeOperation() throws PlayerNotInListException, NotExpertModeException, NotEnoughCoinsException, CharacterCardAlreadyActivatedException, IncorrectOperationException{
		//check args
		boolean checkArgs = game != null && playerController != null && notInfluencingColor != null;
		if(!checkArgs) throw new IncorrectOperationException("Invalid arguments");

		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList) throw new PlayerNotInListException();

		boolean checkExpertMode = game.isExpertMode();
		if(!checkExpertMode) throw new NotExpertModeException();

		//checks if CharacterCard already active
		boolean activatedCharacterCard = game.isCharacterCardActivated();
		if(activatedCharacterCard) throw new CharacterCardAlreadyActivatedException();

		//checking if player has enough coins
		boolean checkCost = checkCharacterCardCost("Mushroomer");
		if(!checkCost) throw new NotEnoughCoinsException();

		super.game.activateMushroomerEffect(playerController.getNickname(), notInfluencingColor);
	}
}
