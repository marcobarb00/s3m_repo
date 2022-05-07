package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.AssistantCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.Player;

import java.util.ArrayList;

//Done
public class PlayAssistantCardOperation extends Operation{
    private int assistantCardPosition;

    public PlayAssistantCardOperation(Game game, PlayerController playerController, int assistantCardPosition) {
        super(game, playerController);
        this.assistantCardPosition = assistantCardPosition;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, IllegalArgumentException {
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        ArrayList<AssistantCard> hand = game.getPlayerHand(playerController.getNickname());
        boolean checkAssistantCard = 0 <= assistantCardPosition && assistantCardPosition < hand.size();
        if(!checkAssistantCard){
            throw new IllegalArgumentException("Incorrect card position value");
        }

        //check if already played in turn
        boolean checkCard = checkPlayableCard();
        if(!checkCard){
            throw new IllegalArgumentException("AssistantCard already played");
        }

        game.playAssistantCard(playerController.getNickname(), assistantCardPosition);
    }

    private boolean checkPlayableCard(){
        ArrayList<AssistantCard> cardsPlayedInTurn = game.getTurnPlayedCards();
        Player player = game.getPlayerHashMap().get(playerController.getNickname());
        String handCardType = player.getHand().get(assistantCardPosition).getType();

        return cardsPlayedInTurn.stream().map(AssistantCard::getType).
                noneMatch(type -> type.equals(handCardType));
    }
}
