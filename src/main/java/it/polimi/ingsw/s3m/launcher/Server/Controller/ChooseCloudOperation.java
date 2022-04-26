package it.polimi.ingsw.s3m.launcher.Server.Controller;
import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.*;
import java.util.ArrayList;

public class ChooseCloudOperation extends Operation{
    Player nickPlayer;
    int cloudPosition;

    public ChooseCloudOperation(Game game, Player nickPlayer, int cloudPosition){
        super(game);
        this.nickPlayer =  nickPlayer;
        this.cloudPosition = cloudPosition;
    }

    @Override
    public void executeOperation() throws PlayerNotInListException, CloudNotInListException {
        ArrayList<Player> playersList = super.game.getPlayersList();
        ArrayList<Cloud> cloudsList = super.game.getCloudsList();

        boolean nickPlayerInList = playersList.contains(nickPlayer);
        if(!nickPlayerInList){
            throw new PlayerNotInListException();
        }

        boolean cloudInList =   0 <= cloudPosition && cloudPosition < cloudsList.size();
        if(!cloudInList){
            throw new CloudNotInListException();
        }

        if(nickPlayerInList && cloudInList){
            //TODO complete after model merge into master
            //super.game.chooseCloud(nickPlayer, cloudPosition);
        }
    }
}
