package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class ExpertModeInitializer {
    private Game game;

    public ExpertModeInitializer (Game game) {
        this.game = game;
        playersUpdate();
        // Character cards
        game.getCharacterCardsList().add(new Centaur());
        game.getCharacterCardsList().add(new Jester());
        game.getCharacterCardsList().add(new Knight());
        game.getCharacterCardsList().add(new MagicPostman());
        game.getCharacterCardsList().add(new Minstrel());
        game.getCharacterCardsList().add(new Mushroomer());
        characterCardsSetup();
    }

    public void playersUpdate() {
        for (Player player : game.getPlayerHashMap().values()) {
            player = new ExpertPlayer(player);
        }
    }

    public void characterCardsSetup() {
        game.drawThreeCharacterCards();
        for (CharacterCard characterCard : game.getCharacterCardsList()) {
            if (characterCard instanceof Jester) {
                game.initializeJesterStudents((Jester) characterCard);
            }
        }
    }
}
