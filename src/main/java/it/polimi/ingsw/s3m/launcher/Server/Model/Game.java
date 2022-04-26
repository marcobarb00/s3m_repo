package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private final int numberOfPlayers;
    private MotherNature motherNature;
    private Bag bag;
    private CharacterDeck characterDeck;
    private HashMap<String, Player> playerHashMap;
    private HashMap<Integer, Cloud> cloudHashMap;
    private ArrayList<Professor> professorsList;
    private ArrayList<Island> islandsList;
    private ArrayList<CharacterCard> characterCardsList;
    private GameInitializer gameInitializer;

    public Game (ArrayList<String> playersNicknameList) {
        // Setting number of players
        this.numberOfPlayers = playersNicknameList.size();
        // Creating players
        this.playerHashMap = new HashMap<>();
        if (numberOfPlayers == 2) {
            playerHashMap.put(playersNicknameList.get(0),
                    new Player(playersNicknameList.get(0), TowerColor.WHITE));
            playerHashMap.put(playersNicknameList.get(1),
                    new Player(playersNicknameList.get(1), TowerColor.BLACK));
        } else if (numberOfPlayers == 3) {
            playerHashMap.put(playersNicknameList.get(0),
                    new Player(playersNicknameList.get(0), TowerColor.WHITE));
            playerHashMap.put(playersNicknameList.get(1),
                    new Player(playersNicknameList.get(1), TowerColor.BLACK));
            playerHashMap.put(playersNicknameList.get(2),
                    new Player(playersNicknameList.get(2), TowerColor.GREY));
        }
        // Creating clouds
        this.cloudHashMap = new HashMap<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            cloudHashMap.put(i+1, new Cloud(i+1));
        }
        // Creating islands
        this.islandsList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            islandsList.add(new Island(i+1));
        }
        // Creating other elements of the game
        this.professorsList = new ArrayList<>();
        this.characterCardsList = new ArrayList<>();
        this.characterDeck = new CharacterDeck();
        this.motherNature = new MotherNature();
        this.bag = new Bag();
        this.gameInitializer = new GameInitializer(this);
    }

    // Initializing methods

    public void initializeJesterStudents () {
        HashMap<PawnColor, Integer> initialingStudents = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            try {
                Student student = extractStudent();
                PawnColor color = student.getColor();
                initialingStudents.replace(color, initialingStudents.get(color)+1);
            } catch (EmptyBagException e) {
                e.printStackTrace();
            }
        }
        // putStudents
    }

    // Mother Nature

    public void updateMotherNaturePosition (int jump) {
        while (jump != 0) {
            if (motherNature.getCurrentPosition() == islandsList.size()-1) {
                motherNature.setCurrentPosition(0);
            } else { motherNature.incrementCurrentPosition(); }
            jump--;
        }
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

    public void refillCloudStudents(Cloud cloud) {
        ArrayList<Student> refillingStudents = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            try {
                refillingStudents.add(extractStudent());
            } catch (EmptyBagException e) {
                e.printStackTrace();
            }
        }
        cloud.setStudents(refillingStudents);
    }

    // Operations

    public void chooseCloud(String playerNickname, int position) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        Cloud chosenCloud = cloudHashMap.get(position);
        chosenPlayer.getDashboard().addStudentsInHall(chosenCloud.returnThreeStudents());
    }

    // TODO return?
    public void playAssistantCard(String playerNickname, int position) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        chosenPlayer.setLastCardPlayed(chosenPlayer.getHand().get(position));
        chosenPlayer.removeAssistantCardFromHand(position);
    }

    // putStudentsOnTables
    // putStudentsOnIslands
    // moveMotherNature
    // methodsForCharacterCards

    // GETTER
    public int getNumberOfPlayers() { return numberOfPlayers; }
    public MotherNature getMotherNature() { return motherNature; }
    public Bag getBag() { return bag; }
    public CharacterDeck getCharacterDeck() { return characterDeck; }
    public HashMap<String, Player> getPlayerHashMap() { return playerHashMap; }
    public HashMap<Integer, Cloud> getCloudHashMap() { return cloudHashMap; }
    public ArrayList<Professor> getProfessorsList() { return professorsList; }
    public ArrayList<Island> getIslandsList() { return islandsList; }
    public ArrayList<CharacterCard> getCharacterCardsList() { return characterCardsList; }

    // SETTER
    public void setCharacterCardsList(ArrayList<CharacterCard> characterCardsList) {
        this.characterCardsList = characterCardsList;
    }
}
