package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.HashMap;

public class StandardComputeDominance implements ComputeDominanceStrategy {
    HashMap<Player, Integer> playersInfluence = new HashMap<>();
    @Override
    public Player computeDominance(Island island, HashMap<PawnColor, Player> professors) {
        int maxInfluence = 0;
        Player dominatingPlayer = null;
        for (Player player : professors.values()) playersInfluence.putIfAbsent(player, 0);
        for (PawnColor color : PawnColor.values()) {
            Player currentPlayer = professors.get(color);
            if (currentPlayer != null) {
                playersInfluence.replace(currentPlayer,
                        playersInfluence.get(currentPlayer) + island.getStudentsPerColor(color));
            }
        }
        Player islandDominator = island.getDominator();
        int islandNumberOfTower = island.getNumberOfTowers();
        playersInfluence.replace(islandDominator, playersInfluence.get(islandDominator) + islandNumberOfTower);
        for (Player player : playersInfluence.keySet()) {
            int singlePlayerInfluence = playersInfluence.get(player);
            if (singlePlayerInfluence > maxInfluence) {
                dominatingPlayer = player;
                maxInfluence = singlePlayerInfluence;
            }
        }
        return dominatingPlayer;
    }
}
