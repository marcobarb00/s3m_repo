package it.polimi.ingsw.s3m.launcher.Communication;


public class ErrorMessage implements Message{
	private String message;

	public ErrorMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
	public void apply(View view){

	}
}
