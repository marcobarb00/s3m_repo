package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import java.util.ArrayList;

//DONE
public class ActivateCentaurEffectOperation extends Operation{

    public ActivateCentaurEffectOperation(Game game, PlayerController playerController) {
        super(game, playerController);
    }

    @Override
    public void executeOperation() throws PlayerNotInListException {
        ArrayList<String> playersList = super.game.getPlayersNicknames();

        boolean playerControllerInList = playersList.contains(playerController.getNickname());
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }else{
            super.game.activateCentaurEffect(playerController.getNickname());
        }

    }
}
