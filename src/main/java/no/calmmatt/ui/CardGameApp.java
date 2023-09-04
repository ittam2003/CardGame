package no.calmmatt.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardGameApp extends Application {

    /**
     * The start-method is called by the JavaFX platform upon starting the
     * JavaFX-platform. The method is abstract and must be overridden by
     * any subclass of Application.
     * The main window is set up in this method, including menus, toolboxes etc.
     *
     * @param stage The main stage making up the main window.
     */
    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        Button button1 = new Button();
        root.setTop(button1);
        Scene scene = new Scene(root, 1440, 720);
        stage.setTitle("Card Dealer");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The stop() method is being called by the JavaFX-platform when the
     * platform stops, are being terminated. This would typically happen
     * as a result of the last open window being closed.
     * Override this method to make sure that the application is terminated.
     */
    @Override
    public void stop() {
        System.exit(0);
    }

}
