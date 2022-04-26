package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

public abstract class Operation {
    Game game;
    public abstract void executeOperation();
}
