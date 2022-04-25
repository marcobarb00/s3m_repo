package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.*;

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
	public void operationChoice(OperationChoiceMessage operationChoiceMessage){
		client.setMessage(new OperationChoiceCLI(operationChoiceMessage));
	}

	@Override
	public void playAssistantCard(PlayAssistantCardMessage playAssistantCardMessage){
		client.setMessage(new PlayAssistantCardCLI(playAssistantCardMessage));
	}
}
