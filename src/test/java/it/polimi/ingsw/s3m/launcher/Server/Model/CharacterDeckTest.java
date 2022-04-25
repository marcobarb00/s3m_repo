package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharacterDeckTest {

    @Test
    void drawThreeCharacterCards() {
        CharacterDeck characterDeck = new CharacterDeck();
        ArrayList<CharacterCard> extractedCards = new ArrayList<>();
        assertEquals(0, extractedCards.size());
        assertEquals(6, characterDeck.getDeckCards().size());
        extractedCards = characterDeck.drawThreeCharacterCards();
        assertEquals(3, characterDeck.getDeckCards().size());
        assertEquals(3, extractedCards.size());
        for (int i = 0; i < extractedCards.size(); i++) {
            System.out.println(extractedCards.get(i).getName());
        }
    }
}