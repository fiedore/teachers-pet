package application;

import javafx.collections.transformation.FilteredList;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import model.Table;

import javax.xml.bind.JAXBException;


public class Controller {

    public void saveToXML(GridPane mainGrid) throws JAXBException {
        FilteredList<Node> gridChildren = mainGrid.getChildren().filtered(node -> node instanceof TextArea);
        DataAdapter dataAdapter = new DataAdapter();
        Table table = dataAdapter.processData(gridChildren);
        XMLHandler xmlHandler = new XMLHandler();
        xmlHandler.marshallData(table);
    }
}
