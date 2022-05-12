package Sinabro.sinabro.api;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class ApiDict {
    String key = "BD642F01E0DB17644136E02E5D5EC3B1";
    public List<String> findeDefinition(String voca) {
        List<String> definition = new ArrayList<String>();
        try {
            String url = "http://stdict.korean.go.kr/api/search.do?key=" + key + "&type_search=search&q=" + voca;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);

            NodeList nl = doc.getElementsByTagName("item");

            for (int i = 0; i < nl.getLength(); i++) {
                //System.out.println(nl.item(i));
                Node node = nl.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    /*
                    System.out.println("target_code : " + getValue("target_code", element));
                    System.out.println("word : " + getValue("word", element));
                    System.out.println("pos : " + getValue("pos", element));
                    System.out.println("definition : " + getValue("definition", element));
                    System.out.println("link : " + getValue("link", element));
                    System.out.println();
                     */
                    definition.add(getValue("definition", element));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return definition;
    }

    public static String getValue(String tag, Element element) {
        NodeList nl = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node value = (Node) nl.item(0);
        return value.getNodeValue();
    }
}