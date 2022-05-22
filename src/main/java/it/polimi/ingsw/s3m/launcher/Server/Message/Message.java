package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

import java.io.Serializable;

public interface Message extends Serializable{
	void apply(View view);
}
