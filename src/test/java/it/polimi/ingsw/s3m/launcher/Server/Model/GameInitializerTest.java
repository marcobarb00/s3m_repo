package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.CharacterCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.Jester;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameInitializerTest {

    @Test
    void characterCardsSetup() {
        ArrayList<String> playersNickname = new ArrayList<>();
        playersNickname.add("User1");
        playersNickname.add("User2");
        playersNickname.add("User3");
        Game game = null;
        try{
            game = new Game(playersNickname, true);
        }catch(EmptyBagException e){
            e.printStackTrace();
        }
        for (CharacterCard characterCard : game.getCharacterCardsList()) {
            if (characterCard instanceof Jester) {
                int sumOfStudents = 0;
                for (PawnColor color : PawnColor.values()) {
                    sumOfStudents += ((Jester) characterCard).getStudentsOnCard().get(color);
                }
                assertEquals(6, sumOfStudents);
                for (PawnColor color : PawnColor.values()) {
                    System.out.println(((Jester) characterCard).getStudentsOnCard().get(color));
                }
            }
        }
    }
}