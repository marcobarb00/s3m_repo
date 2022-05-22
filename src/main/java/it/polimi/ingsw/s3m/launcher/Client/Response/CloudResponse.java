package it.polimi.ingsw.s3m.launcher.Client.Response;

public class CloudResponse implements Response{
	private final int cloud;

	public CloudResponse(int cloud){
		this.cloud = cloud;
	}

	public int getCloud(){
		return cloud;
	}
}
