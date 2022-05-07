package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class MotherNatureResponse implements Response {
    private boolean characterCardActivated;
    private int characterCardPosition;
    private int motherNatureMoves;

    public MotherNatureResponse(boolean characterCardActivated, int characterCardPosition, int motherNatureMoves) {
        this.characterCardActivated = characterCardActivated;
        this.characterCardPosition = characterCardPosition;
        this.motherNatureMoves = motherNatureMoves;
    }

    public boolean isCharacterCardActivated() {
        return characterCardActivated;
    }
    public int getCharacterCardPosition() {
        return characterCardPosition;
    }
    public int getMotherNatureMoves() {
        return motherNatureMoves;
    }
}
