package it.polimi.ingsw.s3m.launcher.Client.View.GuiController;

import it.polimi.ingsw.s3m.launcher.Client.View.GUI.ClientGUI;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ControllerGUI {

    private ClientGUI thread;
    private static ControllerGUI INSTANCE;
    private Stage primaryStage;
    private Stage secondaryStage;


    private ControllerGUI() {
        secondaryStage = new Stage();
        secondaryStage.setTitle("Eriantys");
        secondaryStage.getIcons().add(new Image("eriantysImage.png"));
        secondaryStage.setResizable(false);

    }

    public static ControllerGUI getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ControllerGUI();
        return INSTANCE;
    }


    /*public void sendObject(Message message) {
        thread.communicate(message);

    }

    public void startLoading() {
        loadingScreenGui.start();
    }*/
}
