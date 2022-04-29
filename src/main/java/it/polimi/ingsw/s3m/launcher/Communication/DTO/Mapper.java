package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import it.polimi.ingsw.s3m.launcher.Server.Model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Mapper{
	public AssistantCardDTO assistantCardToDTO(AssistantCard assistantCard){
		return new AssistantCardDTO(assistantCard.getType(), assistantCard.getValue(), assistantCard.getMovements());
	}

	public ArrayList<AssistantCardDTO> handToDTO(ArrayList<AssistantCard> assistantCardsardList){
		ArrayList<AssistantCardDTO> assistantCardDTOList = new ArrayList<>();
		for(AssistantCard assistantCard : assistantCardsardList){
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
		for(PawnColor color : PawnColor.values()){
			tables.put(color.name(), dashboard.getTables().get(color));
		}

		return new DashboardDTO(hall, tables, dashboard.getNumberOfTowers());
	}

	public PlayerDTO playerToDTO(Player player){
		return new PlayerDTO(player.getNickname(), player.getColor().name(), dashboardToDTO(player.getDashboard()), handToDTO(player.getHand()), assistantCardToDTO(player.getLastCardPlayed()));
	}
}
