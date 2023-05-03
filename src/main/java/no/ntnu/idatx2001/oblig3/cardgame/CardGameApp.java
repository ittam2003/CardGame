package no.ntnu.idatx2001.oblig3.cardgame;

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
     * @param primaryStage The main stage making up the main window.
     */
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane(); // Create the root node. The Menu will be placed at the top

        Button button1 = new Button();
        // Place the menubar in the topContainer

        // Place the top container in the top-section of the BorderPane
        root.setTop(button1);

        // Create the scene, adding the rootNode and setting the size
        Scene scene = new Scene(root, 1440, 720);
        // Set title of the stage (window) and add the scene
        primaryStage.setTitle("Card Game");
        primaryStage.setScene(scene);
        // Finally, make the stage (window) visible
        primaryStage.show();
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

    /**
     * The entry-point to start the application.
     *
     * @param args Command-line arguments supplied during startup
     */
    public static void appMain(String[] args) {
        launch(args);
    }

    /**
     * Creates and returns the menus to be displayed.
     *
     * @return The MenuBar to be displayed.
     */
    private MenuBar createMenus() {
        // Create the Menu Bar to hold all the menus
        MenuBar menuBar = new MenuBar();

        // The File-menu
        Menu menuFile = new Menu("File");
        MenuItem openFile = new MenuItem("Open");
        MenuItem printFile = new MenuItem("Print");
        MenuItem exitApp = new MenuItem("Exit");
        menuFile.getItems().addAll(openFile, printFile);
        menuFile.getItems().add(new SeparatorMenuItem());
        menuFile.getItems().add(exitApp);

        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");

        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

        return menuBar;
    }

}
