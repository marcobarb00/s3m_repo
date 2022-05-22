package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;

import java.util.HashMap;

public class PutStudentOnIslandOperation extends Operation{
	private final int islandPosition;
	private final PawnColor studentColor;

	public PutStudentOnIslandOperation(Game game, PlayerController playerController,
									   int islandPosition, PawnColor studentColor){
		super(game, playerController);
		this.islandPosition = islandPosition;
		this.studentColor = studentColor;
	}

	/**
	 * checks if the arguments of the operation are valid, if so the game put the student on the island
	 */
	@Override
	public void executeOperation() throws PlayerNotInListException, IncorrectOperationException{
		//check null
		boolean checkArgs = studentColor != null && game != null && playerController != null;
		if(!checkArgs) throw new IncorrectOperationException("Invalid arguments");

		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList) throw new PlayerNotInListException();

		//check if student can be moved
		checkMovableStudent();

		//Checks if there are the selected students in entrance
		searchStudentsInEntrance();

		boolean checkIsland = 0 <= islandPosition && islandPosition < game.getIslandsList().size();
		if(!checkIsland) throw new IncorrectOperationException("Incorrect island value");

		game.putStudentOnIslands(playerController.getNickname(), islandPosition, studentColor);
	}

	private void searchStudentsInEntrance() throws IncorrectOperationException{
		Player player = game.getPlayerHashMap().get(playerController.getNickname());
		HashMap<PawnColor, Integer> entrance = player.getDashboard().getEntrance();

		//Check if at least one student of that color is present in hall
		boolean studentInEntrance = entrance.get(studentColor) > 0;
		if(!studentInEntrance)
			throw new IncorrectOperationException("Student not in entrance");
	}

}
