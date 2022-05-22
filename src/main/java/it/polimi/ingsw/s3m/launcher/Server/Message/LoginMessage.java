package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class LoginMessage implements Message{
	@Override
	public void apply(View view){
		view.login(this);
	}
}
