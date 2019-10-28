package application;

import model.Table;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XMLHandler {
    private String defaultFileName = "default.xml";
    private File defaultFile = new File(defaultFileName);

    public void marshallData(Table table) throws JAXBException {
        marshallData(table, defaultFile);
    }

    public void marshallData(Table table, File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(table, file);
        marshaller.marshal(table, System.out);
    }
}
