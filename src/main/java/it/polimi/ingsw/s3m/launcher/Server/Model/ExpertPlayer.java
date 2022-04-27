package it.polimi.ingsw.s3m.launcher.Server.Model;

public class ExpertPlayer extends Player {
    private int coins;

    public ExpertPlayer(Player player) {
        super(player);
        this.coins = 1;
    }

    public void addCoins (int earnCoins) {
        coins += earnCoins;
    }

    public void removeCoins (int usedCoins) {
        coins -= usedCoins;
    }

    // GETTER
    public int getCoins() { return coins; }
}
