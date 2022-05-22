package it.polimi.ingsw.s3m.launcher.DTOs;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class MapperTest{
	Mapper mapper;

	@BeforeEach
	void mapperSetup(){
		mapper = new Mapper();
	}

	// stringToColor
	@Test
	void nullColorStringReturnsNull(){
		assertNull(mapper.stringToColor(null));
	}

	@Test
	void lowercaseRedColorStringReturnsRedPawnColor(){
		PawnColor color = mapper.stringToColor("red");
		assertEquals(PawnColor.RED, color);
	}

	@Test
	void uppercaseBlueColorStringReturnsBluePawnColor(){
		PawnColor color = mapper.stringToColor("BLUE");
		assertEquals(PawnColor.BLUE, color);
	}

	@Test
	void upperAndLowercaseGreenColorStringReturnsGreenPawnColor(){
		PawnColor color = mapper.stringToColor("gReeN");
		assertEquals(PawnColor.GREEN, color);
	}

	@Test
	void yellowColorStringReturnsYellowPawnColor(){
		PawnColor color = mapper.stringToColor("Yellow");
		assertEquals(PawnColor.YELLOW, color);
	}

	@Test
	void pinkColorStringReturnsPinkPawnColor(){
		PawnColor color = mapper.stringToColor("Pink");
		assertEquals(PawnColor.PINK, color);
	}

	@Test
	void incorrectInputStringReturnsNull(){
		assertNull(mapper.stringToColor("Yellow6"));
	}


	// stringListToColor
	@Test
	void nullColorStringListReturnsNull(){
		assertNull(mapper.stringListToColor(null));
	}

	@Test
	void colorStringListSizeEquals0ReturnsAnEmptyArray(){
		ArrayList<String> colorStringList = new ArrayList<>();
		ArrayList<PawnColor> colors = mapper.stringListToColor(colorStringList);
		assertEquals(0, colors.size());
	}

	@Test
	void colorStringListContainingOneStringPerColorReturnsAnArrayWithOnePawnColorPerColor(){
		ArrayList<String> colorStringList = new ArrayList<>();
		colorStringList.add("Blue");
		colorStringList.add("Green");
		colorStringList.add("Pink");
		colorStringList.add("Red");
		colorStringList.add("Yellow");

		ArrayList<PawnColor> colors = mapper.stringListToColor(colorStringList);
		assertEquals(5, colors.size());
		assertEquals(1, colors.stream().filter(color -> color == PawnColor.BLUE).count());
		assertEquals(1, colors.stream().filter(color -> color == PawnColor.GREEN).count());
		assertEquals(1, colors.stream().filter(color -> color == PawnColor.PINK).count());
		assertEquals(1, colors.stream().filter(color -> color == PawnColor.RED).count());
		assertEquals(1, colors.stream().filter(color -> color == PawnColor.YELLOW).count());
	}


	// assistantCardToDTO
	@Test
	void assistantCardToDTOWithNullAssistantCardCreatesANullTypeAssistantCard(){
		AssistantCardDTO assistantCardDTO = mapper.assistantCardToDTO(null);
		assertNull(assistantCardDTO.getType());
		assertEquals(0, assistantCardDTO.getValue());
		assertEquals(0, assistantCardDTO.getMovements());
	}

	@Test
	void assistantCardToDTOWithDogAssistantCardReturnsAValidAssistantCard(){
		AssistantCardDTO assistantCardDTO = mapper.assistantCardToDTO(AssistantCard.DOG);
		assertEquals("Dog", assistantCardDTO.getType());
		assertEquals(3, assistantCardDTO.getValue());
		assertEquals(2, assistantCardDTO.getMovements());
	}


	// assistantCardListToDTO
	@Test
	void nullAssistantCardListReturnsNull(){
		assertNull(mapper.assistantCardListToDTO(null));
	}

	@Test
	void assistantCardListSizeEquals0ReturnsAnEmptyArray(){
		ArrayList<AssistantCard> assistantCards = new ArrayList<>();

		ArrayList<AssistantCardDTO> assistantCardDTOS = mapper.assistantCardListToDTO(assistantCards);
		assertEquals(0, assistantCardDTOS.size());
	}

	@Test
	void assistantCardListContainingTwoAssistantCardReturnsAnArrayWithLengthEqualsTwo(){
		ArrayList<AssistantCard> assistantCards = new ArrayList<>();
		assistantCards.add(AssistantCard.TURTLE);
		assistantCards.add(AssistantCard.ELEPHANT);

		ArrayList<AssistantCardDTO> assistantCardDTOS = mapper.assistantCardListToDTO(assistantCards);
		assertEquals(2, assistantCardDTOS.size());
		assertEquals("Turtle", assistantCardDTOS.get(0).getType());
		assertEquals("Elephant", assistantCardDTOS.get(1).getType());
	}


	// dashboardToDTO
	@Test
	void nullDashboardReturnsNullDashboardDTO(){
		DashboardDTO dashboardDTO;
		dashboardDTO = mapper.dashboardToDTO(null);

		assertNull(dashboardDTO.getEntrance());
		assertNull(dashboardDTO.getTables());
		assertEquals(0, dashboardDTO.getNumberOfTowers());
	}

	@Test
	void correctedDashboardReturnsANewDashboardDTOObject(){
		// Dashboard initialization
		Dashboard dashboard = new Dashboard();

		ArrayList<Student> enteringEntranceStudents = new ArrayList<>();
		enteringEntranceStudents.add(new Student(PawnColor.BLUE));
		enteringEntranceStudents.add(new Student(PawnColor.GREEN));
		enteringEntranceStudents.add(new Student(PawnColor.PINK));
		enteringEntranceStudents.add(new Student(PawnColor.RED));
		enteringEntranceStudents.add(new Student(PawnColor.YELLOW));
		dashboard.addStudentsInEntrance(enteringEntranceStudents);

		ArrayList<Student> movingStudents = new ArrayList<>();
		movingStudents.add(new Student(PawnColor.RED));
		movingStudents.add(new Student(PawnColor.YELLOW));
		dashboard.moveStudentsFromEntranceToTables(movingStudents);

		assertEquals(1, dashboard.getEntrance().get(PawnColor.BLUE));
		assertEquals(1, dashboard.getEntrance().get(PawnColor.GREEN));
		assertEquals(1, dashboard.getEntrance().get(PawnColor.PINK));
		assertEquals(0, dashboard.getEntrance().get(PawnColor.RED));
		assertEquals(0, dashboard.getEntrance().get(PawnColor.YELLOW));

		assertEquals(0, dashboard.getTables().get(PawnColor.BLUE));
		assertEquals(0, dashboard.getTables().get(PawnColor.GREEN));
		assertEquals(0, dashboard.getTables().get(PawnColor.PINK));
		assertEquals(1, dashboard.getTables().get(PawnColor.RED));
		assertEquals(1, dashboard.getTables().get(PawnColor.YELLOW));

		dashboard.setNumberOfTowers(3);
		assertEquals(3, dashboard.getNumberOfTowers());

		// Creating dashboardDTO
		DashboardDTO dashboardDTO = mapper.dashboardToDTO(dashboard);

		assertEquals(1, dashboardDTO.getEntrance().get("BLUE"));
		assertEquals(1, dashboardDTO.getEntrance().get("GREEN"));
		assertEquals(1, dashboardDTO.getEntrance().get("PINK"));
		assertEquals(0, dashboardDTO.getEntrance().get("RED"));
		assertEquals(0, dashboardDTO.getEntrance().get("YELLOW"));

		assertEquals(0, dashboardDTO.getTables().get("BLUE"));
		assertEquals(0, dashboardDTO.getTables().get("GREEN"));
		assertEquals(0, dashboardDTO.getTables().get("PINK"));
		assertEquals(1, dashboardDTO.getTables().get("RED"));
		assertEquals(1, dashboardDTO.getTables().get("YELLOW"));

		assertEquals(3, dashboardDTO.getNumberOfTowers());
	}


	// playerToDTO
	@Test
	void nullPlayerReturnsANewEmptyPlayerDTO(){
		PlayerDTO playerDTO = mapper.playerToDTO(null);

		assertEquals("", playerDTO.getNickname());
		assertEquals("", playerDTO.getColor());
		assertNull(playerDTO.getDashboard());
		assertNull(playerDTO.getHand());
		assertNull(playerDTO.getLastCardPlayed());
	}

	@Test
	void correctedPlayerReturnsANewPlayerDTOObject(){
		// Player initialization
		Player player = new Player("Nick", TowerColor.WHITE);
		assertEquals("Nick", player.getNickname());
		assertEquals(TowerColor.WHITE, player.getColor());

		ArrayList<Student> enteringEntranceStudents = new ArrayList<>();
		enteringEntranceStudents.add(new Student(PawnColor.RED));
		player.getDashboard().addStudentsInEntrance(enteringEntranceStudents);
		assertEquals(0, player.getDashboard().getEntrance().get(PawnColor.BLUE));
		assertEquals(0, player.getDashboard().getEntrance().get(PawnColor.GREEN));
		assertEquals(0, player.getDashboard().getEntrance().get(PawnColor.PINK));
		assertEquals(1, player.getDashboard().getEntrance().get(PawnColor.RED));
		assertEquals(0, player.getDashboard().getEntrance().get(PawnColor.YELLOW));

		player.setLastPlayedCard(AssistantCard.DOG);
		assertEquals(10, player.getHand().size());
		assertEquals(AssistantCard.DOG, player.getLastPlayedCard());

		// Creating PlayerDTO
		PlayerDTO playerDTO = mapper.playerToDTO(player);
		assertEquals("Nick", playerDTO.getNickname());
		assertEquals("WHITE", playerDTO.getColor());

		assertEquals(0, playerDTO.getDashboard().getEntrance().get("BLUE"));
		assertEquals(0, playerDTO.getDashboard().getEntrance().get("GREEN"));
		assertEquals(0, playerDTO.getDashboard().getEntrance().get("PINK"));
		assertEquals(1, playerDTO.getDashboard().getEntrance().get("RED"));
		assertEquals(0, playerDTO.getDashboard().getEntrance().get("YELLOW"));

		assertEquals(10, playerDTO.getHand().size());
		assertEquals("Dog", playerDTO.getLastCardPlayed().getType());
	}


	// islandToDTO
	@Test
	void nullIslandReturnsIslandDTOWithNullHashMapStudents(){
		IslandDTO islandDTO = mapper.islandToDTO(null);

		assertNull(islandDTO.getStudents());
		assertEquals("", islandDTO.getDominator());
		assertEquals("", islandDTO.getDominatorColor());
		assertEquals(0, islandDTO.getNumberOfTowers());
	}

	@Test
	void nullIslandDominatorReturnsIslandDTOWithEmptyDominatorString(){
		// Island initialization
		Island island = new Island();
		for(PawnColor color : PawnColor.values())
			island.getStudents().replace(color, 1);

		assertNull(island.getDominator());
		for(PawnColor color : PawnColor.values())
			assertEquals(1, island.getStudents().get(color));
		assertEquals(0, island.getNumberOfTowers());

		// Creating islandDTO
		IslandDTO islandDTO = mapper.islandToDTO(island);
		for(PawnColor color : PawnColor.values())
			assertEquals(1, islandDTO.getStudents().get(color.name()));
		assertEquals("", islandDTO.getDominator());
		assertEquals("", islandDTO.getDominatorColor());
		assertEquals(0, islandDTO.getNumberOfTowers());
	}

	@Test
	void correctedIslandReturnsANewIslandDTOObject(){
		// Island initialization
		Island island = new Island();
		Player player = new Player("Nick", TowerColor.WHITE);
		island.setDominator(player);
		for(PawnColor color : PawnColor.values())
			island.getStudents().replace(color, 1);
		island.addTower();

		assertEquals("Nick", island.getDominator().getNickname());
		for(PawnColor color : PawnColor.values())
			assertEquals(1, island.getStudents().get(color));
		assertEquals(1, island.getNumberOfTowers());

		// Creating islandDTO
		IslandDTO islandDTO = mapper.islandToDTO(island);
		for(PawnColor color : PawnColor.values())
			assertEquals(1, islandDTO.getStudents().get(color.name()));
		assertEquals("Nick", islandDTO.getDominator());
		assertEquals("WHITE", islandDTO.getDominatorColor());
		assertEquals(1, islandDTO.getNumberOfTowers());
	}


	// islandListToDTO
	@Test
	void nullIslandsListReturnsNull(){
		assertNull(mapper.islandListToDTO(null));
	}

	@Test
	void emptyIslandsListReturnsAnArrayWithSizeEquals0(){
		ArrayList<Island> islandsList = new ArrayList<>();
		ArrayList<IslandDTO> islandsListDTO = mapper.islandListToDTO(islandsList);
		assertEquals(0, islandsListDTO.size());
	}

	@Test
	void islandsListSizeEqualsTo3ReturnsAnArrayWithSizeEqualsTo3(){
		ArrayList<Island> islandsList = new ArrayList<>();
		islandsList.add(new Island());
		islandsList.add(new Island());
		islandsList.add(new Island());
		ArrayList<IslandDTO> islandsListDTO = mapper.islandListToDTO(islandsList);
		assertEquals(3, islandsListDTO.size());
	}


	// pawnColorHashMapToStringHashMap
	@Test
	void nullPawnColorHashMapReturnsNull(){
		assertNull(mapper.pawnColorHashMapToStringHashMap(null));
	}

	@Test
	void hashMapWithIntegerEquals1ForEachColorReturnsANewHashMapWithTheSameIntegerValues(){
		HashMap<PawnColor, Integer> pawnColorIntegerHashMap = new HashMap<>();
		for (PawnColor color : PawnColor.values())
			pawnColorIntegerHashMap.put(color, 1);
		assertEquals(1, pawnColorIntegerHashMap.get(PawnColor.BLUE));
		assertEquals(1, pawnColorIntegerHashMap.get(PawnColor.GREEN));
		assertEquals(1, pawnColorIntegerHashMap.get(PawnColor.PINK));
		assertEquals(1, pawnColorIntegerHashMap.get(PawnColor.RED));
		assertEquals(1, pawnColorIntegerHashMap.get(PawnColor.YELLOW));

		HashMap<String, Integer> stringIntegerHashMap = mapper.pawnColorHashMapToStringHashMap(pawnColorIntegerHashMap);
		assertEquals(1, stringIntegerHashMap.get("BLUE"));
		assertEquals(1, stringIntegerHashMap.get("GREEN"));
		assertEquals(1, stringIntegerHashMap.get("PINK"));
		assertEquals(1, stringIntegerHashMap.get("RED"));
		assertEquals(1, stringIntegerHashMap.get("YELLOW"));
	}


	// characterCardToDTO
	@Test
	void nullCharacterCardReturnsCharacterCardDTOWithoutName(){
		CharacterCardDTO characterCardDTO = mapper.characterCardToDTO(null);
		assertEquals("", characterCardDTO.getName());
		assertEquals(0, characterCardDTO.getCost());
		assertNull(characterCardDTO.getStudentsOnCard());
	}

	@Test
	void characterCardNotEqualsToJesterReturnsANewCharacterCardDTOWithNullStudentsAttribute(){
		CharacterCardDTO characterCardDTO = mapper.characterCardToDTO(new Centaur());
		assertEquals("Centaur", characterCardDTO.getName());
		assertEquals(3, characterCardDTO.getCost());
		assertNull(characterCardDTO.getStudentsOnCard());
	}

	@Test
	void characterCardEqualsToJesterReturnsANewCharacterCardDTOWithNotNullStudentsAttribute(){
		Jester characterCard = new Jester();
		HashMap<PawnColor, Integer> pawnColorIntegerHashMap = new HashMap<>();
		for (PawnColor color : PawnColor.values())
			pawnColorIntegerHashMap.put(color, 1);
		characterCard.setStudentsOnCard(pawnColorIntegerHashMap);
		for (PawnColor color : PawnColor.values())
			assertEquals(1, characterCard.getStudentsOnCard().get(color));

		CharacterCardDTO characterCardDTO = mapper.characterCardToDTO(characterCard);
		assertEquals("Jester", characterCardDTO.getName());
		assertEquals(1, characterCardDTO.getCost());
		assertNotNull(characterCardDTO.getStudentsOnCard());
		assertEquals(1, characterCardDTO.getStudentsOnCard().get("BLUE"));
		assertEquals(1, characterCardDTO.getStudentsOnCard().get("GREEN"));
		assertEquals(1, characterCardDTO.getStudentsOnCard().get("PINK"));
		assertEquals(1, characterCardDTO.getStudentsOnCard().get("RED"));
		assertEquals(1, characterCardDTO.getStudentsOnCard().get("YELLOW"));
	}


	// characterCardListToDTO
	@Test
	void nullCharacterCardListReturnsNull(){
		assertNull(mapper.characterCardListToDTO(null));
	}

	@Test
	void characterCardListSizeEqualsTo3ReturnsAnArrayWithSizeEqualsTo3(){
		ArrayList<CharacterCard> characterCardsList = new ArrayList<>();
		characterCardsList.add(new Centaur());
		characterCardsList.add(new Knight());
		characterCardsList.add(new Minstrel());
		ArrayList<CharacterCardDTO> characterCardDTOS = mapper.characterCardListToDTO(characterCardsList);
		assertEquals(3, characterCardDTOS.size());
		assertEquals("Centaur", characterCardDTOS.get(0).getName());
		assertEquals("Knight", characterCardDTOS.get(1).getName());
		assertEquals("Minstrel", characterCardDTOS.get(2).getName());
	}


	// cloudToDTO
	@Test
	void nullCloudReturnsNullCloudDTOStudents(){
		CloudDTO cloudDTO = mapper.cloudToDTO(null);
		assertNull(cloudDTO.getStudents());
	}

	@Test
	void cloudStudentsWithThreeDifferentStudentsReturnsANewCloudDTOObjectWithThreeStudents(){
		// Cloud initialization
		Cloud cloud = new Cloud();
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student(PawnColor.BLUE));
		students.add(new Student(PawnColor.GREEN));
		students.add(new Student(PawnColor.RED));
		cloud.setStudents(students);

		assertEquals(3, cloud.getStudents().size());
		assertEquals(PawnColor.BLUE, cloud.getStudents().get(0).getColor());
		assertEquals(PawnColor.GREEN, cloud.getStudents().get(1).getColor());
		assertEquals(PawnColor.RED, cloud.getStudents().get(2).getColor());

		// Creating cloudDTO
		CloudDTO cloudDTO = mapper.cloudToDTO(cloud);

		assertNotNull(cloudDTO.getStudents());
		assertEquals(3, cloudDTO.getStudents().size());
		assertEquals("BLUE", cloudDTO.getStudents().get(0));
		assertEquals("GREEN", cloudDTO.getStudents().get(1));
		assertEquals("RED", cloudDTO.getStudents().get(2));
	}


	// cloudListToDTO
	@Test
	void nullCloudListReturnsNull(){
		assertNull(mapper.cloudListToDTO(null));
	}

	@Test
	void cloudListSizeEqualsTo3ReturnsAnArrayWithSizeEqualsTo3(){
		ArrayList<Cloud> cloudList = new ArrayList<>();
		cloudList.add(new Cloud());
		cloudList.add(new Cloud());
		cloudList.add(new Cloud());
		ArrayList<CloudDTO> cloudDTOS = mapper.cloudListToDTO(cloudList);
		assertEquals(3, cloudDTOS.size());
	}


	// turnToDTO
	@Test
	void nullTurnReturnsTurnDTOWithNoPlayersName(){
		TurnDTO turnDTO = mapper.turnToDTO(null);
		assertEquals("", turnDTO.getFirstPlayerNickname());
		assertEquals("", turnDTO.getCurrentPlayerNickname());
		assertEquals("", turnDTO.getCurrentPhase());
		assertNull(turnDTO.getPlayedCards());
		assertFalse(turnDTO.isCharacterCardActivated());
		assertEquals(0, turnDTO.getMotherNatureMaxAllowedMovements());
	}

	@Test
	void correctedTurnReturnsANewTurnDTO(){
		// Turn initialization
		Turn turn = new Turn("FirstPlayer");
		turn.setPhaseName("ActionPhase");
		turn.setMotherNatureMaxAllowedMovements(3);
		turn.setActivatedCharacterCard(true);
		HashMap<String, AssistantCard> stringAssistantCardHashMap = new HashMap<>();
		stringAssistantCardHashMap.put("FirstPlayer", AssistantCard.DOG);
		stringAssistantCardHashMap.put("SecondPlayer", AssistantCard.CAT);
		turn.setPlayedCards(stringAssistantCardHashMap);

		assertEquals("FirstPlayer", turn.getFirstPlayerNickname());
		assertEquals("FirstPlayer", turn.getCurrentPlayerNickname());
		assertEquals("ActionPhase", turn.getPhaseName());
		assertEquals("Dog", turn.getPlayedCards().get("FirstPlayer").getType());
		assertEquals("Cat", turn.getPlayedCards().get("SecondPlayer").getType());
		assertTrue(turn.isActivatedCharacterCard());
		assertEquals(3, turn.getMotherNatureMaxAllowedMovements());

		// Creating turnDTO
		TurnDTO turnDTO = mapper.turnToDTO(turn);
		assertEquals("FirstPlayer", turnDTO.getFirstPlayerNickname());
		assertEquals("FirstPlayer", turnDTO.getCurrentPlayerNickname());
		assertEquals("ActionPhase", turnDTO.getCurrentPhase());
		assertEquals("Dog", turnDTO.getPlayedCards().get("FirstPlayer").getType());
		assertEquals("Cat", turnDTO.getPlayedCards().get("SecondPlayer").getType());
		assertTrue(turnDTO.isCharacterCardActivated());
		assertEquals(3, turnDTO.getMotherNatureMaxAllowedMovements());
	}


	// gameToDTO
	@Test
	void nullGameReturnsNullGameDTO(){
		GameDTO gameDTO = mapper.gameToDTO(null);
		assertEquals(0, gameDTO.getPlayersNumber());
		assertFalse(gameDTO.isExpertMode());
		assertEquals(0, gameDTO.getMotherNaturePosition());
		assertNull(gameDTO.getCurrentPlayer());
		assertNull(gameDTO.getPlayerNicknames());
		assertNull(gameDTO.getDashboards());
		assertNull(gameDTO.getCoins());
		assertNull(gameDTO.getTowerColor());
		assertNull(gameDTO.getClouds());
		assertNull(gameDTO.getProfessors());
		assertNull(gameDTO.getIslands());
		assertNull(gameDTO.getCharacterCards());
		assertNull(gameDTO.getTurn());
		assertNull(gameDTO.getLastPlayedCards());
	}

	@Test
	void correctedGameReturnsNewGameDTOObject() throws EmptyBagException {
		// Game initialization
		ArrayList<String> nicknames = new ArrayList<>();
		nicknames.add("FirstPlayer");
		nicknames.add("SecondPlayer");
		Game game = new Game(nicknames, true);
		assertEquals(2, game.getNumberOfPlayers());
		assertTrue(game.isExpertMode());

		game.getMotherNature().setCurrentPosition(3);
		assertEquals(3, game.getMotherNature().getCurrentPosition());

		game.getTurn().setCurrentPlayerNickname("SecondPlayer");
		assertEquals("SecondPlayer", game.getTurn().getCurrentPlayerNickname());

		for (Player player : game.getPlayerHashMap().values()) {
			assertEquals(8, player.getDashboard().getNumberOfTowers());
			assertEquals(1, player.getCoins());
		}

		assertEquals(TowerColor.WHITE, game.getPlayerHashMap().get("FirstPlayer").getColor());
		assertEquals(TowerColor.BLACK, game.getPlayerHashMap().get("SecondPlayer").getColor());

		assertEquals(2, game.getCloudsList().size());

		assertEquals(3, game.getCharacterCardsList().size());

		for (PawnColor color : PawnColor.values())
			assertNull(game.getProfessorsHashMap().get(color));

		assertEquals(12, game.getIslandsList().size());

		assertNotNull(game.getTurn());

		// Creating gameDTO
		GameDTO gameDTO = mapper.gameToDTO(game);
		assertEquals(2, gameDTO.getPlayersNumber());
		assertTrue(gameDTO.isExpertMode());

		assertEquals(3, gameDTO.getMotherNaturePosition());

		assertEquals("SecondPlayer", gameDTO.getCurrentPlayer().getNickname());

		assertEquals(2, gameDTO.getPlayerNicknames().size());
		assertEquals("SecondPlayer", gameDTO.getPlayerNicknames().get(0));
		assertEquals("FirstPlayer", gameDTO.getPlayerNicknames().get(1));

		assertEquals(2, gameDTO.getDashboards().size());

		assertEquals(1, gameDTO.getCoins().get("FirstPlayer"));
		assertEquals(1, gameDTO.getCoins().get("SecondPlayer"));

		assertEquals("WHITE", gameDTO.getTowerColor().get("FirstPlayer"));
		assertEquals("BLACK", gameDTO.getTowerColor().get("SecondPlayer"));

		assertEquals(2, gameDTO.getClouds().size());

		assertNull(gameDTO.getProfessors().get("BLUE"));
		assertNull(gameDTO.getProfessors().get("GREEN"));
		assertNull(gameDTO.getProfessors().get("PINK"));
		assertNull(gameDTO.getProfessors().get("RED"));
		assertNull(gameDTO.getProfessors().get("YELLOW"));

		assertEquals(12, gameDTO.getIslands().size());

		assertEquals(3, gameDTO.getCharacterCards().size());

		assertNotNull(gameDTO.getTurn());

		assertNull(gameDTO.getLastPlayedCards().get("FirstPlayer"));
		assertNull(gameDTO.getLastPlayedCards().get("SecondPlayer"));
	}
}