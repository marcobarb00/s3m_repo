package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.*;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.*;


public class PlanningPhaseGUI extends GameStateGUI{
	@FXML
	GridPane gridPane;
	@FXML
	VBox vBoxAssistantCard;
	@FXML
	ImageView assistantZero;
	@FXML
	ImageView assistantOne;
	@FXML
	ImageView assistantTwo;
	@FXML
	ImageView assistantThree;
	@FXML
	ImageView assistantFour;
	@FXML
	ImageView assistantFive;
	@FXML
	ImageView assistantSix;
	@FXML
	ImageView assistantSeven;
	@FXML
	ImageView assistantEight;
	@FXML
	ImageView assistantNine;
    @FXML
	ImageView assistantCardPlayed1;
	@FXML
	ImageView assistantCardPlayed2;
	@FXML
	ImageView assistantCardPlayed3;

	public void printMessageInformation(PlanningPhaseMessage planningPhaseMessage){
		List<ImageView> assistantCardsImageView = Arrays.asList(assistantZero, assistantOne, assistantTwo,
				assistantThree, assistantFour, assistantFive, assistantSix, assistantSeven, assistantEight, assistantNine);

		List<ImageView> playedAssistantCardImages = Arrays.asList(assistantCardPlayed1, assistantCardPlayed2, assistantCardPlayed3);

		GameDTO gameState = planningPhaseMessage.getGameState();
		setGameState(gameState);

		HashMap<String, AssistantCardDTO> playedAssistantCards = gameState.getTurn().getPlayedCards();
		ArrayList<String> nicknameList = gameState.getPlayerNicknames();

		for(int i = 0; i < nicknameList.size(); i++){
			AssistantCardDTO currentCard = playedAssistantCards.get(nicknameList.get(i));
			if (currentCard != null){
				insertAssistantImage(playedAssistantCardImages.get(i), currentCard);
			}
		}

		ArrayList<AssistantCardDTO> hand = gameState.getCurrentPlayer().getHand();

		for(int i = 0; i < hand.size(); i++){
			insertAssistantImage(assistantCardsImageView.get(i), hand.get(i));
		}
	}

	//assistant cards

	public void insertAssistantImage(ImageView assistantImageView, AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantImageView.setImage(view);
	}

	public void chooseAssistantCard(MouseEvent event){
		String name = event.getPickResult().getIntersectedNode().getId();
		int chosenNumber = -1;

		if(name.equals("assistantZero")){
			chosenNumber = 0;
			assistantZero.setVisible(false);
		}
		if(name.equals("assistantOne")){
			chosenNumber = 1;
			assistantOne.setVisible(false);
		}
		if(name.equals("assistantTwo")){
			chosenNumber = 2;
			assistantTwo.setVisible(false);
		}
		if(name.equals("assistantThree")){
			chosenNumber = 3;
			assistantThree.setVisible(false);
		}
		if(name.equals("assistantFour")){
			chosenNumber = 4;
			assistantFour.setVisible(false);
		}
		if(name.equals("assistantFive")){
			chosenNumber = 5;
			assistantFive.setVisible(false);
		}
		if(name.equals("assistantSix")){
			chosenNumber = 6;
			assistantSix.setVisible(false);
		}
		if(name.equals("assistantSeven")){
			chosenNumber = 7;
			assistantSeven.setVisible(false);
		}
		if(name.equals("assistantEight")){
			chosenNumber = 8;
			assistantEight.setVisible(false);
		}
		if(name.equals("assistantNine")){
			chosenNumber = 9;
			assistantNine.setVisible(false);
		}

		ControllerGUI.getInstance().sendResponse(new PlayAssistantCardResponse(chosenNumber));
		ControllerGUI.getInstance().startLoading();
	}
}
