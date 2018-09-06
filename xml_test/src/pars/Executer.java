package pars;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Executer {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String path = "/config/config.xml";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputStream is = Executer.class.getResourceAsStream(path);
		Document doc = db.parse(is);
		NodeList nl = doc.getElementsByTagName("bean");
		System.out.println(nl!=null);
		System.out.println(nl.getLength());
		System.out.println(nl.item(0).getTextContent());
		
//		System.out.println(el.getLength());
//		for (int i = 0, max = el.getLength(); i <= max; i++) {
//			Node food = el.item(i);
//			System.out.println(food.getTextContent());
		}
	}
