package application;

import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;


public class Controller {

    public void saveToXML(GridPane mainGrid) {
        mainGrid.getChildren().filtered(node -> node instanceof TextArea);
    }
}
