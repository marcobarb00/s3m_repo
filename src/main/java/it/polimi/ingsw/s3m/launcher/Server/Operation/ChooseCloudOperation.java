package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Cloud;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

//DONE
public class ChooseCloudOperation extends Operation{
	private int cloudPosition;

	//Position is meant as arraylist index (0 to cloudList.size)
	public ChooseCloudOperation(Game game, PlayerController playerController, int cloudPosition){
		super(game, playerController);
		this.cloudPosition = cloudPosition;
	}

	/**
	 * Controls if chooseCloud method has safe parameters
	 *
	 * @throws PlayerNotInListException
	 * @throws CloudNotInListException
	 */
	@Override
	public void executeOperation() throws PlayerNotInListException, CloudNotInListException{
		ArrayList<Cloud> cloudsList = super.game.getCloudsList();

		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList){
			throw new PlayerNotInListException();
		}

		boolean cloudInList = 0 <= cloudPosition && cloudPosition < cloudsList.size();
		if(!cloudInList){
			throw new CloudNotInListException();
		}

		if(playerControllerInList && cloudInList){
			super.game.chooseCloud(playerController.getNickname(), cloudPosition);
		}
	}
}
