package it.polimi.ingsw.s3m.launcher.DTOs;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerDTO implements Serializable{
	private final String nickname;
	private final String color;
	private final DashboardDTO dashboard;
	private final ArrayList<AssistantCardDTO> hand;
	private final AssistantCardDTO lastCardPlayed;

	public PlayerDTO(String nickname, String color, DashboardDTO dashboard, ArrayList<AssistantCardDTO> hand, AssistantCardDTO lastCardPlayed){
		this.nickname = nickname;
		this.color = color;
		this.dashboard = dashboard;
		this.hand = hand;
		this.lastCardPlayed = lastCardPlayed;
	}

	public String getNickname(){
		return nickname;
	}

	public String getColor(){
		return color;
	}

	public DashboardDTO getDashboard(){
		return dashboard;
	}

	public ArrayList<AssistantCardDTO> getHand(){
		return hand;
	}

	public AssistantCardDTO getLastCardPlayed(){
		return lastCardPlayed;
	}
}
