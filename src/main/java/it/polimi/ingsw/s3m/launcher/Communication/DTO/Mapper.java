package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import it.polimi.ingsw.s3m.launcher.Server.Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Mapper{
	public PawnColor stringToColor(String colorString){
		switch(colorString){
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

	public ArrayList<PawnColor> StringListToColor(ArrayList<String> colorStringList){
		ArrayList<PawnColor> colorList = new ArrayList<>();
		colorStringList.forEach(colorString -> colorList.add(stringToColor(colorString)));
		return colorList;
	}

	public AssistantCardDTO assistantCardToDTO(AssistantCard assistantCard){
		if(assistantCard == null){
			return new AssistantCardDTO(null, 0, 0);
		}
		return new AssistantCardDTO(assistantCard.getType(), assistantCard.getValue(), assistantCard.getMovements());
	}

	public ArrayList<AssistantCardDTO> assistantCardListToDTO(ArrayList<AssistantCard> assistantCardList){
		ArrayList<AssistantCardDTO> assistantCardDTOList = new ArrayList<>();
		for(AssistantCard assistantCard : assistantCardList){
			assistantCardDTOList.add(assistantCardToDTO(assistantCard));
		}

		return assistantCardDTOList;
	}

	public DashboardDTO dashboardToDTO(Dashboard dashboard){
		HashMap<String, Integer> entrance = new HashMap<>();
		dashboard.getEntrance().forEach((color, value) -> entrance.put(color.name(), value));

		HashMap<String, Integer> tables = new HashMap<>();
		dashboard.getTables().forEach((color, value) -> tables.put(color.name(), value));

		return new DashboardDTO(entrance, tables, dashboard.getNumberOfTowers());
	}

	public ArrayList<DashboardDTO> dashboardListToDTO(ArrayList<Dashboard> dashboardList){
		ArrayList<DashboardDTO> dashboardDTOList = new ArrayList<>();
		for(Dashboard dashboard : dashboardList){
			dashboardDTOList.add(dashboardToDTO(dashboard));
		}

		return dashboardDTOList;
	}

	public PlayerDTO playerToDTO(Player player){
		if(player == null){
			return new PlayerDTO("", "", null, null, null);
		}
		return new PlayerDTO(player.getNickname(), player.getColor().name(), dashboardToDTO(player.getDashboard()), assistantCardListToDTO(player.getHand()), assistantCardToDTO(player.getLastPlayedCard()));
	}

	public ArrayList<PlayerDTO> playerListToDTO(ArrayList<Player> playerList){
		ArrayList<PlayerDTO> playerDTOList = new ArrayList<>();
		for(Player player : playerList){
			playerDTOList.add(playerToDTO(player));
		}

		return playerDTOList;
	}

	public HashMap<String, PlayerDTO> playerHashMapToDTO(HashMap<String, Player> playerHashMap){
		HashMap<String, PlayerDTO> players = new HashMap<>();
		playerHashMap.forEach((nickname, player) -> players.put(nickname, playerToDTO(player)));

		return players;
	}

	public IslandDTO islandToDTO(Island island){
		HashMap<String, Integer> students = new HashMap<>();
		for(PawnColor color : PawnColor.values()){
			students.put(color.name(), island.getStudents().get(color));
		}

		if(island.getDominator() == null){
			return new IslandDTO(students, "", 0);
		}
		return new IslandDTO(students, island.getDominator().getColor().name(), island.getNumberOfTowers());
	}

	public ArrayList<IslandDTO> islandListToDTO(ArrayList<Island> islandsList){
		ArrayList<IslandDTO> islandDTOList = new ArrayList<>();
		for(Island island : islandsList){
			islandDTOList.add(islandToDTO(island));
		}

		return islandDTOList;
	}

	public CharacterCardDTO characterCardToDTO(CharacterCard characterCard){
		return new CharacterCardDTO(characterCard.getName(), characterCard.getCost());
	}

	public ArrayList<CharacterCardDTO> characterCardListToDTO(ArrayList<CharacterCard> characterCardList){
		ArrayList<CharacterCardDTO> characterCardDTOList = new ArrayList<>();
		for(CharacterCard island : characterCardList){
			characterCardDTOList.add(characterCardToDTO(island));
		}

		return characterCardDTOList;
	}

	public CloudDTO cloudToDTO(Cloud cloud){
		ArrayList<String> students = cloud.getStudents().stream()
				.map(Student::getColor)
				.map(Enum::name)
				.collect(Collectors.toCollection(ArrayList::new));

		return new CloudDTO(students);
	}

	public ArrayList<CloudDTO> cloudListToDTO(ArrayList<Cloud> cloudList){
		ArrayList<CloudDTO> cloudDTOList = new ArrayList<>();
		for(Cloud cloud : cloudList){
			cloudDTOList.add(cloudToDTO(cloud));
		}

		return cloudDTOList;
	}

	public TurnDTO turnToDTO(Turn turn){
		ArrayList<AssistantCardDTO> playedCards = new ArrayList<>();
		turn.getPlayedCards().forEach((nickname, card) -> playedCards.add(assistantCardToDTO(card)));

		return new TurnDTO(turn.getFirstPlayerNickname(), turn.getCurrentPlayerNickname(), turn.getPhaseName(), playedCards, turn.isActivatedCharacterCard());
	}

	public GameDTO gameToDTO(Game game){
		PlayerDTO currentPlayer = playerToDTO(game.getCurrentPlayer());

		HashMap<String, DashboardDTO> dashboards = new HashMap<>();
		game.getPlayerHashMap().forEach((nickname, player) -> dashboards.put(nickname, dashboardToDTO(player.getDashboard())));

		HashMap<String, PlayerDTO> professors = new HashMap<>();
		game.getProfessorsHashMap().forEach((color, player) -> professors.put(color.name(), playerToDTO(player)));

		return new GameDTO(game.getNumberOfPlayers(), game.isExpertMode(), game.getMotherNature().getCurrentPosition(), currentPlayer , game.getPlayersNicknames(), dashboards, cloudListToDTO(game.getCloudsList()), professors, islandListToDTO(game.getIslandsList()), characterCardListToDTO(game.getCharacterCardsList()), turnToDTO(game.getTurn()));
	}
}