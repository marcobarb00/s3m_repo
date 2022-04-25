package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class CharacterDeck {
    private ArrayList<CharacterCard> deckCards;

    public CharacterDeck() {
        deckCards = new ArrayList<>();
        deckCards.add(new Centaur());
        deckCards.add(new Jester());
        deckCards.add(new Knight());
        deckCards.add(new MagicPostman());
        deckCards.add(new Minstrel());
        deckCards.add(new Mushroomer());
    }

    public ArrayList<CharacterCard> drawThreeCharacterCards() {
        ArrayList<CharacterCard> playableCharacterCards = new ArrayList<>();
        while(playableCharacterCards.size() != 3) {
            int extractedNumber = (int) (Math.random()*(deckCards.size()));
            playableCharacterCards.add(deckCards.get(extractedNumber));
            deckCards.remove(extractedNumber);
        }
        return playableCharacterCards;
    }

    public ArrayList<CharacterCard> getDeckCards() { return deckCards; }
}
