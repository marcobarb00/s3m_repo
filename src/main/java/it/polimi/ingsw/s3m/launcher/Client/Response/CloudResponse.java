package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class CloudResponse implements Response{
	private int cloud;

	public CloudResponse(int cloud){
		this.cloud = cloud;
	}

	public int getCloud(){
		return cloud;
	}
}
