package it.polimi.ingsw.s3m.launcher.Server.Controller;

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
    public void executeOperation() throws PlayerNotInListException, NotExpertModeException {
        ArrayList<String> playersList = super.game.getPlayersNicknames();

        boolean checkExpertMode = game.isExpertMode();
        if(!checkExpertMode){
            throw new NotExpertModeException();
        }

        boolean playerControllerInList = playersList.contains(playerController.getNickname());
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }else{
            super.game.activateMagicPostmanEffect(playerController.getNickname());
        }
    }
}