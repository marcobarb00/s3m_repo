package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Game {
    private final int numberOfPlayers;
    private MotherNature motherNature;
    private Bag bag;
    private HashMap<String, Player> playerHashMap;
    private ArrayList<Cloud> cloudsList;
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
        this.cloudsList = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            cloudsList.add(new Cloud());
        }
        // Creating islands
        this.islandsList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            islandsList.add(new Island(i+1));
        }
        // Creating the full deck of the character cards
        this.characterCardsList = new ArrayList<>();
        characterCardsList.add(new Centaur());
        characterCardsList.add(new Jester());
        characterCardsList.add(new Knight());
        characterCardsList.add(new MagicPostman());
        characterCardsList.add(new Minstrel());
        characterCardsList.add(new Mushroomer());
        // Creating other elements of the game
        this.professorsList = new ArrayList<>();
        this.motherNature = new MotherNature();
        this.bag = new Bag();
        this.gameInitializer = new GameInitializer(this);
    }

    // Initializing methods

    public void initializeJesterStudents (Jester jester) {
        HashMap<PawnColor, Integer> initialingStudents = new HashMap<>();
        for (PawnColor color : PawnColor.values()) {
            initialingStudents.put(color, 0);
        }
        for (int i = 0; i < 6; i++) {
            try {
                Student student = extractStudent();
                PawnColor color = student.getColor();
                initialingStudents.replace(color, initialingStudents.get(color)+1);
            } catch (EmptyBagException e) {
                e.printStackTrace();
            }
        }
        jester.setStudentsOnCard(initialingStudents);
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

    // CharacterCards deck

    public void drawThreeCharacterCards() {
        while (characterCardsList.size() != 3) {
            int extractedNumber = (int) (Math.random()*(characterCardsList.size()));
            characterCardsList.remove(extractedNumber);
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

    // Mother Nature

    public void updateMotherNaturePosition (int jump) {
        while (jump != 0) {
            if (motherNature.getCurrentPosition() == islandsList.size()-1) {
                motherNature.setCurrentPosition(0);
            } else { motherNature.incrementCurrentPosition(); }
            jump--;
        }
    }

    // Operations

    public void chooseCloud(String playerNickname, int position) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        Cloud chosenCloud = cloudsList.get(position);
        chosenPlayer.getDashboard().addStudentsInHall(chosenCloud.returnThreeStudents());
    }

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
    public HashMap<String, Player> getPlayerHashMap() { return playerHashMap; }
    public ArrayList<Cloud> getCloudsList() { return cloudsList; }
    public ArrayList<Professor> getProfessorsList() { return professorsList; }
    public ArrayList<Island> getIslandsList() { return islandsList; }
    public ArrayList<CharacterCard> getCharacterCardsList() { return characterCardsList; }

    // SETTER
    public void setCharacterCardsList(ArrayList<CharacterCard> characterCardsList) {
        this.characterCardsList = characterCardsList;
    }
}
