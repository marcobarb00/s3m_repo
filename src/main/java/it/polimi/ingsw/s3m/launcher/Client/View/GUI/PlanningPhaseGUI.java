package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Client.View.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PlanningPhaseGUI {

    @FXML
    GridPane gridPane;
    @FXML
    VBox vBoxAssistantCard;
    @FXML
    ImageView backgroundImage;
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


    public void AssistantChoiceGUI(){
    }

    public void printMessageInformation(PlanningPhaseMessage planningPhaseMessage, Stage secondaryStage) {
        ArrayList<AssistantCardDTO> hand = planningPhaseMessage.getHand();
        ArrayList<AssistantCardDTO> playedCards = planningPhaseMessage.getPlayedAssistantCards();

        try{
            insertAssistantZero(hand.get(0));
            insertAssistantOne(hand.get(1));
            insertAssistantTwo(hand.get(2));
            insertAssistantThree(hand.get(3));
            insertAssistantFour(hand.get(4));
            insertAssistantFive(hand.get(5));
            insertAssistantSix(hand.get(6));
            insertAssistantSeven(hand.get(7));
            insertAssistantEight(hand.get(8));
            insertAssistantNine(hand.get(9));
        }catch(ArrayIndexOutOfBoundsException e){
            return;
        }

    }

    public void insertAssistantZero(AssistantCardDTO assistantCardDTO) {
        Image view = new Image(assistantCardDTO.getType() + ".jpg");
        assistantZero.setImage(view);
    }

    public void insertAssistantOne(Integer cardNumbers) {
        int c = cardNumbers;
        Image view = new Image(c + ".jpg");
        assistantOne.setImage(view);
    }

    public void insertAssistantTwo(Integer cardNumbers) {
        int c = cardNumbers;
        Image view = new Image(c + ".jpg");
        assistantTwo.setImage(view);
    }

    public void insertAssistantThree(Integer cardNumbers) {
        int c = cardNumbers;
        Image view = new Image(c + ".jpg");
        assistantFour.setImage(view);
    }
    public void insertAssistantFour(Integer cardNumbers) {
        int c = cardNumbers;
        Image view = new Image(c + ".jpg");
        assistantFour.setImage(view);
    }

    public void insertAssistantFive(Integer cardNumbers) {
        int c = cardNumbers;
        Image view = new Image(c + ".jpg");
        assistantFive.setImage(view);
    }

    public void insertAssistantSix(Integer cardNumbers) {
        int c = cardNumbers;
        Image view = new Image(c + ".jpg");
        assistantSix.setImage(view);
    }
    public void insertAssistantSeven(Integer cardNumbers) {
        int c = cardNumbers;
        Image view = new Image(c + ".jpg");
        assistantSeven.setImage(view);
    }

    public void insertAssistantEight(Integer cardNumbers) {
        int c = cardNumbers;
        Image view = new Image(c + ".jpg");
        assistantEight.setImage(view);
    }

    public void insertAssistantNine(Integer cardNumbers) {
        int c = cardNumbers;
        Image view = new Image(c + ".jpg");
        assistantNine.setImage(view);
    }



    public void chooseAssistantCard(MouseEvent event) {
        String name = event.getPickResult().getIntersectedNode().getId();
        int chosenNumber = -1;

        if (name.equals("assistantZero")) {
            chosenNumber = 0;
            assistantZero.setVisible(false);
        }
        if (name.equals("assistantOne")) {
            chosenNumber = 1;
            assistantOne.setVisible(false);
        }
        if (name.equals("assistantTwo")) {
            chosenNumbers.add(2);
            assistantTwo.setVisible(false);
        }
        if (name.equals("assistantThree")) {
            chosenNumbers.add(3);
            assistantThree.setVisible(false);
        }
        if (name.equals("assistantFour")) {
            chosenNumbers.add(4);
            assistantFour.setVisible(false);
        }
        if (name.equals("assistantFive")) {
            chosenNumbers.add(5);
            assistantFive.setVisible(false);
        }
        if (name.equals("assistantSix")) {
            chosenNumbers.add(6);
            assistantSix.setVisible(false);
        }
        if (name.equals("assistantSeven")) {
            chosenNumbers.add(7);
            assistantSeven.setVisible(false);
        }
        if (name.equals("assistantEight")) {
            chosenNumbers.add(8);
            assistantEight.setVisible(false);
        }
        if (name.equals("assistantNine")) {
            chosenNumbers.add(9);
            assistantNine.setVisible(false);
        }

        ControllerGUI.getInstance().sendResponse(new PlayAssistantCardResponse(chosenNumber));
        hide();
        ControllerGUI.getInstance().startLoading();
    }

    private void hide() {
        vBoxAssistantCard.setVisible(false);
    }



}
