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
	 * @param game game in which a cloud is chosen
	 * @param playerController player choosing a cloud
	 * @param cloudPosition position of the chosen cloud
	 */
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
