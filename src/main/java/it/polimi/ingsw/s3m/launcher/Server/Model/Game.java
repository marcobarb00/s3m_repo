package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Initializers.ExpertModeInitializer;
import it.polimi.ingsw.s3m.launcher.Server.Model.Initializers.GameInitializer;
import it.polimi.ingsw.s3m.launcher.Server.Model.Initializers.ThreePlayersGameInitializer;
import it.polimi.ingsw.s3m.launcher.Server.Model.Initializers.TwoPlayersGameInitializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Game{
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

	/**
	 * Constructor used to initialize the game attributes
	 * @param playersNicknameList list of players' nicknames
	 * @param expertMode boolean for the expert mode
	 */
	public Game(ArrayList<String> playersNicknameList, boolean expertMode) throws EmptyBagException {
		this.numberOfPlayers = playersNicknameList.size();
		this.expertMode = expertMode;
		// Professors
		for(PawnColor color : PawnColor.values()) professorsHashMap.put(color, null);
		// Clouds
		for(int i = 0; i < numberOfPlayers; i++) cloudsList.add(new Cloud());
		// Islands
		for(int i = 0; i < 12; i++) islandsList.add(new Island());

		if(numberOfPlayers == 2)
			gameInitializer = new TwoPlayersGameInitializer(this, playersNicknameList);
		else if(numberOfPlayers == 3)
			gameInitializer = new ThreePlayersGameInitializer(this, playersNicknameList);
		if(expertMode) expertModeInitializer = new ExpertModeInitializer(this);

		// Turn
		turn = new Turn(playersNicknameList.get(ThreadLocalRandom.current().nextInt(0, numberOfPlayers - 1)));
	}

	// BAG

	/**
	 * Method used to extract a random color student from the bag
	 * @return the extracted student
	 * @throws EmptyBagException exception if the bag is empty
	 */
	public Student extractStudent() throws EmptyBagException{
		if(bag.getTotalNumberOfStudents() <= 0) throw new EmptyBagException();

		PawnColor extractedColor = extractColor();
		while(bag.getStudents().get(extractedColor) == 0)
			extractedColor = extractColor();
		Student extractedStudent = new Student(extractedColor);
		bag.decrementStudentsColor(extractedStudent);
		return extractedStudent;
	}

	/**
	 * Method used to extract a random color
	 * @return a random extracted color
	 */
	private PawnColor extractColor(){
		float percent = (float) Math.random();
		if(percent < 0.2)
			return PawnColor.BLUE;
		else if(percent >= 0.2 && percent < 0.4)
			return PawnColor.GREEN;
		else if(percent >= 0.4 && percent < 0.6)
			return PawnColor.PINK;
		else if(percent >= 0.6 && percent < 0.8)
			return PawnColor.RED;
		else
			return PawnColor.YELLOW;
	}

	// CHARACTER CARDS

	/**
	 * Method used to draw the three character cards to play with
	 */
	public void drawThreeCharacterCards(){
		while(characterCardsList.size() > 3){
			int extractedNumber = ThreadLocalRandom.current().nextInt(0, characterCardsList.size() - 1);
			characterCardsList.remove(extractedNumber);
		}
	}

	// CLOUD

	/**
	 * Method used to refill all the clouds with a number of
	 * students based on the number of players of the game
	 * @throws EmptyBagException exception if the bag is empty
	 */
	public void refillClouds() throws EmptyBagException {
		int numberOfStudents;
		numberOfStudents = 3;
		if(numberOfPlayers == 3) numberOfStudents = 4;
		for(int i = 0; i < numberOfPlayers; i++)
			refillCloudStudents(cloudsList.get(i), numberOfStudents);
	}

	/**
	 * Method used to refill a single cloud
	 * @param cloud cloud to be refilled
	 * @param numberOfStudents number of students to refill the cloud with
	 * @throws EmptyBagException exception if the bag is empty
	 */
	public void refillCloudStudents(Cloud cloud, int numberOfStudents) throws EmptyBagException{
		ArrayList<Student> refillingStudents = new ArrayList<>();
		for(int i = 0; i < numberOfStudents; i++) refillingStudents.add(extractStudent());
		cloud.setStudents(refillingStudents);
	}

	// ISLAND

	/**
	 * Method used to check if the current island's dominating player is
	 * the same as the next island's
	 * @param currentIsland island to check
	 */
	public void samePlayerCheckInNextIsland(Island currentIsland){
		Player currentIslandDominator = currentIsland.getDominator();
		int islandIndex = islandsList.indexOf(currentIsland);

		Island nextIsland;
		if(islandIndex == islandsList.size() - 1)
			nextIsland = islandsList.get(0);
		else
			nextIsland = islandsList.get(islandIndex + 1);
		Player nextIslandDominator = nextIsland.getDominator();

		if(currentIslandDominator.equals(nextIslandDominator))
			mergeIsland(currentIsland, nextIsland);
	}

	/**
	 * Method used to check if the current island's dominating player is
	 * the same as the previous island's
	 * @param currentIsland island to check
	 */
	public void samePlayerCheckInPreviousIsland(Island currentIsland){
		Player currentIslandDominator = currentIsland.getDominator();
		int islandIndex = islandsList.indexOf(currentIsland);

		Island previousIsland;
		if(islandIndex == 0)
			previousIsland = islandsList.get(islandsList.size() - 1);
		else
			previousIsland = islandsList.get(islandIndex - 1);
		Player previousIslandDominator = previousIsland.getDominator();

		if(currentIslandDominator.equals(previousIslandDominator))
			mergeIsland(currentIsland, previousIsland);
	}

	/**
	 * Method used to merge two island and deleting one of them
	 * @param mergingInIsland island in which transfer students and towers
	 *                        from the other island
	 * @param mergingOutIsland island in which take students and towers to
	 *                         transfer on the other island
	 */
	public void mergeIsland(Island mergingInIsland, Island mergingOutIsland){
		for(PawnColor color : PawnColor.values()){
			int studentsPerColor = mergingInIsland.getStudentsPerColor(color);
			mergingInIsland.getStudents().replace(color, studentsPerColor + mergingOutIsland.getStudentsPerColor(color));
		}
		mergingInIsland.sumTower(mergingOutIsland.getNumberOfTowers());

		islandsList.remove(mergingOutIsland);
	}

	// JESTER

	/**
	 * Method used to initialize the six students of the card
	 * @param jester jester card to initialize
	 */
	public void initializeJesterStudents(Jester jester) throws EmptyBagException {
		HashMap<PawnColor, Integer> initialingStudents = new HashMap<>();
		for(PawnColor color : PawnColor.values())
			initialingStudents.put(color, 0);
		for(int i = 0; i < 6; i++){
				Student student = extractStudent();
				PawnColor color = student.getColor();
				initialingStudents.replace(color, initialingStudents.get(color) + 1);
		}
		jester.setStudentsOnCard(initialingStudents);
	}

	// MOTHER NATURE

	/**
	 * Method used to update mother nature's position
	 * @param jump number of jumps
	 */
	public void updateMotherNaturePosition(int jump){
		while(jump != 0){
			if(motherNature.getCurrentPosition() == islandsList.size() - 1)
				motherNature.setCurrentPosition(0);
			else motherNature.incrementCurrentPosition();
			jump--;
		}
	}

	// PROFESSORS

	/**
	 * Method used to update the dominating player of each professor
	 */
	private void computeProfessorsDominance(){
		for(PawnColor color : PawnColor.values()){
			int maxStudents = 0;
			Player controllingPlayer = professorsHashMap.get(color);
			if(controllingPlayer != null) maxStudents = controllingPlayer.getDashboard().getTables().get(color);
			for(Player player : playerHashMap.values())
				if(player.getDashboard().getTables().get(color) > maxStudents) professorsHashMap.replace(color, player);
		}
	}

	/**
	 * Method used to calculate how many professors are controlled by a player
	 * @param player player to check
	 * @return the number of professors controller by the player
	 */
	private int playerInfluenceOnProfessors(Player player){
		int influenceCounter = 0;
		for(Player dominator : professorsHashMap.values())
			if(player.getNickname().equals(dominator.getNickname())) influenceCounter++;
		return influenceCounter;
	}

	// TURN

	/**
	 * Method used to reset the turn's attributes at the end of the action phase
	 */
	public void resetTurn(){
		turn.setCurrentPlayerNickname(turn.getFirstPlayerNickname());
		turn.setPhaseName("PlanningPhase");
		turn.setPlayedCards(new HashMap<>());
		turn.setActivatedCharacterCard(false);
		computeDominanceStrategy = new StandardComputeDominance();
	}

	/**
	 * Method used to calculate the first player that have to play in the next
	 * planning and action phases
	 */
	public void setTurnFirstPlayer(){
		int minValue = 11;
		for(String nickname : turn.getPlayedCards().keySet()){
			int cardValue = turn.getPlayedCards().get(nickname).getValue();
			if(cardValue < minValue){
				minValue = cardValue;
				turn.setFirstPlayerNickname(nickname);
			}
		}
		turn.setPhaseName("ActionPhase");
	}

	// WINNING CONDITIONS

	/**
	 * Method used to calculate the winner
	 * @return the nickname of the winning player
	 * @throws NullWinnerException exception if nobody wins
	 * @throws TieException exception if a tie occurs
	 */
	public String checkWinCondition() throws NullWinnerException, TieException{
		Player winner = null;
		int maxTowers = 10;
		for(Player player : playerHashMap.values()){
			if(player.getDashboard().getNumberOfTowers() < maxTowers)
				winner = player;
			else if(player.getDashboard().getNumberOfTowers() == maxTowers)
				if(playerInfluenceOnProfessors(player) > playerInfluenceOnProfessors(winner))
					winner = player;
				else if(playerInfluenceOnProfessors(player) == playerInfluenceOnProfessors(winner)){
					assert winner != null;
					throw new TieException(player.getNickname(), winner.getNickname());
				}
		}
		if(winner == null) throw new NullWinnerException();
		return winner.getNickname();
	}

	/**
	 * Method used to get the winner in the scenario of zero towers left
	 * @return the nickname of the winning player
	 * @throws NullWinnerException exception if nobody wins
	 */
	public String zeroTowersLeftWinCondition() throws NullWinnerException{
		Player winner = null;
		for(Player player : playerHashMap.values())
			if(player.getDashboard().getNumberOfTowers() == 0) winner = player;
		if(winner == null) throw new NullWinnerException();
		return winner.getNickname();
	}


	// Operations

	/**
	 * Method used to activate the Centaur character card effect
	 * @param playerNickname nickname of the player who activated the card
	 */
	public void activateCentaurEffect(String playerNickname){
		CharacterCard centaur = new Centaur();
		for(CharacterCard characterCard : characterCardsList)
			if(characterCard instanceof Centaur) centaur = characterCard;
		Player chosenPlayer = playerHashMap.get(playerNickname);
		computeDominanceStrategy = new CentaurComputeDominance();
		chosenPlayer.removeCoins(centaur.getCost());
		centaur.incrementCost();
		turn.setActivatedCharacterCard(true);
	}

	/**
	 * Method used to activate the Jester character card effect
	 * @param playerNickname nickname of the player who activated the card
	 * @param requiredColors colors of the students required from the player
	 * @param givenColors colors of the students given from the player
	 */
	public void activateJesterEffect(String playerNickname, ArrayList<PawnColor> requiredColors, ArrayList<PawnColor> givenColors){
		CharacterCard jester = new Jester();
		for(CharacterCard characterCard : characterCardsList)
			if(characterCard instanceof Jester) jester = characterCard;
		Player chosenPlayer = playerHashMap.get(playerNickname);
		ArrayList<Student> givenStudents = new ArrayList<>();
		for (PawnColor color : givenColors)
			givenStudents.add(new Student(color));
		ArrayList<Student> requiredStudents = new ArrayList<>();
		for (PawnColor color : requiredColors)
			requiredStudents.add(new Student(color));

		chosenPlayer.getDashboard().deleteStudentsFromEntrance(givenStudents);
		ArrayList<Student> exchangingStudents = ((Jester) jester).exchangeStudents(requiredStudents, givenStudents);
		chosenPlayer.getDashboard().addStudentsInEntrance(exchangingStudents);
		chosenPlayer.removeCoins(jester.getCost());
		jester.incrementCost();
		turn.setActivatedCharacterCard(true);
	}

	/**
	 * Method used to activate the Knight character card effect
	 * @param playerNickname nickname of the player who activated the card
	 */
	public void activateKnightEffect(String playerNickname){
		CharacterCard knight = new Knight();
		for(CharacterCard characterCard : characterCardsList)
			if(characterCard instanceof Knight) knight = characterCard;
		Player chosenPlayer = playerHashMap.get(playerNickname);
		computeDominanceStrategy = new KnightComputeDominance();
		((KnightComputeDominance) computeDominanceStrategy).setActingPlayer(chosenPlayer);
		chosenPlayer.removeCoins(knight.getCost());
		knight.incrementCost();
		turn.setActivatedCharacterCard(true);
	}

	/**
	 * Method used to activate the Magic Postman character card effect
	 * @param playerNickname nickname of the player who activated the card
	 */
	public void activateMagicPostmanEffect(String playerNickname){
		CharacterCard magicPostman = new MagicPostman();
		for(CharacterCard characterCard : characterCardsList)
			if(characterCard instanceof MagicPostman) magicPostman = characterCard;
		Player chosenPlayer = playerHashMap.get(playerNickname);
		chosenPlayer.getLastPlayedCard().incrementMovementsByTwo();
		chosenPlayer.removeCoins(magicPostman.getCost());
		magicPostman.incrementCost();
		turn.setActivatedCharacterCard(true);
	}

	/**
	 * Method used to activate the Minstrel character card effect
	 * @param playerNickname nickname of the player who activated the card
	 * @param enteringEntranceColors colors of the students entering the entrance
	 * @param enteringTablesColors colors of the students entering the tables
	 */
	public void activateMinstrelEffect(String playerNickname, ArrayList<PawnColor> enteringEntranceColors, ArrayList<PawnColor> enteringTablesColors){
		int additionalCoins;
		CharacterCard minstrel = new Minstrel();
		for(CharacterCard characterCard : characterCardsList)
			if(characterCard instanceof Minstrel) minstrel = characterCard;
		Player chosenPlayer = playerHashMap.get(playerNickname);
		ArrayList<Student> enteringEntranceStudents = new ArrayList<>();
		for (PawnColor color : enteringEntranceColors)
			enteringEntranceStudents.add(new Student(color));
		ArrayList<Student> enteringTablesStudents = new ArrayList<>();
		for (PawnColor color : enteringTablesColors)
			enteringTablesStudents.add(new Student(color));

		chosenPlayer.getDashboard().addStudentsInEntrance(enteringEntranceStudents);
		chosenPlayer.getDashboard().deleteStudentsFromTables(enteringEntranceStudents);
		additionalCoins = chosenPlayer.getDashboard().moveStudentsFromEntranceToTables(enteringTablesStudents);
		chosenPlayer.addCoins(additionalCoins);
		chosenPlayer.removeCoins(minstrel.getCost());
		minstrel.incrementCost();
		turn.setActivatedCharacterCard(true);
		computeProfessorsDominance();
	}

	/**
	 * Method used to activate Mushroomer character card effect
	 * @param playerNickname nickname of the player who activated the card
	 * @param chosenColor chosen color to deactivate
	 */
	public void activateMushroomerEffect(String playerNickname, PawnColor chosenColor){
		CharacterCard mushroomer = new Mushroomer();
		for(CharacterCard characterCard : characterCardsList)
			if(characterCard instanceof Mushroomer) mushroomer = characterCard;
		Player chosenPlayer = playerHashMap.get(playerNickname);
		computeDominanceStrategy = new MushroomerComputeDominance();
		((MushroomerComputeDominance) computeDominanceStrategy).setChosenColor(chosenColor);
		chosenPlayer.removeCoins(mushroomer.getCost());
		mushroomer.incrementCost();
		turn.setActivatedCharacterCard(true);
	}

	/**
	 * Method used to transfer the students on the chosen cloud into the
	 * player's entrance
	 * @param playerNickname nickname of the player who choose the cloud
	 * @param position position of the chosen cloud
	 */
	public void chooseCloud(String playerNickname, int position){
		Player chosenPlayer = playerHashMap.get(playerNickname);
		Cloud chosenCloud = cloudsList.get(position);
		chosenPlayer.getDashboard().addStudentsInEntrance(chosenCloud.returnStudents());
	}

	/**
	 * Method used to move mother nature with the chosen distance and to activate
	 * the computeDominance with eventual merging of islands
	 * @param movement movements chosen by the player
	 * @throws NotEnoughIslandsException exception if the number of islands is less or equal three
	 * @throws ZeroTowersRemainedException exception if a players remains with zero towers left
	 */
	public void moveMotherNature(int movement) throws NotEnoughIslandsException, ZeroTowersRemainedException{
		updateMotherNaturePosition(movement);

		Island currentIsland = islandsList.get(motherNature.getCurrentPosition());
		Player currentPlayer = currentIsland.getDominator();

		Player newDominatingPlayer = computeDominanceStrategy.computeDominance(currentIsland, professorsHashMap);

		if(newDominatingPlayer != null){
			if(currentPlayer == null){
				currentIsland.setDominator(newDominatingPlayer);
				currentIsland.addTower();
				newDominatingPlayer.getDashboard().decrementTowers();
				if(newDominatingPlayer.getDashboard().getNumberOfTowers() == 0)
					throw new ZeroTowersRemainedException();
			}else if(!newDominatingPlayer.getNickname().equals(currentPlayer.getNickname())){
				int islandTowers = currentIsland.getNumberOfTowers();
				for(int i = 0; i < islandTowers; i++){
					currentPlayer.getDashboard().incrementTowers();
					newDominatingPlayer.getDashboard().decrementTowers();
					if(newDominatingPlayer.getDashboard().getNumberOfTowers() == 0)
						throw new ZeroTowersRemainedException();
				}
				currentIsland.setDominator(newDominatingPlayer);

				samePlayerCheckInNextIsland(currentIsland);
				samePlayerCheckInPreviousIsland(currentIsland);
			}
		}

		if(islandsList.size() <= 3) throw new NotEnoughIslandsException();
	}

	/**
	 * Method used to play the chosen assistant card by the player
	 * @param playerNickname nickname of the player who played an assistant card
	 * @param position position of the played assistant card in the player's hand
	 * @throws NotEnoughAssistantCardsException exception if the player has no assistant
	 * cards left
	 */
	public void playAssistantCard(String playerNickname, int position) throws NotEnoughAssistantCardsException{
		Player chosenPlayer = playerHashMap.get(playerNickname);
		chosenPlayer.setLastPlayedCard(chosenPlayer.getHand().get(position));
		chosenPlayer.removeAssistantCardFromHand(position);
		turn.addPlayedCard(chosenPlayer.getNickname(), chosenPlayer.getLastPlayedCard());
		turn.incrementMovedStudents();
		if(chosenPlayer.getHand().size() == 0) throw new NotEnoughAssistantCardsException();
	}

	/**
	 * Method used to move a single student from entrance to tables
	 * @param playerNickname nickname of the player who moved the student
	 * @param studentColor color of the student to be moved
	 */
	public void putStudentOnTables(String playerNickname, PawnColor studentColor){
		int additionalCoins;
		Player chosenPlayer = playerHashMap.get(playerNickname);
		additionalCoins = chosenPlayer.getDashboard().moveSingleStudentFromEntranceToTables(studentColor);
		chosenPlayer.addCoins(additionalCoins);
		computeProfessorsDominance();
		turn.incrementMovedStudents();
	}

	/**
	 * Method used to move a single student from entrance to a chosen island
	 * @param playerNickname nickname of the player who moved the student
	 * @param position position of the chosen island
	 * @param studentColor color of the student to be moved
	 */
	public void putStudentOnIslands(String playerNickname, int position, PawnColor studentColor){
		Player chosenPlayer = playerHashMap.get(playerNickname);
		Island chosenIsland = islandsList.get(position);
		chosenPlayer.getDashboard().deleteSingleStudentFromEntrance(studentColor);
		chosenIsland.addStudent(studentColor);
	}


	// GETTER - Player
	public int getNumberOfPlayers(){
		return numberOfPlayers;
	}

	public HashMap<String, Player> getPlayerHashMap(){
		return playerHashMap;
	}

	public ArrayList<String> getPlayersNicknames(){
		ArrayList<String> listOfNicknames = new ArrayList<>();
		for(Player player : playerHashMap.values()) listOfNicknames.add(player.getNickname());
		return listOfNicknames;
	}

	public Player getCurrentPlayer(){
		Player currentPlayer = null;
		for(Player player : playerHashMap.values())
			if(player.getNickname().equals(turn.getCurrentPlayerNickname())) currentPlayer = player;
		return currentPlayer;
	}

	public ArrayList<AssistantCard> getPlayerHand(String playerNickname){
		Player chosenPlayer = playerHashMap.get(playerNickname);
		return chosenPlayer.getHand();
	}

	public AssistantCard getPlayerLastPlayedAssistantCard(String playerNickname){
		Player chosenPlayer = playerHashMap.get(playerNickname);
		return chosenPlayer.getLastPlayedCard();
	}

	public int getPlayerCoins(String playerNickname){
		Player chosenPlayer = playerHashMap.get(playerNickname);
		return chosenPlayer.getCoins();
	}

	// GETTER - Character Cards
	public HashMap<PawnColor, Integer> getJesterStudentsOnCard(){
		CharacterCard jester = new Jester();
		for(CharacterCard characterCard : characterCardsList)
			if(characterCard instanceof Jester) jester = characterCard;
		return ((Jester) jester).getStudentsOnCard();
	}

	// GETTER - Turn
	public Turn getTurn(){
		return turn;
	}

	public String getFirstPlayerNickname(){
		return turn.getFirstPlayerNickname();
	}

	public String getCurrentPlayerNickname(){
		return turn.getCurrentPlayerNickname();
	}

	public String getCurrentPhase(){
		return turn.getPhaseName();
	}

	public int getTurnMovedStudents(){
		return turn.getMovedStudents();
	}

	public boolean isCharacterCardActivated(){
		return turn.isActivatedCharacterCard();
	}

	public ArrayList<AssistantCard> getTurnPlayedCards(){
		return new ArrayList<>(turn.getPlayedCards().values());
	}

	// SETTER - Turn
	public void setCurrentPlayerNickname(String nickname){
		turn.setCurrentPlayerNickname(nickname);
	}

	public void setCurrentPhase(String phaseName){
		turn.setPhaseName(phaseName);
	}

	public void resetTurnMovedStudents() { turn.resetMovedStudents(); }

	// GETTER
	public boolean isExpertMode(){
		return expertMode;
	}

	public MotherNature getMotherNature(){
		return motherNature;
	}

	public Bag getBag(){
		return bag;
	}

	public HashMap<PawnColor, Player> getProfessorsHashMap(){
		return professorsHashMap;
	}

	public ArrayList<Cloud> getCloudsList(){
		return cloudsList;
	}

	public ArrayList<Island> getIslandsList(){
		return islandsList;
	}

	public ArrayList<CharacterCard> getCharacterCardsList(){
		return characterCardsList;
	}
}
