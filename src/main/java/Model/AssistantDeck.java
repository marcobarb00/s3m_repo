/*
* this class is thought to be mutable, every player gets a deck object
*/
package Model;

import java.util.*;
import java.time.*;

public class AssistantDeck{

    //Arryalist for cards max 10 cards
    private ArrayList<AssistantEnum> cardList;


    //Constructor for card generation
    public AssistantDeck(){
        this.cardList = new ArrayList<AssistantEnum>(
                Arrays.asList(AssistantEnum.EAGLE, AssistantEnum.DOG, AssistantEnum.ELEPHANT,
                        AssistantEnum.CAT, AssistantEnum.CHEETAH, AssistantEnum.LIZARD,
                        AssistantEnum.OCTOPUS, AssistantEnum.OSTRICH, AssistantEnum.TURTLE, AssistantEnum.FOX)
        );
    }





}
