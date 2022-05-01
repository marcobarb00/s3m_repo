package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.AssistantCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

public class PlayAssistantCardOperation extends Operation{
    private int assistantCardPosition;

    public PlayAssistantCardOperation(Game game, PlayerController playerController, int assistantCardPosition) {
        super(game, playerController);
        this.assistantCardPosition = assistantCardPosition;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, NotExpertModeException {
        ArrayList<String> playersList = super.game.getPlayersNicknames();

        boolean playerControllerInList = playersList.contains(playerController.getNickname());
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }
        boolean checkExpertMode = game.isExpertMode();
        if(!checkExpertMode){
            throw new NotExpertModeException();
        }

        ArrayList<AssistantCard> hand = game.getPlayerHand(playerController.getNickname());
        boolean checkAssistantCard = 0 <= assistantCardPosition && assistantCardPosition < hand.size();

        if(!checkAssistantCard){
            throw new IllegalArgumentException("Card not in list");
        }

        super.game.playAssistantCard(playerController.getNickname(),assistantCardPosition);

    }
}
