package it.polimi.ingsw.s3m.launcher.Server.Model;

public class ActionPhase extends Phase {
    private boolean activatedCharacterCard = false;

    // GETTER
    public boolean isActivatedCharacterCard() { return activatedCharacterCard; }

    // SETTER
    public void setActivatedCharacterCard(boolean activatedCharacterCard) {
        this.activatedCharacterCard = activatedCharacterCard;
    }
}
