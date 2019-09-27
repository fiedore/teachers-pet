package application;

import javafx.collections.transformation.FilteredList;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import model.Table;

import javax.xml.bind.JAXBException;
import java.util.*;


public class Controller {

    public void saveToXML(GridPane mainGrid) throws JAXBException {
        FilteredList<Node> gridChildren = mainGrid.getChildren().filtered(node -> node instanceof TextArea);
        Map<TextArea, Integer> textAreaToNumber = new HashMap<>();
        for (int i = 0; i < gridChildren.size(); i++) {
            Node node = gridChildren.get(i);
            TextArea nodeAsTextArea = (TextArea) node;
            if (nodeAsTextArea.getText().isEmpty()) {
                continue;
            }
            textAreaToNumber.put(nodeAsTextArea, i);
        }
        DataAdapter dataAdapter = new DataAdapter();
        Table table = dataAdapter.processData(textAreaToNumber);
        XMLHandler xmlHandler = new XMLHandler();
        xmlHandler.marshallData(table);
    }
}
