package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Teacher's pet");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.jpg")));
        GridPane mainGrid = setUpMainGrid();
        loadRows(mainGrid);
        primaryStage.setScene(new Scene(mainGrid, 1200, 700));
        primaryStage.show();
    }

    private void loadRows(GridPane mainGrid) {

        mainGrid.add(generateTestNode(), 0, 0);
        mainGrid.add(generateTestNode(), 1, 0);
        mainGrid.add(generateTestNode(), 2, 0);
        mainGrid.add(generateTestNode(), 0, 1);
        mainGrid.add(generateTestNode(), 1, 1);
        mainGrid.add(generateTestNode(), 2, 1);
        mainGrid.add(generateTestNode(), 0, 2);
        mainGrid.add(generateTestNode(), 1, 2);
        mainGrid.add(generateTestNode(), 2, 2);
        Button saveButton = getSaveButton();
        mainGrid.add(saveButton, 2, 3);
        GridPane.setHalignment(saveButton, HPos.RIGHT);

    }

    private Button getSaveButton() {
        Button button = new Button("Save");
        return button;
    }

    private VBox generateTestNode() {
        VBox node = new VBox();
        Label label = new Label("TEST 1");
        node.getChildren().add(label);
        VBox.setMargin(label, new Insets(50));
        node.minHeight(200);
        node.minWidth(500);
        return node;
    }

    private GridPane setUpMainGrid() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPrefWidth(1200);
        gridPane.setPrefHeight(700);
        gridPane.setHgap(30);
        gridPane.setVgap(30);
        gridPane.setGridLinesVisible(true);
        return gridPane;
    }
}
