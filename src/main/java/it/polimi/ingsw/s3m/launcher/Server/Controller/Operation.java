package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

public abstract class Operation {
    //How to get the game reference in Operation?
    //Solution  - Room class passes it as parameter when instantiating an Operation object
    //             PS. Game is instantiated in room.start() method
    protected Game game;
    protected PlayerController playerController;

    public Operation(Game game, PlayerController playerController) {
        this.playerController = playerController;
        this.game = game;
    }

    public abstract void executeOperation() throws PlayerNotInListException,
            CloudNotInListException, IllegalArgumentException, NotExpertModeException;

    public boolean checkNickname(){
        ArrayList<String> playersList = game.getPlayersNicknames();
        boolean playerControllerInList = playersList.contains(playerController.getNickname());
        return playerControllerInList;
    }

}
