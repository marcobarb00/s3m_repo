package it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance;

import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Island;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;

import java.util.HashMap;

public class MushroomerComputeDominance implements ComputeDominanceStrategy {
	private PawnColor chosenColor;

	/**
	 * Method used to calculate the dominance of an island without counting
	 * the students of a certain chosen color
	 *
	 * @param island     island in which the computeDominance have to be executed
	 * @param professors list of Game professors
	 * @return the new player dominating the island
	 */
	@Override
	public Player computeDominance(Island island, HashMap<PawnColor, Player> professors){
		HashMap<Player, Integer> playersInfluence = new HashMap<>();
		Player dominatingPlayer = null;
		int maxInfluence = 0;

		for(Player player : professors.values())
			if(player != null) playersInfluence.putIfAbsent(player, 0);

		for(PawnColor color : PawnColor.values()){
			Player currentPlayer = professors.get(color);
			if(currentPlayer != null && color != chosenColor)
				playersInfluence.replace(currentPlayer,
						playersInfluence.get(currentPlayer) + island.getStudentsPerColor(color));
		}

		Player islandDominator = island.getDominator();
		int islandNumberOfTower = island.getNumberOfTowers();
		if(islandDominator != null)
			playersInfluence.replace(islandDominator, playersInfluence.get(islandDominator) + islandNumberOfTower);

		if(!playersInfluence.keySet().isEmpty()){
			for(Player player : playersInfluence.keySet()){
				int singlePlayerInfluence = playersInfluence.get(player);
				if(singlePlayerInfluence > maxInfluence){
					dominatingPlayer = player;
					maxInfluence = singlePlayerInfluence;
				}else if(singlePlayerInfluence == maxInfluence)
					dominatingPlayer = islandDominator;
			}
		}

		return dominatingPlayer;
	}

	public void setChosenColor(PawnColor chosenColor){
		this.chosenColor = chosenColor;
	}
}
