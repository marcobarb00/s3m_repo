package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

//DONE
public class ActivateKnightEffectOperation extends Operation{

    public ActivateKnightEffectOperation(Game game, PlayerController playerController) {
        super(game, playerController);
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, NotExpertModeException {

        boolean playerControllerInList = checkNickname();
        boolean checkExpertMode = game.isExpertMode();

        if(!checkExpertMode){
            throw new NotExpertModeException();
        }
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }else{
            super.game.activateKnightEffect(playerController.getNickname());
        }
    }
}
