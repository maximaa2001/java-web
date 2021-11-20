package by.bsuir.ausuikevich.parser;

import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.xpath.XPathExpressionException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JAXBSerializer {
    private XMLParser parser;
    private String filePath;

    public JAXBSerializer(String filepath) {
        this.filePath = filepath;
        parser = new XMLParser(filepath);
    }

    public <T, K extends T> void serialize(Class<T> clazz, K object) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        FileWriter fileWriter = new FileWriter(filePath, false);
        marshaller.marshal(object, fileWriter);
    }

    public <T> List<T> deserialize(String exp, Class<T> clazz) throws XPathExpressionException {
        List<T> list = new ArrayList<>();
        NodeList nodes = parser.getNodes(exp);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            for (int i = 0; i < nodes.getLength(); i++) {
                T temp = (T) un.unmarshal(nodes.item(i));
                list.add(temp);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return list;
    }

    public double getCountProduct(String exp) throws XPathExpressionException {
        return parser.getCount(exp);
    }
}
