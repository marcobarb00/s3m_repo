package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.HashMap;

public class CentaurComputeDominance implements ComputeDominanceStrategy {
    @Override
    public Player computeDominance(Island island, HashMap<PawnColor, Player> professors) {
        HashMap<Player, Integer> playersInfluence = new HashMap<>();
        Player dominatingPlayer = null;
        int maxInfluence = 0;

        for (Player player : professors.values())
            if (player != null) playersInfluence.putIfAbsent(player, 0);

        for (PawnColor color : PawnColor.values()) {
            Player currentPlayer = professors.get(color);
            if (currentPlayer != null)
                playersInfluence.replace(currentPlayer,
                        playersInfluence.get(currentPlayer) + island.getStudentsPerColor(color));
        }

        Player islandDominator = island.getDominator();

        if (!playersInfluence.keySet().isEmpty()) {
            for (Player player : playersInfluence.keySet()) {
                int singlePlayerInfluence = playersInfluence.get(player);
                if (singlePlayerInfluence > maxInfluence) {
                    dominatingPlayer = player;
                    maxInfluence = singlePlayerInfluence;
                } else if (singlePlayerInfluence == maxInfluence)
                    dominatingPlayer = islandDominator;
            }
        }

        return dominatingPlayer;
    }
}
