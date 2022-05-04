package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.*;
import it.polimi.ingsw.s3m.launcher.Server.Message.*;

public class CLIView extends View{
	ClientCLI client;

	public CLIView(ClientCLI client){
		this.client = client;
	}

	@Override
	public void login(LoginMessage loginMessage){
		client.setMessage(new LoginCLI(loginMessage));
	}

	@Override
	public void newRoom(NewRoomMessage newRoomMessage){
		client.setMessage(new NewRoomCLI(newRoomMessage));
	}

	@Override
	public void enterRoom(EnterRoomMessage enterRoomMessage){
		client.setMessage(new EnterRoomCLI(enterRoomMessage));
	}

	@Override
	public void notification(NotificationMessage notification){
		client.setMessage(new NotificationCLI(notification));
	}

	@Override
	public void updateGameState(GameStateMessage gameState){
		client.setMessage(new GameStateCLI(gameState));
	}

	@Override
	public void planningPhase(PlanningPhaseMessage planningPhaseMessage){
		client.setMessage(new PlanningPhaseCLI(planningPhaseMessage));
	}

	@Override
	public void moveStudentsPhase(MoveStudentsPhaseMessage moveStudentsPhaseMessage){
		client.setMessage(new MoveStudentsPhaseCLI(moveStudentsPhaseMessage));
	}

	@Override
	public void motherNaturePhase(MotherNaturePhaseMessage motherNaturePhaseMessage){
		client.setMessage(new MotherNaturePhaseCLI(motherNaturePhaseMessage));
	}

	@Override
	public void chooseCloudPhase(ChooseCloudPhaseMessage chooseCloudPhaseMessage){
		client.setMessage(new ChooseCloudPhaseCLI(chooseCloudPhaseMessage));
	}
}
