package by.bsuir.ausuikevich.server.dao.impl;

import by.bsuir.ausuikevich.constant.Entity;
import by.bsuir.ausuikevich.server.dao.ServerDao;
import by.bsuir.ausuikevich.server.entity.FactoryMethod;
import by.bsuir.ausuikevich.server.entity.Info;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServerDaoImpl implements ServerDao {
    public static ServerDaoImpl instance;

    private ServerDaoImpl() {
    }

    public static ServerDaoImpl getInstance() {
        if (instance == null) {
            instance = new ServerDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Info> get(String path, Entity entity) {
        File xmlFile = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            Node node = document.getDocumentElement();
            List<Info> students = new ArrayList<Info>();
            node = node.getChildNodes().item(1);
            while (node != null) {
                if (!node.getNodeName().equals("#text")) {
                    NodeList nodeList = node.getChildNodes();
                    ArrayList<String> parameters = new ArrayList<String>();
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        if (!nodeList.item(i).getNodeName().equals("#text")) {
                            parameters.add(getTagValue(nodeList.item(i).getNodeName(), (Element) node));
                        }
                    }
                    students.add(FactoryMethod.getInfo(parameters, entity));
                }
                node = node.getNextSibling();
            }
            return students;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }


    @Override
    public void add(Map<String, Object> params, String path, Entity entity) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(entity.getPath());
            Element client = document.createElement(entity.name());
            Element root = document.getDocumentElement();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                Element element = document.createElement(param.getKey());
                element.setTextContent(param.getValue().toString());
                client.appendChild(element);
            }
            root.appendChild(client);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Source source = new DOMSource(document);
            Result result = new StreamResult(entity.getPath());
            transformer.transform(source, result);
        } catch (IOException | TransformerException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(String name, List<String[]> parameters, String path) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(path);
            document.getDocumentElement().normalize();
            Node node = document.getDocumentElement();
            node = node.getChildNodes().item(1);
            while (node != null) {
                if (!node.getNodeName().equals("#text")) {
                    NodeList nodeList = node.getChildNodes();
                    if (nodeList.item(1).getTextContent().equals(name)) {
                        int k = 0;
                        for (int i = 0; i < nodeList.getLength(); i++) {
                            if (!nodeList.item(i).getNodeName().equals("#text")) {
                                nodeList.item(i).setTextContent(parameters.get(k)[1]);
                                k++;
                            }
                        }
                    }
                }
                node = node.getNextSibling();
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Source source = new DOMSource(document);
            Result result = new StreamResult(path);
            transformer.transform(source, result);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
