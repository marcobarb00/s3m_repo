package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class CharacterCardActivationGUI {
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



    private boolean im1 = false;
    private boolean im2 = false;
    private boolean im3 = false;
    private List<CardMessage> cards;
    private Integer chosenCharacter ;



    public void inizialize(CharacterActivationMessage leaderActivationMessage) {
        cards = CharacterActivationMessage.getCards();
        active1.setVisible(false);
        active2.setVisible(false);
        active3.setVisible(false);
        if(cards.size()>=1) {
            insertFirstCharacter(cards.get(0).getCardNumber());
            im1 = true;
            active1.setVisible(true);
        }
        if(cards.size()>1) {
            insertSecondCharacter(cards.get(1).getCardNumber());
            im2 = true;
            active2.setVisible(true);
        }
        if(cards.size()>2) {
            insertThirdCharacter(cards.get(1).getCardNumber());
            im3 = true;
            active2.setVisible(true);
        }
    }

    public void insertFirstCharacter(Integer cardNumbers) {
        int c = cardNumbers;
        System.out.println(c);
        Image view = new Image(c + ".jpg");
        firstCharacter.setImage(view);
    }

    public void insertSecondCharacter(Integer cardNumbers) {
        int c = cardNumbers;
        System.out.println(c);
        Image view = new Image(c + ".jpg");
        secondCharacter.setImage(view);
    }
    public void insertThirdCharacter(Integer cardNumbers) {
        int c = cardNumbers;
        System.out.println(c);
        Image view = new Image(c + ".jpg");
        thirdCharacter.setImage(view);
    }

    public void submit(MouseEvent mouseEvent) {
        if(active1.isSelected() && im1)
            chosenCharacter = 0;
        if(active2.isSelected() && im2)
            chosenCharacter = 1;
        if(active3.isSelected() && im3)
            chosenCharacter = 2;
        ControllerGUI.getInstance().sendObject(new CharacterActivationMessage(chosenCharacter));
        ControllerGUI.getInstance().startLoading();
    }

    public void back(MouseEvent event){
        chosenCharacter = -1;
        ControllerGUI.getInstance().sendObject(new CharacterActivationMessage(chosenCharacter));
        ControllerGUI.getInstance().startLoading();
    }
}
