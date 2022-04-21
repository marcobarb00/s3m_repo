package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class Game {
    private final int numberOfPlayers;
    private MotherNature motherNature;
    private Bag bag;
    private ArrayList<Player> playersList;
    private ArrayList<Professor> professorsList;
    private ArrayList<Cloud> cloudsList;
    private ArrayList<Island> islandsList;
    private ArrayList<CharacterCard> characterCardsList;
    private GameInitializer gameInitializer;

    /**
     * Constructor that creates all the necessaries elements for the game
     * @param playersNicknameList list of the nicknames of the players
     */
    public Game (ArrayList<String> playersNicknameList) {
        // Setting players and clouds
        this.numberOfPlayers = playersNicknameList.size();
        this.playersList = new ArrayList<>();
        this.cloudsList = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            playersList.add(new Player(playersNicknameList.get(i)));
            cloudsList.add(new Cloud(this,i+1));
        }
        // Setting professors and character cards
        this.professorsList = new ArrayList<>();
        this.characterCardsList = new ArrayList<>();
        // Creating instruments
        this.motherNature = new MotherNature();
        this.bag = new Bag();
        // Creating islands
        this.islandsList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            islandsList.add(new Island(this, i+1));
        }
        this.gameInitializer = new GameInitializer(this);
        gameInitializer.setup();
    }

    // Operation
    /* public void moveMotherNature (int jump) {
        MotherNature.setCurrentPosition(jump, size.); // metodo
        int numberOfComputeDominance = IslandsList.get(MotherNature.getPosition).computeDominance();
        if (numberOfComputeDominance == 1) {
            IslandsList.get(MotherNature.getPosition-1).remove();
        } else if (numberOfComputeDominance == 2) {
            IslandsList.get(MotherNature.getPosition+1).remove();
        } else if () {
            IslandsList.get(MotherNature.getPosition+1).remove();
            IslandsList.get(MotherNature.getPosition-1).remove();
        } else {
            //errore
        }

    } */

    // Getter
    public int getNumberOfPlayers () { return numberOfPlayers; }
    public MotherNature getMotherNature() { return motherNature; }
    public Bag getBag () { return bag; }
    public ArrayList<Professor> getProfessorsList() { return professorsList; }
    public ArrayList<Player> getPlayersList() { return playersList; }
    public ArrayList<Cloud> getCloudsList() { return cloudsList; }
    public ArrayList<CharacterCard> getCharacterCardsList () { return characterCardsList; }
}
