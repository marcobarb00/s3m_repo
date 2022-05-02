package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.AssistantCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

//Done
public class PlayAssistantCardOperation extends Operation{
    private int assistantCardPosition;

    public PlayAssistantCardOperation(Game game, PlayerController playerController, int assistantCardPosition) {
        super(game, playerController);
        this.assistantCardPosition = assistantCardPosition;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, NotExpertModeException {
        boolean playerControllerInList = checkNickname();
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        ArrayList<AssistantCard> hand = game.getPlayerHand(playerController.getNickname());
        boolean checkAssistantCard = 0 <= assistantCardPosition && assistantCardPosition < hand.size();

        if(!checkAssistantCard){
            throw new IllegalArgumentException("Incorrect card position value");
        }

        super.game.playAssistantCard(playerController.getNickname(), assistantCardPosition);
    }
}
