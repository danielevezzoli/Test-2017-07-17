package it.unibs.ing.ieee.test20170717;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

public class MainTest {

	public static void main(String[] args) {
		ParserXML parser = new ParserXML();
		List<NodoTensore> l = null ;
		
		try {
			parser.parseXml("input1.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
				
	}

}
