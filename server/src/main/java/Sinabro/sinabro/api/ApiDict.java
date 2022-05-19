package Sinabro.sinabro.api;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ApiDict {
    String key = "BD642F01E0DB17644136E02E5D5EC3B1";
    @SneakyThrows
    public List<String> findeDefinition(String voca) {
        List<String> definition = new ArrayList<String>();
        voca = URLEncoder.encode(voca,"UTF-8");
        //System.out.println("APIdict 매소드부분" );
        try {
            String url = "http://stdict.korean.go.kr/api/search.do?key=" + key + "&type_search=search&q=" + voca;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);

            NodeList nl = doc.getElementsByTagName("item");

            //System.out.println("nl length "+nl.getLength());
            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
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