package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

import java.util.ArrayList;
import java.util.Set;

public class LoginMessage implements Message{
	@Override
	public void apply(View view){
		view.login(this);
	}
}
