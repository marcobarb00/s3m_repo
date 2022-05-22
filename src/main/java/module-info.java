module it.polimi.ingsw.s3m.launcher{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens it.polimi.ingsw.s3m.launcher.Client.View.GUI to javafx.fxml;
    exports it.polimi.ingsw.s3m.launcher.Client.View.GUI;

    opens it.polimi.ingsw.s3m.launcher.Server.Message to javafx.fxml;
    exports it.polimi.ingsw.s3m.launcher.Server.Message;

    opens it.polimi.ingsw.s3m.launcher.Client.Response to javafx.fxml;
    exports it.polimi.ingsw.s3m.launcher.Client.Response;

    opens it.polimi.ingsw.s3m.launcher.DTOs to javafx.fxml;
    exports it.polimi.ingsw.s3m.launcher.DTOs;
}