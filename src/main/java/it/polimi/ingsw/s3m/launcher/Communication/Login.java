package it.polimi.ingsw.s3m.launcher.Communication;

public class Login implements Message{
	private String nickname;
	private boolean successful;
	/**
	 * message is a string from the server that tells if the login is not successful and why
	 */
	private String message;

	public Login(String nickname){
		this.nickname = nickname;
	}

	public String getNickname(){
		return nickname;
	}

	public boolean isSuccessful(){
		return successful;
	}

	public void setSuccessful(boolean successful){
		this.successful = successful;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}
