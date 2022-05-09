package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotEnoughAssistantCardsException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotEnoughIslandsException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.ZeroTowersRemainedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Game implements Cloneable{
    private final int numberOfPlayers;
    private final boolean expertMode;
    private final MotherNature motherNature = new MotherNature();
    private final Bag bag = new Bag();
    private final HashMap<String, Player> playerHashMap = new HashMap<>();
    private final HashMap<PawnColor, Player> professorsHashMap = new HashMap<>();
    private final ArrayList<Cloud> cloudsList = new ArrayList<>();
    private final ArrayList<Island> islandsList = new ArrayList<>();
    private final ArrayList<CharacterCard> characterCardsList = new ArrayList<>();
    private ComputeDominanceStrategy computeDominanceStrategy = new StandardComputeDominance();
    private GameInitializer gameInitializer;
    private ExpertModeInitializer expertModeInitializer;
    private final Turn turn;

    public Game (ArrayList<String> playersNicknameList, boolean expertMode) {
        this.numberOfPlayers = playersNicknameList.size();
        this.expertMode = expertMode;
        // Professors
        for (PawnColor color : PawnColor.values()) professorsHashMap.put(color, null);
        // Clouds
        for (int i = 0; i < numberOfPlayers; i++) cloudsList.add(new Cloud());
        // Islands
        for (int i = 0; i < 12; i++) islandsList.add(new Island());

        if (numberOfPlayers == 2)
            gameInitializer = new TwoPlayersGameInitializer(this, playersNicknameList);
        else if (numberOfPlayers == 3)
            gameInitializer = new ThreePlayersGameInitializer(this, playersNicknameList);
        if (expertMode) expertModeInitializer = new ExpertModeInitializer(this);

        // Turn
        turn = new Turn(playersNicknameList.get(ThreadLocalRandom.current().nextInt(0, numberOfPlayers-1)));
    }

    // BAG

    public Student extractStudent() throws EmptyBagException {
        if (bag.getTotalNumberOfStudents() <= 0) throw new EmptyBagException();

        PawnColor extractedColor = extractColor();
        while (bag.getStudents().get(extractedColor) == 0)
            extractedColor = extractColor();
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

    // CHARACTER CARDS

    public void drawThreeCharacterCards() {
        while (characterCardsList.size() != 3) {
            int extractedNumber = ThreadLocalRandom.current().nextInt(0, characterCardsList.size()-1);
            characterCardsList.remove(extractedNumber);
        }
    }

    // CLOUD

    public void refillClouds() throws EmptyBagException {
        int numberOfStudents;
        if (expertMode) numberOfStudents = 4;
        else numberOfStudents = 3;
        for (int i = 0; i < numberOfPlayers; i++) {
            refillCloudStudents(cloudsList.get(i), numberOfStudents);
        }
    }

    public void refillCloudStudents(Cloud cloud, int numberOfStudents) throws EmptyBagException {
        ArrayList<Student> refillingStudents = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) refillingStudents.add(extractStudent());
        cloud.setStudents(refillingStudents);
    }

    // ISLAND

    public void samePlayerCheckInNextIsland (Island currentIsland) {
        Player currentIslandDominator = currentIsland.getDominator();
        int islandIndex = islandsList.indexOf(currentIsland);

        Island nextIsland;
        if (islandIndex == islandsList.size()-1)
            nextIsland = islandsList.get(0);
        else
            nextIsland = islandsList.get(islandIndex+1);
        Player nextIslandDominator = nextIsland.getDominator();

        if (currentIslandDominator.equals(nextIslandDominator))
            mergeIsland(currentIsland, nextIsland);
    }

    public void samePlayerCheckInPreviousIsland (Island currentIsland) {
        Player currentIslandDominator = currentIsland.getDominator();
        int islandIndex = islandsList.indexOf(currentIsland);

        Island previousIsland;
        if (islandIndex == 0)
            previousIsland = islandsList.get(islandsList.size()-1);
        else
            previousIsland = islandsList.get(islandIndex-1);
        Player previousIslandDominator = previousIsland.getDominator();

        if (currentIslandDominator.equals(previousIslandDominator))
            mergeIsland(currentIsland, previousIsland);
    }

    public void mergeIsland(Island mergingInIsland, Island mergingOutIsland) {
        for (PawnColor color : PawnColor.values()) {
            int studentsPerColor = mergingInIsland.getStudentsPerColor(color);
            mergingInIsland.getStudents().replace(color, studentsPerColor + mergingOutIsland.getStudentsPerColor(color));
        }
        mergingInIsland.sumTower(mergingOutIsland.getNumberOfTowers());

        islandsList.remove(mergingOutIsland);
    }

    // JESTER

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

    // MOTHER NATURE

    public void updateMotherNaturePosition (int jump) {
        while (jump != 0) {
            if (motherNature.getCurrentPosition() == islandsList.size()-1)
                motherNature.setCurrentPosition(0);
            else motherNature.incrementCurrentPosition();
            jump--;
        }
    }

    // PROFESSORS

    private void computeProfessorsDominance() {
        for (PawnColor color : PawnColor.values()) {
            int maxStudents = 0;
            Player controllingPlayer = professorsHashMap.get(color);
            if (controllingPlayer != null) maxStudents = controllingPlayer.getDashboard().getTables().get(color);
            for (Player player : playerHashMap.values())
                if (player.getDashboard().getTables().get(color) > maxStudents) professorsHashMap.replace(color, player);
        }
    }

    private int playerInfluenceOnProfessors(Player player) {
        int influenceCounter = 0;
        for (Player dominator : professorsHashMap.values())
            if (player.getNickname().equals(dominator.getNickname())) influenceCounter++;
        return influenceCounter;
    }

    // TURN

    public void resetTurn() {
        turn.setCurrentPlayerNickname(turn.getFirstPlayerNickname());
        turn.setPhaseName("PlanningPhase");
        turn.resetMovedStudents();
        turn.setPlayedCards(new HashMap<>());
        turn.setActivatedCharacterCard(false);
    }

    public void setTurnFirstPlayer() {
        int minValue = 11;
        for (String nickname : turn.getPlayedCards().keySet()) {
            int cardValue = turn.getPlayedCards().get(nickname).getValue();
            if (cardValue < minValue) {
                minValue = cardValue;
                turn.setFirstPlayerNickname(nickname);
            }
        }
    }

    // WINNING CONDITIONS

    public String checkWinCondition() {
        Player winner = null;
        int maxTowers = 10;
        for (Player player : playerHashMap.values()) {
            if (player.getDashboard().getNumberOfTowers() < maxTowers)
                winner = player;
            else if (player.getDashboard().getNumberOfTowers() == maxTowers)
                if (playerInfluenceOnProfessors(player) > playerInfluenceOnProfessors(winner))
                    winner = player;
        }
        assert winner != null;
        return winner.getNickname();
    }

    public String zeroTowersLeftWinCondition() {
        Player winner = null;
        for (Player player : playerHashMap.values())
            if (player.getDashboard().getNumberOfTowers() == 0) winner = player;
        assert winner != null;
        return winner.getNickname();
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
        turn.setActivatedCharacterCard(true);
    }

    public void activateJesterEffect (String playerNickname, ArrayList<Student> requiredStudents, ArrayList<Student> givenStudents) {
        CharacterCard jester = new Jester();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof Jester) jester = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        chosenPlayer.getDashboard().deleteStudentsFromEntrance(givenStudents);
        ArrayList<Student> exchangingStudents = ((Jester) jester).exchangeStudents(requiredStudents, givenStudents);
        chosenPlayer.getDashboard().addStudentsInEntrance(exchangingStudents);
        chosenPlayer.removeCoins(jester.getCost());
        jester.incrementCost();
        turn.setActivatedCharacterCard(true);
    }

    public void activateKnightEffect (String playerNickname) {
        CharacterCard knight = new Knight();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof Knight) knight = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        computeDominanceStrategy = new KnightComputeDominance();
        ((KnightComputeDominance) computeDominanceStrategy).setActingPlayer(chosenPlayer);
        chosenPlayer.removeCoins(knight.getCost());
        knight.incrementCost();
        turn.setActivatedCharacterCard(true);
    }

    public void activateMagicPostmanEffect (String playerNickname) {
        CharacterCard magicPostman = new MagicPostman();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof MagicPostman) magicPostman = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        chosenPlayer.getLastPlayedCard().incrementMovementsByTwo();
        chosenPlayer.removeCoins(magicPostman.getCost());
        magicPostman.incrementCost();
        turn.setActivatedCharacterCard(true);
    }

    public void activateMinstrelEffect (String playerNickname, ArrayList<Student> enteringStudents, ArrayList<Student> enteringTablesStudents) {
        int additionalCoins;
        CharacterCard minstrel = new Minstrel();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof Minstrel) minstrel = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        chosenPlayer.getDashboard().addStudentsInEntrance(enteringStudents);
        chosenPlayer.getDashboard().deleteStudentsFromTables(enteringStudents);
        additionalCoins = chosenPlayer.getDashboard().moveStudentsFromEntranceToTables(enteringTablesStudents);
        chosenPlayer.addCoins(additionalCoins);
        chosenPlayer.removeCoins(minstrel.getCost());
        minstrel.incrementCost();
        turn.setActivatedCharacterCard(true);
        computeProfessorsDominance();
    }

    public void activateMushroomerEffect (String playerNickname, PawnColor chosenColor) {
        CharacterCard mushroomer = new Mushroomer();
        for (CharacterCard characterCard : characterCardsList) {
            if (characterCard instanceof Mushroomer) mushroomer = characterCard;
        }
        Player chosenPlayer = playerHashMap.get(playerNickname);
        computeDominanceStrategy = new MushroomerComputeDominance();
        ((MushroomerComputeDominance) computeDominanceStrategy).setChosenColor(chosenColor);
        chosenPlayer.removeCoins(mushroomer.getCost());
        mushroomer.incrementCost();
        turn.setActivatedCharacterCard(true);
    }

    public void chooseCloud(String playerNickname, int position) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        Cloud chosenCloud = cloudsList.get(position);
        chosenPlayer.getDashboard().addStudentsInEntrance(chosenCloud.returnStudents());
    }

    public void moveMotherNature(int movement) throws NotEnoughIslandsException, ZeroTowersRemainedException {
        updateMotherNaturePosition(movement);

        Island currentIsland = islandsList.get(motherNature.getCurrentPosition());
        Player currentPlayer = currentIsland.getDominator();

        Player newDominatingPlayer = computeDominanceStrategy.computeDominance(currentIsland, professorsHashMap);

        if (newDominatingPlayer != null) {
            if (currentPlayer == null) {
                currentIsland.setDominator(newDominatingPlayer);
                currentIsland.addTower();
                newDominatingPlayer.getDashboard().decrementTowers();
                if (newDominatingPlayer.getDashboard().getNumberOfTowers() == 0)
                    throw new ZeroTowersRemainedException();
            } else if (!newDominatingPlayer.getNickname().equals(currentPlayer.getNickname())) {
                int islandTowers = currentIsland.getNumberOfTowers();
                for (int i = 0; i < islandTowers; i++) {
                    currentPlayer.getDashboard().incrementTowers();
                    newDominatingPlayer.getDashboard().decrementTowers();
                    if (newDominatingPlayer.getDashboard().getNumberOfTowers() == 0)
                        throw new ZeroTowersRemainedException();
                }
                currentIsland.setDominator(newDominatingPlayer);

                samePlayerCheckInNextIsland(currentIsland);
                samePlayerCheckInPreviousIsland(currentIsland);
            }
        }

        if (islandsList.size() <= 3) throw new NotEnoughIslandsException();
    }

    public void playAssistantCard(String playerNickname, int position) throws NotEnoughAssistantCardsException {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        chosenPlayer.setLastPlayedCard(chosenPlayer.getHand().get(position));
        chosenPlayer.removeAssistantCardFromHand(position);
        turn.addPlayedCard(chosenPlayer.getNickname(), chosenPlayer.getLastPlayedCard());
        turn.incrementMovedStudents();
        if (chosenPlayer.getHand().size() == 0) throw new NotEnoughAssistantCardsException();
    }

    public void putStudentOnTables(String playerNickname, Student selectedStudent) {
        int additionalCoins;
        Player chosenPlayer = playerHashMap.get(playerNickname);
        additionalCoins = chosenPlayer.getDashboard().moveSingleStudentFromEntranceToTables(selectedStudent);
        chosenPlayer.addCoins(additionalCoins);
        computeProfessorsDominance();
        turn.incrementMovedStudents();
    }

    public void putStudentOnIslands(String playerNickname, int position, Student selectedStudent) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        Island chosenIsland = islandsList.get(position);
        chosenPlayer.getDashboard().deleteSingleStudentFromEntrance(selectedStudent);
        chosenIsland.addStudent(selectedStudent);
    }


    // GETTER - Player
    public int getNumberOfPlayers() { return numberOfPlayers; }
    public HashMap<String, Player> getPlayerHashMap() { return playerHashMap; }
    public ArrayList<String> getPlayersNicknames() {
        ArrayList<String> listOfNicknames = new ArrayList<>();
        for (Player player : playerHashMap.values()) listOfNicknames.add(player.getNickname());
        return listOfNicknames;
    }
    public Player getCurrentPlayer() {
        Player currentPlayer = null;
        for (Player player : playerHashMap.values())
            if (player.getNickname().equals(turn.getCurrentPlayerNickname())) currentPlayer = player;
        return currentPlayer;
    }
    public ArrayList<AssistantCard> getPlayerHand(String playerNickname) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        return chosenPlayer.getHand();
    }
    public AssistantCard getPlayerLastPlayedAssistantCard(String playerNickname) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        return chosenPlayer.getLastPlayedCard();
    }
    public int getPlayerCoins(String playerNickname) {
        Player chosenPlayer = playerHashMap.get(playerNickname);
        return chosenPlayer.getCoins();
    }

    // GETTER - Character Cards
    public HashMap<PawnColor, Integer> getJesterStudentsOnCard() {
        CharacterCard jester = new Jester();
        for (CharacterCard characterCard : characterCardsList)
            if (characterCard instanceof Jester) jester = characterCard;
        return ((Jester) jester).getStudentsOnCard();
    }

    // GETTER - Turn
    public Turn getTurn() { return turn; }
    public String getFirstPlayerNickname() { return turn.getFirstPlayerNickname(); }
    public String getCurrentPlayerNickname() { return turn.getCurrentPlayerNickname(); }
    public String getCurrentPhase() { return turn.getPhaseName(); }
    public int getTurnMovedStudents() { return turn.getMovedStudents(); }
    public boolean isCharacterCardActivated() { return turn.isActivatedCharacterCard(); }
    public ArrayList<AssistantCard> getTurnPlayedCards() { return new ArrayList<>(turn.getPlayedCards().values()); }

    // SETTER - Turn
    public void setCurrentPlayerNickname(String nickname) {
        turn.setCurrentPlayerNickname(nickname);
    }
    public void setCurrentPhase(String phaseName) {
        turn.setPhaseName(phaseName);
    }

    // GETTER
    public boolean isExpertMode() { return expertMode; }
    public MotherNature getMotherNature() { return motherNature; }
    public Bag getBag() { return bag; }
    public HashMap<PawnColor, Player> getProfessorsHashMap() { return professorsHashMap; }
    public ArrayList<Cloud> getCloudsList() { return cloudsList; }
    public ArrayList<Island> getIslandsList() { return islandsList; }
    public ArrayList<CharacterCard> getCharacterCardsList() { return characterCardsList; }
}
