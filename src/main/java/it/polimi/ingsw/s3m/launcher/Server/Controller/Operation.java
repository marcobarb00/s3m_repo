package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

public abstract class Operation {
    //How to get the game reference in Operation?
    //Solution  - Room class passes it as parameter when instantiating an Operation object
    //             PS. Game is instantiated in room.start() method
    //Should it be final?
    protected Game game;

    public Operation(Game game) {
        this.game = game;
    }

    public abstract void executeOperation() throws PlayerNotInListException,
            CloudNotInListException, IllegalArgumentException;
}
