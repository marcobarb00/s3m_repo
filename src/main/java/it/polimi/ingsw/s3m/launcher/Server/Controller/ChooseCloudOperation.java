package it.polimi.ingsw.s3m.launcher.Server.Controller;
import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.*;
import java.util.ArrayList;

//DONE
public class ChooseCloudOperation extends Operation{
    private PlayerController playerController;
    private int cloudPosition;

    //Position is meant as arraylist index (0 to cloudList.size)
    public ChooseCloudOperation(Game game, PlayerController playerController, int cloudPosition){
        super(game);
        this.playerController =  playerController;
        this.cloudPosition = cloudPosition;
    }

    /**
     * Controls if chooseCloud method has safe parameters
     * @throws PlayerNotInListException
     * @throws CloudNotInListException
     */
    @Override
    public void executeOperation() throws PlayerNotInListException, CloudNotInListException {
        ArrayList<String> playersList = super.game.getPlayersNicknames();
        ArrayList<Cloud> cloudsList = super.game.getCloudsList();

        boolean playerControllerInList = playersList.contains(playerController.getNickname());
        if(!playerControllerInList){
            throw new PlayerNotInListException();
        }

        boolean cloudInList =   0 <= cloudPosition && cloudPosition < cloudsList.size();
        if(!cloudInList){
            throw new CloudNotInListException();
        }

        if(playerControllerInList && cloudInList){
            super.game.chooseCloud(playerController.getNickname(), cloudPosition);
        }
    }
}
