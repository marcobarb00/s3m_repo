package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class Game {
    /**
     * Number of players that are playing the game
     */
    private final int numberOfPlayers;
    /**
     * Bag in which are stored the 40 students at the beginning of the game
     */
    private Bag bag;
    /**
     * List of the players in the game
     */
    private ArrayList<Player> playersLists;
    /**
     * List of the professors in the game
     */
    private ArrayList<Professor> professorsList;

    /**
     * Constructor of the game in which is given the state of the game.
     * The game creates the bag,
     * @param playersList
     * @return
     */
    public Game (ArrayList<Player> playersList) {
        this.playersLists = playersList;
        numberOfPlayers = playersList.size();
        this.bag = new Bag();

        this.professorsList = new ArrayList<>();
        for (PawnColor color : PawnColor.values()) {
            professorsList.add(new Professor(color));
        }
    }

    /**
     * Method that starts the actual game
     */
    public void startGame () {
        System.out.println("Game started with " + numberOfPlayers + " players");
    }

    /**
     * @return professorsList
     */
    public ArrayList<Professor> getProfessorsList() {
        return professorsList;
    }

    /**
     * @return bag
     */
    public Bag getBag () { return bag; }
}
