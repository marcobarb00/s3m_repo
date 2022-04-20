package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class Game {
    private final int numberOfPlayers;
    private Bag bag;
    private ArrayList<Player> playersList;
    private ArrayList<Professor> professorsList;

    public Game (ArrayList<Player> playersList) {
        this.playersList = playersList;
        numberOfPlayers = playersList.size();
        this.bag = new Bag();

        this.professorsList = new ArrayList<>();
        for (PawnColor color : PawnColor.values()) {
            professorsList.add(new Professor(color));
        }
    }

    public void startGame () {
        System.out.println("Game started with " + numberOfPlayers + " players");
    }

    public ArrayList<Professor> getProfessorsList() {
        return professorsList;
    }

    public Bag getBag () { return bag; }
}
