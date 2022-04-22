package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;

import java.util.ArrayList;

public class Game {
    private final int numberOfPlayers;
    private MotherNature motherNature;
    private Bag bag;
    private CharacterDeck characterDeck;
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
            cloudsList.add(new Cloud(i+1));
        }
        // Creating elements of the game
        this.professorsList = new ArrayList<>();
        this.characterCardsList = new ArrayList<>();
        this.characterDeck = new CharacterDeck();
        this.motherNature = new MotherNature();
        this.bag = new Bag();
        // Creating islands
        this.islandsList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            islandsList.add(new Island(i+1));
        }
        this.gameInitializer = new GameInitializer(this);
    }

    // Bag

    public Student extractStudent() throws EmptyBagException {
        if (bag.getTotalNumberOfStudents() <= 0) {
            throw new EmptyBagException();
        }
        PawnColor extractedColor = extractColor();
        while (bag.getStudents().get(extractedColor) == 0) {
            extractedColor = extractColor();
        }
        Student extractedStudent = new Student(extractedColor);
        bag.decrementStudentsColor(extractedStudent);
        return extractedStudent;
    }

    private PawnColor extractColor () {
        float percent = (float) Math.random();
        if (percent < 0.2) {
            return PawnColor.BLUE;
        } else if (percent >= 0.2 && percent < 0.4) {
            return PawnColor.GREEN;
        } else if (percent >= 0.4 && percent < 0.6) {
            return PawnColor.PINK;
        } else if (percent >= 0.6 && percent < 0.8) {
            return PawnColor.RED;
        } else {
            return PawnColor.YELLOW;
        }
    }

    // Cloud

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
    public int getNumberOfPlayers() { return numberOfPlayers; }
    public MotherNature getMotherNature() { return motherNature; }
    public Bag getBag() { return bag; }
    public CharacterDeck getCharacterDeck() { return characterDeck; }
    public ArrayList<Player> getPlayersList() { return playersList; }
    public ArrayList<Professor> getProfessorsList() { return professorsList; }
    public ArrayList<Cloud> getCloudsList() { return cloudsList; }
    public ArrayList<Island> getIslandsList() { return islandsList; }
    public ArrayList<CharacterCard> getCharacterCardsList() { return characterCardsList; }

    // Setter
    public void setCharacterCardsList(ArrayList<CharacterCard> characterCardsList) {
        this.characterCardsList = characterCardsList;
    }
}
