package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlayCharacterCardMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class PlayCharacterCardGUI{
    public ToggleGroup activeRadios;
    @FXML
    ImageView backgroundImage;
    @FXML
    VBox vBox;
    @FXML
    Button submit;
    @FXML
    ToggleGroup activeRadios1;
    @FXML
    ImageView firstCharacter;
    @FXML
    ImageView secondCharacter;
    @FXML
    ImageView thirdCharacter;
    @FXML
    GridPane gridPane;
    @FXML
    RadioButton active1;
    @FXML
    RadioButton active2;
    @FXML
    RadioButton active3;
    @FXML
    Button back;

    private ArrayList<CharacterCardDTO> cards;
    private Integer characterCardPosition;

    public void inizialize(PlayCharacterCardMessage playCharacterCardMessage) {
        GameDTO gameState = playCharacterCardMessage.getGameState();
        cards = gameState.getCharacterCards();

        insertFirstCharacter(cards.get(0).getName());
        insertSecondCharacter(cards.get(1).getName());
        insertThirdCharacter(cards.get(2).getName());
    }

    public void insertFirstCharacter(String cardName) {
        Image view = new Image(cardName + ".jpg");
        firstCharacter.setImage(view);
    }

    public void insertSecondCharacter(String cardName) {
        Image view = new Image(cardName + ".jpg");
        secondCharacter.setImage(view);
    }

    public void insertThirdCharacter(String cardName) {
        Image view = new Image(cardName + ".jpg");
        thirdCharacter.setImage(view);
    }

    public void submit(MouseEvent mouseEvent) {
        if(active1.isSelected())
            characterCardPosition = 0;
        if(active2.isSelected())
            characterCardPosition = 1;
        if(active3.isSelected())
            characterCardPosition = 2;

        ControllerGUI.getInstance().getPlayCharacterCardResponse().setCharacterCardPosition(characterCardPosition);
        String characterName = cards.get(characterCardPosition).getName();
        if(characterName.equals("Jester")){
            ControllerGUI.getInstance().launchJester();
        }
        if(characterName.equals("Minstrel")){
            ControllerGUI.getInstance().launchMinstrel();
        }
        if(characterName.equals("Mushroomer")){
            ControllerGUI.getInstance().launchMushroomer();
        }

        ControllerGUI.getInstance().sendResponse(ControllerGUI.getInstance().getPlayCharacterCardResponse());
        ControllerGUI.getInstance().startLoading();
    }

    public void back(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendResponse(new BackResponse());
        ControllerGUI.getInstance().startLoading();
    }
}
