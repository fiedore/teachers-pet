package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class NodeGenerator {

    static List<VBox> getListOfLabelsInVBoxes(String text, int amount) {
        List<VBox> vBoxes = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            VBox vBox = new VBox();
            vBox.setPrefHeight(50);
            Label label = new Label(text + " " + (i + 1));
            label.setPrefHeight(20);
            vBox.getChildren().add(label);
            VBox.setMargin(label, new Insets(50));
            vBoxes.add(vBox);
        }
        return vBoxes;
    }

    static List<TextArea> getListOfTextAreas(int amount) {
        List<TextArea> textAreas = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            TextArea textArea = new TextArea();
            textArea.setPrefHeight(20);
            textArea.setPrefWidth(400);
            textAreas.add(textArea);
        }
        return textAreas;
    }

    static List<VBox> getListOfOpenQuestionFlags(int amount) {
        List<VBox> questionFlags = new ArrayList<>();

        return questionFlags;
    }

}
