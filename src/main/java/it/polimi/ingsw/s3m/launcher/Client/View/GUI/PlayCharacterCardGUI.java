package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.DTOs.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.DTOs.GameDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlayCharacterCardMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PlayCharacterCardGUI{
	@FXML
	ImageView backgroundImage;
	@FXML
	VBox vBox;
	@FXML
	Label cardCost1;
	@FXML
	Label cardCost2;
	@FXML
	Label cardCost3;
	@FXML
	ImageView firstCharacter;
	@FXML
	ImageView secondCharacter;
	@FXML
	ImageView thirdCharacter;
	@FXML
	Button back;

	private ArrayList<CharacterCardDTO> cards;
	private Integer characterCardPosition;

	public void inizialize(PlayCharacterCardMessage playCharacterCardMessage){
		List<ImageView> characterCardList = Arrays.asList(firstCharacter, secondCharacter, thirdCharacter);
		List<Label> costList = Arrays.asList(cardCost1, cardCost2, cardCost3);
		GameDTO gameState = playCharacterCardMessage.getGameState();
		cards = gameState.getCharacterCards();

		for(int i = 0; i < 3; i++){
			CharacterCardDTO currentCard = cards.get(i);
			insertCharacter(characterCardList.get(i), currentCard.getName());
			costList.get(i).setText(String.valueOf(currentCard.getCost()));
		}
	}

	public void insertCharacter(ImageView cardImage, String cardName){
		Image view = new Image(cardName + ".jpg");
		cardImage.setImage(view);
	}

	public void back(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().sendResponse(new BackResponse());
		SceneHandlerGUI.getInstance().startLoading();
	}

	public void chooseCharacter(MouseEvent mouseEvent){
		String name = mouseEvent.getPickResult().getIntersectedNode().getId();
		if(name.equals("firstCharacter"))
			characterCardPosition = 0;
		if(name.equals("secondCharacter"))
			characterCardPosition = 1;
		if(name.equals("thirdCharacter"))
			characterCardPosition = 2;

		SceneHandlerGUI.getInstance().getPlayCharacterCardResponse().setCharacterCardPosition(characterCardPosition);
		String characterName = cards.get(characterCardPosition).getName();
		switch(characterName){
			case "Jester":
				ArrayList<String> studentsOnJester = new ArrayList<>();
				cards.get(characterCardPosition).getStudentsOnCard().forEach((color, value) -> {
					for(int i = 0; i < value; i++){
						studentsOnJester.add(color);
					}
				});

				SceneHandlerGUI.getInstance().setJesterStudents(studentsOnJester);
				SceneHandlerGUI.getInstance().launchJester();
				break;
			case "Minstrel":
				SceneHandlerGUI.getInstance().launchMinstrel();
				break;
			case "Mushroomer":
				SceneHandlerGUI.getInstance().launchMushroomer();
				break;
			default:
				SceneHandlerGUI.getInstance().sendCharacterCardResponse();
				break;
		}
	}
}
