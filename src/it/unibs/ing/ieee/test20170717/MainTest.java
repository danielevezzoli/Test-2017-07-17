package it.unibs.ing.ieee.test20170717;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

/**
 * @author Daniele Vezzoli on 2017-07-17
 * Il calcolo del determinante funziona, sia con Laplace che con Sarrus
 * Il calcolo dell'indice di un tensore è corretto
 * Non sono riuscito a fare il parsing del file XML fornito e quindi non ho eseguito il calcolo dell'indice
 * 	della radice
 * Non sono state usate librerie esterne
 */
public class MainTest {

	public static void main(String[] args) {
		int dim = 2;
		Matrice m = new Matrice(dim);
		int n=1;
		int[][] table = new int[dim][dim];
		for(int r = 0; r< dim; r++) {
			for(int c = 0; c < dim; c++) {
				table[r][c] = n;
				n++;
			}
			
		}
		
		m.setMatrice(table);
		System.out.println(m);
		System.out.println(m.determinante(m));
		
			
		
		
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
