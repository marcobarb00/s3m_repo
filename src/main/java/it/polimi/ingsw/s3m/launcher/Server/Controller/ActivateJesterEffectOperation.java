package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

public class ActivateJesterEffectOperation extends Operation{
    public ActivateJesterEffectOperation(Game game) {
        super(game);
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, CloudNotInListException {

    }
}
