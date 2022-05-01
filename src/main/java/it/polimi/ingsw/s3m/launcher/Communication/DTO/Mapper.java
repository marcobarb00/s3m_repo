package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import it.polimi.ingsw.s3m.launcher.Server.Model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Mapper{
	public AssistantCardDTO assistantCardToDTO(AssistantCard assistantCard){
		return new AssistantCardDTO(assistantCard.getType(), assistantCard.getValue(), assistantCard.getMovements());
	}

	public ArrayList<AssistantCardDTO> handToDTO(ArrayList<AssistantCard> hand){
		ArrayList<AssistantCardDTO> assistantCardDTOList = new ArrayList<>();
		for(AssistantCard assistantCard : hand){
			assistantCardDTOList.add(assistantCardToDTO(assistantCard));
		}

		return assistantCardDTOList;
	}

	public DashboardDTO dashboardToDTO(Dashboard dashboard){
		ArrayList<String> hall = dashboard.getHall().stream()
				.map(Student::getColor)
				.map(Enum::name)
				.collect(Collectors.toCollection(ArrayList::new));

		HashMap<String, Integer> tables = new HashMap<>();
		dashboard.getTables().forEach((color, value) -> tables.put(color.name(), value));

		return new DashboardDTO(hall, tables, dashboard.getNumberOfTowers());
	}

	public PlayerDTO playerToDTO(Player player){
		return new PlayerDTO(player.getNickname(), player.getColor().name(), dashboardToDTO(player.getDashboard()), handToDTO(player.getHand()), assistantCardToDTO(player.getLastCardPlayed()));
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

	public GameDTO gameToDTO(Game game){
		HashMap<String, PlayerDTO> playerList = playerHashMapToDTO(game.getPlayerHashMap());

		HashMap<String, PlayerDTO> professors = new HashMap<>();

		//professors

		return new GameDTO(game.isExpertMode(), game.getMotherNature().getCurrentPosition(), playerList, cloudListToDTO(game.getCloudsList()), professors, islandListToDTO(game.getIslandsList()), characterCardListToDTO(game.getCharacterCardsList()));
	}
}