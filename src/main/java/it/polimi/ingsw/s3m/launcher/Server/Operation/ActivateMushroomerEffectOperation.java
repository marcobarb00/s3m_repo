package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.CharacterCardAlreadyActivatedException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotEnoughCoinsException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;

public class ActivateMushroomerEffectOperation extends Operation{
	private PawnColor notInfluencingColor;

	public ActivateMushroomerEffectOperation(Game game, PlayerController playerController, PawnColor notInfluencingColor){
		super(game, playerController);
		this.notInfluencingColor = notInfluencingColor;
	}

	@Override
	public void executeOperation() throws PlayerNotInListException, IllegalArgumentException, NotExpertModeException, NotEnoughCoinsException, CharacterCardAlreadyActivatedException{
		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList){
			throw new PlayerNotInListException();
		}

		boolean checkExpertMode = game.isExpertMode();
		if(!checkExpertMode){
			throw new NotExpertModeException();
		}

		//checks if CharacterCard already active
		boolean activatedCharacterCard = game.isCharacterCardActivated();
		if(activatedCharacterCard){
			throw new CharacterCardAlreadyActivatedException();
		}

		//checking if player has enough coins
		boolean checkCost = checkCharacterCardCost("Mushroomer");
		if(!checkCost){
			throw new NotEnoughCoinsException();
		}

		super.game.activateMushroomerEffect(playerController.getNickname(), notInfluencingColor);
	}
}
