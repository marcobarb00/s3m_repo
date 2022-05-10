package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Student;

import java.util.HashMap;

public class PutStudentOnTableOperation extends Operation{
	private PawnColor studentColor;

	public PutStudentOnTableOperation(Game game, PlayerController playerController, PawnColor studentColor){
		super(game, playerController);
		this.studentColor = studentColor;
	}

	@Override
	public void executeOperation() throws PlayerNotInListException, IllegalArgumentException, IncorrectOperationException {
		boolean checkArgs = game != null && playerController != null && studentColor != null;
		if(!checkArgs){
			throw new IncorrectOperationException("Invalid arguments");
		}

		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList){
			throw new PlayerNotInListException();
		}

		//check movable student
		checkMovableStudent();

		//Checking students in hall
		searchStudentsInEntrance();

		game.putStudentOnTables(playerController.getNickname(), new Student(studentColor));
	}

	private void searchStudentsInEntrance() throws IncorrectOperationException {
		Player player = game.getPlayerHashMap().get(playerController.getNickname());
		HashMap<PawnColor, Integer> entrance = player.getDashboard().getEntrance();

		//Check if at least one student of that color is present in entrance
		boolean studentInEntrance = entrance.get(studentColor) > 0;
		if(!studentInEntrance){
			throw new IncorrectOperationException("Student not in entrance");
		}
	}
}
