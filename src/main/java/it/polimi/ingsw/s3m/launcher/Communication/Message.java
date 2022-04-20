package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

import java.io.Serializable;

public interface Message extends Serializable{
	Message execute(View view);
}
