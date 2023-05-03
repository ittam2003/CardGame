package no.ntnu.idatx2001.oblig3.cardgame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The Main class represents the user interface of the CardGame application.
 * It contains methods for displaying cards as images, updating labels for
 * sum of cards, all hearts in hand, whether there is a Queen of spades in
 * the hand, and whether there is a 5-flush in the hand.
 * It also contains the start method that sets up the UI components and
 * handles the "Deal hand" button action by calling the appropriate controller methods
 * to update the UI.
 *
 * @author Matti Kjellstadli
 * @version 2023-03-21
 */
public class Main extends Application {
    private Text cardText;
    private Label allHeartsLabel;
    private Label valueLabel;
    private Label s12;
    private Label flush;

    private FlowPane cardPic;

    private MainController controller;
    private BorderPane root;

    /**
     * The start method sets up the UI components and handles the "Deal hand"
     * button action by calling the appropriate controller methods to update the UI.
     * @param stage the main stage of the application
     * @throws Exception if there is an error setting up the UI components
     *
     */
    @Override
    public void start(Stage stage) throws Exception {
        this.controller = new MainController();
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(#597fff, #6e90ff); -fx-border-color: #2460a4; -fx-border-color: #2460a4; -fx-border-width: 10");
        root.setPadding(new Insets(50));

        Button dealButton = new Button("DEAL\nHAND");
        Font font = Font.font("Arial", FontWeight.BOLD, 14);
        dealButton.setFont(font);
        dealButton.setPrefSize(80, 80);
        dealButton.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px ; -fx-cursor: HAND ");
        dealButton.setOnMouseEntered(e -> {
            dealButton.setStyle("-fx-background-color: #d1d1d1; -fx-background-radius: 20px ; -fx-cursor: HAND ");
        });

        dealButton.setOnMouseClicked(e -> {
            dealButton.setStyle("-fx-background-color: GREY; -fx-background-radius: 20px ; -fx-cursor: HAND ");
        });

        dealButton.setOnMouseExited(e -> {
            dealButton.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px ; -fx-cursor: HAND ");
        });

        Button exitButton = new Button("EXIT");
        exitButton.setFont(font);
        exitButton.setPrefSize(80, 80);
        exitButton.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px ; -fx-cursor: HAND ");
        exitButton.setOnMouseEntered(e -> {
            exitButton.setStyle("-fx-background-color: #d1d1d1; -fx-background-radius: 20px ; -fx-cursor: HAND ");
        });

        exitButton.setOnMouseClicked(e -> {
            exitButton.setStyle("-fx-background-color: GREY; -fx-background-radius: 20px ; -fx-cursor: HAND ");
        });

        exitButton.setOnMouseExited(e -> {
            exitButton.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px ; -fx-cursor: HAND ");
        });


        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5.0);
        dropShadow.setOffsetY(5.0);
        dropShadow.setSpread(3);
        dropShadow.setHeight(5);
        dropShadow.setWidth(5);
        dropShadow.setColor(Color.color(0, 0, 0, 0.5));

        StackPane cardPane = new StackPane();

        this.cardText = new Text("There are no cards");

        this.cardPic = new FlowPane();
        this.cardPic.setAlignment(Pos.CENTER);
        this.cardPic.setHgap(20);
        this.cardPic.setVgap(20);
        this.cardPic.setPadding(new Insets(20));
        ImageView[] images = new ImageView[5];
        for (int i = 0; i < images.length; i++) {
            images[i] = new ImageView("/cards/jk.png");
            images[i].setFitWidth(200);
            images[i].setFitHeight(300);
            images[i].setEffect(dropShadow);
        }

        this.cardPic.getChildren().addAll(images);
        this.cardPic.setStyle("-fx-background-color: linear-gradient(#20fe8c, #00ff7a); -fx-background-radius: 40px");



        cardPane.getChildren().add(cardText);
        root.setCenter(cardPic);



        BorderPane titlePane = new BorderPane();
        ImageView title = new ImageView("/other/title.png");
        title.setFitHeight(45);
        title.setFitWidth(200);
        titlePane.setCenter(title);
        root.setTop(titlePane);

        this.valueLabel = new Label();
        this.valueLabel.setFont(new Font(26));
        Label sumTextLabel = new Label("Sum of cards:");
        sumTextLabel.setPadding(new Insets(0,0,0,20));
        HBox sumOfCards = new HBox(10, sumTextLabel, valueLabel);

        this.allHeartsLabel = new Label();
        this.allHeartsLabel.setFont(new Font(26));
        Label allHeartsLabel = new Label("Hearts:");
        sumOfCards.getChildren().addAll(allHeartsLabel, this.allHeartsLabel);

        this.s12 = new Label();
        this.s12.setFont(new Font(26));
        Label checkForS12 = new Label("Queen of spades:");
        checkForS12.setPadding(new Insets(0,0,0,20));
        HBox hBox = new HBox(10, checkForS12, s12);

        this.flush = new Label();
        Label checkForFlush = new Label("Flush:");
        hBox.getChildren().addAll(checkForFlush, this.flush);
        VBox info1 = new VBox(10, sumOfCards,hBox);
        info1.setAlignment(Pos.CENTER);
        HBox info2 = new HBox(info1,exitButton, dealButton);
        HBox.setHgrow(info1, Priority.ALWAYS);
        HBox.setHgrow(dealButton, Priority.ALWAYS);

        info2.setStyle("-fx-background-color: #93acff; -fx-background-radius: 20px; -fx-border-width: 5");
        info2.setSpacing(5);
        info2.setPadding(new Insets(10));
        root.setBottom(info2);



        dealButton.setOnAction(event -> {
                    controller.handleDealButton();
                    displayCards(controller.hand);
                    newSum();
                    allHearts();
                    checkS12();
                    checkFlush();
                    cardTextChange(controller.hand);
                }
        );

        exitButton.setOnAction(event -> {
            Platform.exit();
        });

        Scene mainScene = new Scene(root, 1300,800);
        mainScene.getStylesheets().add(this.getClass().getResource("/main.css").toExternalForm());
        stage.setMinWidth(1300);
        stage.setMinHeight(700);
        stage.setResizable(true);
        stage.setScene(mainScene);
        stage.setTitle("CardGame");
        stage.show();
    }

    /**
     * Displays the cards in a hand object.
     *
     * @param hand the hand object representing the player's current hand.
     */
    private void displayCards(Hand hand){
        String[] cards =  hand.getHandAsString().toString().split(", ");
        String cardsString = Arrays.toString(cards).replaceAll("\\[|\\]", "");
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(cardsString.split(",\\s*")));
        List<String> cardImages = new ArrayList<>();

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5.0);
        dropShadow.setOffsetY(5.0);
        dropShadow.setSpread(3);
        dropShadow.setHeight(5);
        dropShadow.setWidth(5);
        dropShadow.setColor(Color.color(0, 0, 0, 0.5));

        HBox imageBox = new HBox();
        for (String card : arrayList) {
            cardImages.add(card + ".png");
        }

        for (String cardImage : cardImages) {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/cards/" + cardImage)));
            ImageView imageView = new ImageView(image);
            //imageView.setFitHeight(150);
            //imageView.setFitWidth(100);
            imageView.setFitHeight(300);
            imageView.setFitWidth(200);
            imageView.setEffect(dropShadow);
            imageBox.getChildren().add(imageView);

        }
        //this.cardPic = imageBox;
        this.cardPic.getChildren().clear();
        this.cardPic.getChildren().addAll(imageBox.getChildren());
    }

    /**
     * Sets the text of the allHeartsLabel to display all the hearts in the player's hand.
     */
    private void allHearts() {
        this.allHeartsLabel.setText(controller.getAllHeartsInHand());
    }

    /**
     * Checks if the player has the queen of spades and updates the text of the s12 label accordingly.
     */
    private void checkS12() {
        if (this.controller.getQueenOfSpades()) {
            this.s12.setText("Yes");
        } else {
            this.s12.setText("No");
        }
    }

    /**
     * Updates the text of the cardText label to display the cards in the player's hand.
     * @param hand the hand object representing the player's current hand.
     */
    private void cardTextChange(Hand hand) {
        this.cardText.setText(hand.getHandAsString().toString());
    }

    /**
     * Updates the text of the valueLabel to display the current sum of the player's hand.
     */
    private void newSum() {
        this.valueLabel.setText(controller.getSumOfCardsAsString());
    }

    /**
     * Checks if the player has a flush and updates the text of the flush label accordingly.
     */
    private void checkFlush() {
        if (this.controller.checkIfFlush()) {
            this.flush.setText("Yes");
        } else {
            this.flush.setText("No");
        }
    }

    /**
     * Launches the JavaFX application.
     * @param args the command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}