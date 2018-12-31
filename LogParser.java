package com.javacodegeeks;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LogParser {
    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {

        List<Integer> list = new ArrayList();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            try {
                Document doc = db.parse(is);
                NodeList nodes = doc.getElementsByTagName("entry");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node entryenode = (Element) nodes.item(i);

                    if (entryenode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) entryenode;
                        String id = eElement.getAttribute("id");

                         String msg = eElement
                                .getElementsByTagName("message")
                                .item(0)
                                .getTextContent();
                        if(msg.equalsIgnoreCase(message)){
                            list.add(Integer.valueOf(id));
                                                    }
                    }
                }
            } catch (SAXException e) {
                // handle SAXException
            } catch (IOException e) {
                // handle IOException
            }
        } catch (ParserConfigurationException e1) {
            // handle ParserConfigurationException
        }
      return list;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<log>\n" +
                        "    <entry id=\"1\">\n" +
                        "        <message>Application started</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"2\">\n" +
                        "        <message>Application ended</message>\n" +
                        "    </entry>\n" +
                        "</log>";

        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        for(int id: ids)
            System.out.println((Integer)id);
    }
}