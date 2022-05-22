package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Cloud;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import java.util.ArrayList;

//DONE
public class ChooseCloudOperation extends Operation{
	private final int cloudPosition;

	/**
	 * Constructor used to create an operation of choosing a cloud based on player's response
	 * @param game the game state in which the player is in
	 * @param playerController the player who's executing the operation
	 * @param cloudPosition position of the chosen cloud
	 */
	public ChooseCloudOperation(Game game, PlayerController playerController, int cloudPosition){
		super(game, playerController);
		this.cloudPosition = cloudPosition;
	}

	/**
	 * checks if the arguments of the operation are valid, if so the game give the students on the cloud to the player
	 */
	@Override
	public void executeOperation() throws PlayerNotInListException, CloudNotInListException, IncorrectOperationException {
		//check args
		boolean checkArgs = game != null && playerController != null;
		if(!checkArgs) throw new IncorrectOperationException("Invalid arguments");

		ArrayList<Cloud> cloudsList = super.game.getCloudsList();

		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList) throw new PlayerNotInListException();

		boolean cloudInList = 0 <= cloudPosition && cloudPosition < cloudsList.size();
		if(!cloudInList) throw new CloudNotInListException();

		super.game.chooseCloud(playerController.getNickname(), cloudPosition);
	}
}
