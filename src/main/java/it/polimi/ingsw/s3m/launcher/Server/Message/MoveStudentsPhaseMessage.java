package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

import java.util.ArrayList;

public class MoveStudentsPhaseMessage implements Message{
	private ArrayList<CharacterCardDTO> characterCardDTOList;
	private boolean expertMode;
	private boolean threePlayerMode;

	public MoveStudentsPhaseMessage(ArrayList<CharacterCardDTO> characterCardDTOList, boolean expertMode, boolean threePlayerMode){
		this.characterCardDTOList = characterCardDTOList;
		this.expertMode = expertMode;
		this.threePlayerMode = threePlayerMode;
	}

	public ArrayList<CharacterCardDTO> getCharacterCardDTOList(){
		return characterCardDTOList;
	}

	public boolean isExpertMode(){
		return expertMode;
	}

	public boolean isThreePlayerMode(){
		return threePlayerMode;
	}

	@Override
	public void apply(View view){
		view.moveStudentsPhase(this);
	}
}
