package it.polimi.ingsw.s3m.launcher.Server.Model;

public abstract class CharacterCard {
    private String name;
    private int cost;

    public abstract void activateEffect();

    public String getName() { return name; }
    public int getCost() { return cost; }
}