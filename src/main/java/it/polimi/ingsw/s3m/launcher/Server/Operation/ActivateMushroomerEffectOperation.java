package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotEnoughCoinsException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.PawnColor;

import java.util.ArrayList;

public class ActivateMushroomerEffectOperation extends Operation{
    private PawnColor notInfluencingColor;

    //TODO Needs a PawnColor which computeDominance isn't called upon.
    public ActivateMushroomerEffectOperation(Game game, PlayerController playerController, PawnColor notInfluencingColor) {
        super(game, playerController);
        this.notInfluencingColor = notInfluencingColor;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, IllegalArgumentException, NotExpertModeException, NotEnoughCoinsException {
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        boolean checkExpertMode = game.isExpertMode();
        if(!checkExpertMode){
            throw new NotExpertModeException();
        }

        //checking if player has enough coins
        boolean checkCost = checkCharacterCardCost("Mushroomer");
        if(!checkCost){
            throw new NotEnoughCoinsException();
        }

        super.game.activateMushroomerEffect(playerController.getNickname(), notInfluencingColor);

    }
}
