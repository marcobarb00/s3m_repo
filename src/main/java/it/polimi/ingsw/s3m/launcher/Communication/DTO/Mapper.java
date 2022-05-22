package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.CharacterCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.Jester;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.stream.Collectors;

public class Mapper{
	public PawnColor stringToColor(String colorString){
		if(colorString == null) return null;
		switch(colorString.toUpperCase(Locale.ENGLISH)){
			case "RED":
				return PawnColor.RED;
			case "BLUE":
				return PawnColor.BLUE;
			case "GREEN":
				return PawnColor.GREEN;
			case "YELLOW":
				return PawnColor.YELLOW;
			case "PINK":
				return PawnColor.PINK;
			default:
				return null;
		}
	}

	public ArrayList<PawnColor> stringListToColor(ArrayList<String> colorStringList){
		if(colorStringList == null) return null;

		ArrayList<PawnColor> colorList = new ArrayList<>();
		colorStringList.forEach(colorString -> colorList.add(stringToColor(colorString)));
		return colorList;
	}

	public AssistantCardDTO assistantCardToDTO(AssistantCard assistantCard){
		if(assistantCard == null) return new AssistantCardDTO(null, 0, 0);
		return new AssistantCardDTO(assistantCard.getType(), assistantCard.getValue(), assistantCard.getMovements());
	}

	public ArrayList<AssistantCardDTO> assistantCardListToDTO(ArrayList<AssistantCard> assistantCardList){
		if(assistantCardList == null) return null;

		ArrayList<AssistantCardDTO> assistantCardDTOList = new ArrayList<>();
		for(AssistantCard assistantCard : assistantCardList)
			assistantCardDTOList.add(assistantCardToDTO(assistantCard));

		return assistantCardDTOList;
	}

	public DashboardDTO dashboardToDTO(Dashboard dashboard){
		if(dashboard == null) return new DashboardDTO(null, null, 0);

		HashMap<String, Integer> entrance = new HashMap<>();
		dashboard.getEntrance().forEach((color, value) -> entrance.put(color.name(), value));

		HashMap<String, Integer> tables = new HashMap<>();
		dashboard.getTables().forEach((color, value) -> tables.put(color.name(), value));

		return new DashboardDTO(entrance, tables, dashboard.getNumberOfTowers());
	}

	public PlayerDTO playerToDTO(Player player){
		if(player == null) return new PlayerDTO("", "", null, null, null);
		return new PlayerDTO(player.getNickname(), player.getColor().name(), dashboardToDTO(player.getDashboard()), assistantCardListToDTO(player.getHand()), assistantCardToDTO(player.getLastPlayedCard()));
	}

	public IslandDTO islandToDTO(Island island){
		if (island == null) return new IslandDTO(null, "", "", 0);
		HashMap<String, Integer> students = new HashMap<>();
		for(PawnColor color : PawnColor.values())
			students.put(color.name(), island.getStudents().get(color));

		if(island.getDominator() == null) return new IslandDTO(students, "", "", 0);

		return new IslandDTO(students, island.getDominator().getNickname(),
				island.getDominator().getColor().name(), island.getNumberOfTowers());
	}

	public ArrayList<IslandDTO> islandListToDTO(ArrayList<Island> islandsList){
		if (islandsList == null) return null;
		ArrayList<IslandDTO> islandDTOList = new ArrayList<>();
		for(Island island : islandsList) islandDTOList.add(islandToDTO(island));

		return islandDTOList;
	}

	public HashMap<String, Integer> pawnColorHashMapToStringHashMap(HashMap<PawnColor, Integer> pawnColorHashMap){
		if (pawnColorHashMap == null) return null;
		HashMap<String, Integer> stringHashMap = new HashMap<>();
		pawnColorHashMap.forEach(((pawnColor, value) -> stringHashMap.put(pawnColor.name(), value)));
		return stringHashMap;
	}

	public CharacterCardDTO characterCardToDTO(CharacterCard characterCard){
		if (characterCard == null) return new CharacterCardDTO("", 0, null);
		if(characterCard instanceof Jester){
			HashMap<String, Integer> studentsOnCard = pawnColorHashMapToStringHashMap(((Jester) characterCard).getStudentsOnCard());
			return new CharacterCardDTO(characterCard.getName(), characterCard.getCost(), studentsOnCard);
		}
		return new CharacterCardDTO(characterCard.getName(), characterCard.getCost(), null);
	}

	public ArrayList<CharacterCardDTO> characterCardListToDTO(ArrayList<CharacterCard> characterCardList){
		if (characterCardList == null) return null;
		ArrayList<CharacterCardDTO> characterCardDTOList = new ArrayList<>();
		for(CharacterCard characterCard : characterCardList)
			characterCardDTOList.add(characterCardToDTO(characterCard));

		return characterCardDTOList;
	}

	public CloudDTO cloudToDTO(Cloud cloud){
		if (cloud == null) return new CloudDTO(null);
		ArrayList<String> students = cloud.getStudents().stream()
				.map(Student::getColor)
				.map(Enum::name)
				.collect(Collectors.toCollection(ArrayList::new));

		return new CloudDTO(students);
	}

	public ArrayList<CloudDTO> cloudListToDTO(ArrayList<Cloud> cloudList){
		if (cloudList == null) return null;
		ArrayList<CloudDTO> cloudDTOList = new ArrayList<>();
		for(Cloud cloud : cloudList) cloudDTOList.add(cloudToDTO(cloud));

		return cloudDTOList;
	}

	public TurnDTO turnToDTO(Turn turn){
		if(turn == null) return new TurnDTO("", "", "", null, false, 0);

		HashMap<String, AssistantCardDTO> playedCards = new HashMap<>();
		turn.getPlayedCards().forEach((nickname, card) -> playedCards.put(nickname, assistantCardToDTO(card)));

		return new TurnDTO(turn.getFirstPlayerNickname(), turn.getCurrentPlayerNickname(), turn.getPhaseName(), playedCards, turn.isActivatedCharacterCard(), turn.getMotherNatureMaxAllowedMovements());
	}

	public GameDTO gameToDTO(Game game){
		if (game == null) return new GameDTO(0, false, 0, null, null, null, null, null, null, null, null, null, null, null);

		PlayerDTO currentPlayer = playerToDTO(game.getCurrentPlayer());

		HashMap<String, DashboardDTO> dashboards = new HashMap<>();
		game.getPlayerHashMap().forEach((nickname, player) -> dashboards.put(nickname, dashboardToDTO(player.getDashboard())));

		HashMap<String, String> professors = new HashMap<>();
		game.getProfessorsHashMap().forEach((color, player) -> {
			if(player == null)
				professors.put(color.name(), null);
			else
				professors.put(color.name(), player.getNickname());
		});

		HashMap<String, Integer> coins = new HashMap<>();
		game.getPlayersNicknames().forEach((nickname) -> coins.put(nickname, game.getPlayerCoins(nickname)));

		HashMap<String, String> towerColor = new HashMap<>();
		game.getPlayersNicknames().forEach((nickname) -> towerColor.put(nickname, game.getPlayerHashMap().get(nickname).getColor().name()));

		HashMap<String, AssistantCard> playedCards = game.getTurn().getPlayedCards();
		HashMap<String, AssistantCardDTO> playedCardsDTO = new HashMap<>();
		playedCards.forEach((player, card) -> playedCardsDTO.put(player, assistantCardToDTO(card)));

		return new GameDTO(game.getNumberOfPlayers(), game.isExpertMode(), game.getMotherNature().getCurrentPosition(),
				currentPlayer, game.getPlayersNicknames(), dashboards, coins, towerColor, cloudListToDTO(game.getCloudsList()),
				professors, islandListToDTO(game.getIslandsList()), characterCardListToDTO(game.getCharacterCardsList()),
				turnToDTO(game.getTurn()), playedCardsDTO);
	}

}