package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.bind.JAXBException;
import java.util.List;

public class Main extends Application {
    private Controller controller = new Controller();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Teacher's pet");
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.jpg")));
        GridPane mainGrid = setUpMainGrid();
        loadRows(mainGrid, 4);
        primaryStage.setScene(new Scene(mainGrid, 1000, 600));
        primaryStage.show();
    }

    private void loadRows(GridPane mainGrid, int amountOfRows) {
        List<VBox> vBoxes = NodeGenerator.getListOfLabelsInVBoxes("Question", amountOfRows);
        List<TextArea> textAreas = NodeGenerator.getListOfTextAreas(amountOfRows);
        for (int i = 0; i < amountOfRows; i++) {
            mainGrid.add(vBoxes.get(i), 0, i);
            mainGrid.add(textAreas.get(i), 1, i);
        }
        Button saveButton = getSaveButton();
        saveButton.setOnAction(event -> {
            try {
                controller.saveToXML(mainGrid);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        });
        mainGrid.add(saveButton, 2, amountOfRows + 1);
        GridPane.setHalignment(saveButton, HPos.RIGHT);

    }

    private Button getSaveButton() {
        return new Button("Save");
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
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setGridLinesVisible(false);
        return gridPane;
    }


}
