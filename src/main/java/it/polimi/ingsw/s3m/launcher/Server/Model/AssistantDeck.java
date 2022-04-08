/*
* this class is thought to be mutable, every player gets a deck object
*/
package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.*;

public class AssistantDeck{

    /**
     * Arraylist for cards max 10 cards
     */
    private ArrayList<AssistantCard> cardList;

    /**
     * Constructor. Initializes arraylist with all the cards
     */
    public AssistantDeck(){
        this.cardList = new ArrayList<>(
                Arrays.asList(AssistantCard.EAGLE, AssistantCard.DOG, AssistantCard.ELEPHANT,
                        AssistantCard.CAT, AssistantCard.CHEETAH, AssistantCard.LIZARD,
                        AssistantCard.OCTOPUS, AssistantCard.OSTRICH, AssistantCard.TURTLE, AssistantCard.FOX)
        );
    }


}
