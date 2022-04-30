package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private final int numberOfPlayers;
    private final boolean expertMode;
    private MotherNature motherNature;
    private Bag bag;
    private HashMap<String, Player> playerHashMap;
    private ArrayList<Cloud> cloudsList;
    private ArrayList<Professor> professorsList;
    private ArrayList<Island> islandsList;
    private ArrayList<CharacterCard> characterCardsList;
    private ComputeDominanceStrategy computeDominanceStrategy;
    private GameInitializer gameInitializer;
    private ExpertModeInitializer expertModeInitializer;

    public Game (ArrayList<String> playersNicknameList, boolean expertMode) {
        this.numberOfPlayers = playersNicknameList.size();
        this.expertMode = expertMode;
        // MotherNature
        this.motherNature = new MotherNature();
        // Bag
        this.bag = new Bag();
        // Players
        this.playerHashMap = new HashMap<>();
        // Clouds
        this.cloudsList = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            cloudsList.add(new Cloud());
        }
        // Professors
        this.professorsList = new ArrayList<>();
        // Islands
        this.islandsList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            islandsList.add(new Island());
        }
        // Character cards
        this.characterCardsList = new ArrayList<>();
        // Strategy: computeDominance
        this.computeDominanceStrategy = new StandardComputeDominance();

        if (numberOfPlayers == 2) {
            gameInitializer = new TwoPlayersGameInitializer(this, playersNicknameList);
        } else if (numberOfPlayers == 3) {
            gameInitializer = new ThreePlayersGameInitializer(this, playersNicknameList);
        }
        if (expertMode) expertModeInitializer = new ExpertModeInitializer(this);
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

    public void refillCloudStudents(Cloud cloud, int numberOfStudents) {
        ArrayList<Student> refillingStudents = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            try {
                refillingStudents.add(extractStudent());
            } catch (EmptyBagException e) {
                e.printStackTrace();
            }
        }
        cloud.setStudents(refillingStudents);
    }

    // Jester

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

    public void activateCentaurEffect (String playerNickname) {
        CharacterCard centaur = new Centaur();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof Centaur) centaur = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        computeDominanceStrategy = new CentaurComputeDominance();
        chosenPlayer.removeCoins(centaur.getCost());
        centaur.incrementCost();
    }

    public void activateJesterEffect (String playerNickname, ArrayList<Student> requiredStudents, ArrayList<Student> givenStudents) {
        CharacterCard jester = new Jester();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof Jester) jester = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        chosenPlayer.getDashboard().deleteStudentsFromHall(givenStudents);
        ArrayList<Student> exchangingStudents = ((Jester) jester).exchangeStudents(requiredStudents, givenStudents);
        chosenPlayer.getDashboard().addStudentsInHall(exchangingStudents);
        chosenPlayer.removeCoins(jester.getCost());
        jester.incrementCost();
    }

    public void activateKnightEffect (String playerNickname) {
        CharacterCard knight = new Knight();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof Knight) knight = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        computeDominanceStrategy = new KnightComputeDominance();
        chosenPlayer.removeCoins(knight.getCost());
        knight.incrementCost();
    }

    public void activateMagicPostmanEffect (String playerNickname) {
        CharacterCard magicPostman = new MagicPostman();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof MagicPostman) magicPostman = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        chosenPlayer.getLastCardPlayed().incrementMovementsByTwo();
        chosenPlayer.removeCoins(magicPostman.getCost());
        magicPostman.incrementCost();
    }

    public void activateMinstrelEffect (String playerNickname, ArrayList<Student> enteringHallStudents, ArrayList<Student> enteringTablesStudents) {
        int additionalCoins;
        CharacterCard minstrel = new Minstrel();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof Minstrel) minstrel = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        chosenPlayer.getDashboard().addStudentsInHall(enteringHallStudents);
        chosenPlayer.getDashboard().deleteStudentsFromTables(enteringHallStudents);
        additionalCoins = chosenPlayer.getDashboard().moveStudentsFromHallToTables(enteringTablesStudents);
        chosenPlayer.addCoins(additionalCoins);
        chosenPlayer.removeCoins(minstrel.getCost());
        minstrel.incrementCost();
    }

    public void activateMushroomerEffect (String playerNickname) {
        CharacterCard mushroomer = new Mushroomer();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof Mushroomer) mushroomer = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        computeDominanceStrategy = new MushroomerComputeDominance();
        chosenPlayer.removeCoins(mushroomer.getCost());
        mushroomer.incrementCost();
    }

    public void chooseCloud(String playerNickname, int position) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        Cloud chosenCloud = cloudsList.get(position);
        chosenPlayer.getDashboard().addStudentsInHall(chosenCloud.returnStudents());
    }

    //TODO this method
    public void moveMotherNature(String playerNickname, int movement) {
        updateMotherNaturePosition(movement);
        computeDominanceStrategy.executeStrategy();
    }

    public void playAssistantCard(String playerNickname, int position) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        chosenPlayer.setLastCardPlayed(chosenPlayer.getHand().get(position));
        chosenPlayer.removeAssistantCardFromHand(position);
    }

    public void putStudentsOnTables(String playerNickname, ArrayList<Student> selectedStudents) {
        int additionalCoins;
        Player chosenPlayer = playerHashMap.get(playerNickname);
        additionalCoins = chosenPlayer.getDashboard().moveStudentsFromHallToTables(selectedStudents);
        chosenPlayer.addCoins(additionalCoins);
    }

    public void putStudentsOnIslands(String playerNickname, int position, ArrayList<Student> selectedStudents) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        Island chosenIsland = islandsList.get(position);
        chosenPlayer.getDashboard().deleteStudentsFromHall(selectedStudents);
        chosenIsland.addStudentsOnIsland(selectedStudents);
    }

    // GETTER - Player
    public int getNumberOfPlayers() { return numberOfPlayers; }
    public HashMap<String, Player> getPlayerHashMap() { return playerHashMap; }
    public ArrayList<String> getPlayersNicknames() {
        ArrayList<String> listOfNicknames = new ArrayList<>();
        for (Player player : playerHashMap.values()) {
            listOfNicknames.add(player.getNickname());
        }
        return listOfNicknames;
    }
    public ArrayList<AssistantCard> getPlayerHand(String playerNickname) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        return chosenPlayer.getHand();
    }
    public AssistantCard getPlayerLastPlayedAssistantCard(String playerNickname) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        return chosenPlayer.getLastCardPlayed();
    }
    public int getPlayerCoins(String playerNickname) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        return chosenPlayer.getCoins();
    }

    // GETTER - Character Cards
    public HashMap<PawnColor, Integer> getJesterStudentsOnCard() {
        CharacterCard jester = new Jester();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof Jester) jester = characterCard;
        }
        return ((Jester) jester).getStudentsOnCard();
    }

    // GETTER
    public boolean isExpertMode() { return expertMode; }
    public MotherNature getMotherNature() { return motherNature; }
    public Bag getBag() { return bag; }
    public ArrayList<Cloud> getCloudsList() { return cloudsList; }
    public ArrayList<Professor> getProfessorsList() { return professorsList; }
    public ArrayList<Island> getIslandsList() { return islandsList; }
    public ArrayList<CharacterCard> getCharacterCardsList() { return characterCardsList; }
}
