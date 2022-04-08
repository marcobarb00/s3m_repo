package Controller;

import Model.Game;

public class GameController {
    private int playerNumber;
    private Game game;

    /**
     * GameController constructor: it takes the number of players from
     * client and create a game with that number of players
     *
     */
    public GameController (int playerNumber) {
        this.playerNumber = playerNumber;
        game = new Game(playerNumber);
        game.startGame();
    }

    public int getPlayerNumber () { return playerNumber; }
}
