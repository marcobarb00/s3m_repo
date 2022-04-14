package it.polimi.ingsw.s3m.launcher.Communication;

public class Login implements Message{
	private String nickname;

	public Login(String nickname){
		this.nickname = nickname;
	}

	public String getNickname(){
		return nickname;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}
}
