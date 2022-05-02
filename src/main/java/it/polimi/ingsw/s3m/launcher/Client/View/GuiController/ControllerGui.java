/* package it.polimi.ingsw.s3m.launcher.Client.View.GuiController;

import it.polimi.ingsw.s3m.launcher.Client.View.GUI.ClientGui;
import it.polimi.ingsw.s3m.launcher.Client.View.GUI.LoadingScreenGui;
import it.polimi.ingsw.s3m.launcher.Client.View.GUI.LoginGui;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ControllerGui {
    private ClientGui thread;
    private static ControllerGui INSTANCE;
    private Stage primaryStage;
    private Stage secondaryStage;
    private LoginGui loginGui;
    private LoadingScreenGui loadingScreenGui;




    private ControllerGui() {
        secondaryStage = new Stage();
        secondaryStage.setTitle("Eryantis");
        secondaryStage.getIcons().add(new Image("imgareryantistotal.png"));
        secondaryStage.setResizable(false);

    }

   public static ControllerGui getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ControllerGui();
        return INSTANCE;
    }

    public void startGame(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("FirstScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.show();
        thread = new ClientGui(this);
        thread.start();
        loadingScreenGui = new LoadingScreenGui(secondaryStage);
        secondaryStage.setOnCloseRequest(e -> Platform.runLater(() -> {
            Platform.exit();
            System.exit(0);
        }));
    }
}*/
