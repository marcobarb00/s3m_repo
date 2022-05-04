package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotEnoughCoinsException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

//Done
public class ActivateMagicPostmanEffectOperation extends Operation{

    public ActivateMagicPostmanEffectOperation(Game game, PlayerController playerController) {
        super(game, playerController);
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, NotExpertModeException, NotEnoughCoinsException {
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        boolean checkExpertMode = game.isExpertMode();
        if(!checkExpertMode){
            throw new NotExpertModeException();
        }

        //checking if player has enough coins
        boolean checkCost = checkCharacterCardCost("MagicPostman");
        if(!checkCost){
            throw new NotEnoughCoinsException();
        }

        super.game.activateMagicPostmanEffect(playerController.getNickname());
    }
}