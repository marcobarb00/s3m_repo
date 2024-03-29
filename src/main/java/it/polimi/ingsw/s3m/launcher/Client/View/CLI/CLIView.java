package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
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
	public void planningPhase(PlanningPhaseMessage planningPhaseMessage){
		client.setMessage(new PlanningPhaseCLI(planningPhaseMessage));
	}

	@Override
	public void moveStudentsPhase(StudentsPhaseMessage moveStudentsPhaseMessage){
		client.setMessage(new MoveStudentsPhaseCLI(moveStudentsPhaseMessage));
	}

	@Override
	public void playCharacterCard(PlayCharacterCardMessage playCharacterCardMessage){
		client.setMessage(new PlayCharacterCardCLI(playCharacterCardMessage));
	}

	@Override
	public void putStudentOnTable(PutStudentOnTableMessage putStudentOnTableMessage){
		client.setMessage(new PutStudentOnTableCLI(putStudentOnTableMessage));
	}

	@Override
	public void putStudentOnIsland(PutStudentOnIslandMessage putStudentOnIslandMessage){
		client.setMessage(new PutStudentOnIslandCLI(putStudentOnIslandMessage));
	}

	@Override
	public void motherNaturePhase(MotherNaturePhaseMessage motherNaturePhaseMessage){
		client.setMessage(new MotherNaturePhaseCLI(motherNaturePhaseMessage));
	}

	@Override
	public void chooseCloudPhase(CloudPhaseMessage cloudPhaseMessage){
		client.setMessage(new CloudPhaseCLI(cloudPhaseMessage));
	}

	@Override
	public void moveMotherNature(MoveMotherNatureMessage moveMotherNatureMessage){
		client.setMessage(new MoveMotherNatureCLI(moveMotherNatureMessage));
	}
}
