package it.unibs.ing.ieee.test20170717;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

public class MainTest {

	public static void main(String[] args) {
		int dim = 2;
		Matrice m = new Matrice(dim);
		int[][] table = new int[dim][dim];
		int n=1;
		for (int row = 0; row < dim; row ++) {
		    for (int col = 0; col < dim; col++) {
		        table[row][col] = n;
		        System.out.print(table[row][col]);
		        n++;
		    }
		    System.out.println();
		}
		
		m.setMatrice(table);
		System.out.println(m.laplace(m));
		
		ParserXML parser = new ParserXML();
		
		try {
			NodoTensore root = parser.parseXml("input1.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
		

		
	}

}
