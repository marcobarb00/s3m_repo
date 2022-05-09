package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PlayCharacterCardResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlayCharacterCardMessage;

import java.util.ArrayList;

public class PlayCharacterCardCLI extends MessageCLI{
	private GameDTO gameState;

	public PlayCharacterCardCLI(PlayCharacterCardMessage playCharacterCardMessage){
		this.gameState = playCharacterCardMessage.getGameState();
	}

	@Override
	public Response execute(){
		ArrayList<CharacterCardDTO> characterCardDTOList = gameState.getCharacterCards();

		System.out.println("choose a character card:");
		int cardsNumber = characterCardDTOList.size();
		for (int i = 0; i < cardsNumber; i++) {
			CharacterCardDTO card = characterCardDTOList.get(i);
			System.out.println((i+1) + ") " + card.getName() + " cost: " + card.getCost());
		}

		int characterCardPosition = getOperation(characterCardDTOList.size()) - 1;
		return new PlayCharacterCardResponse(characterCardPosition);
	}
}
