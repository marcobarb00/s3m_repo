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


    //public void AssistantChoiceGUI(){}

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

    public void insertAssistantOne(AssistantCardDTO assistantCardDTO) {
        Image view = new Image(assistantCardDTO.getType() + ".jpg");
        assistantOne.setImage(view);
    }

    public void insertAssistantTwo(AssistantCardDTO assistantCardDTO) {
        Image view = new Image(assistantCardDTO.getType() + ".jpg");
        assistantTwo.setImage(view);
    }

    public void insertAssistantThree(AssistantCardDTO assistantCardDTO) {
        Image view = new Image(assistantCardDTO.getType() + ".jpg");
        assistantFour.setImage(view);
    }
    public void insertAssistantFour(AssistantCardDTO assistantCardDTO) {
        Image view = new Image(assistantCardDTO.getType() + ".jpg");
        assistantFour.setImage(view);
    }

    public void insertAssistantFive(AssistantCardDTO assistantCardDTO) {
        Image view = new Image(assistantCardDTO.getType() + ".jpg");
        assistantFive.setImage(view);
    }

    public void insertAssistantSix(AssistantCardDTO assistantCardDTO) {
        Image view = new Image(assistantCardDTO.getType() + ".jpg");
        assistantSix.setImage(view);
    }
    public void insertAssistantSeven(AssistantCardDTO assistantCardDTO) {
        Image view = new Image(assistantCardDTO.getType() + ".jpg");
        assistantSeven.setImage(view);
    }

    public void insertAssistantEight(AssistantCardDTO assistantCardDTO) {
        Image view = new Image(assistantCardDTO.getType() + ".jpg");
        assistantEight.setImage(view);
    }

    public void insertAssistantNine(AssistantCardDTO assistantCardDTO) {
        Image view = new Image(assistantCardDTO.getType() + ".jpg");
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
            chosenNumber = 2;
            assistantTwo.setVisible(false);
        }
        if (name.equals("assistantThree")) {
            chosenNumber = 3;
            assistantThree.setVisible(false);
        }
        if (name.equals("assistantFour")) {
            chosenNumber = 4;
            assistantFour.setVisible(false);
        }
        if (name.equals("assistantFive")) {
            chosenNumber = 5;
            assistantFive.setVisible(false);
        }
        if (name.equals("assistantSix")) {
            chosenNumber = 6;
            assistantSix.setVisible(false);
        }
        if (name.equals("assistantSeven")) {
            chosenNumber = 7;
            assistantSeven.setVisible(false);
        }
        if (name.equals("assistantEight")) {
            chosenNumber = 8;
            assistantEight.setVisible(false);
        }
        if (name.equals("assistantNine")) {
            chosenNumber = 9;
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
