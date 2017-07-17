package it.unibs.ing.ieee.test20170717;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class ParserXML {
	File filename;
	public NodoTensore parseXml(String filename) throws FileNotFoundException, XMLStreamException {

		try {
			this.filename = new File(filename);
		} catch (Exception e) {
			System.err.println("Il file " + filename + " non è disponibile o non è presente nella directory");
		}


		// Inizializzo le variabili
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(filename));
		
		String content = "";
		NodoTensore root = null;
		NodoTensore node = null;
		List<Tensore> tensorList = null;
		Tensore tensore = null;
		Queue<Integer> arrayMatrix = null;
		int contaRighe = 0;
		List<Matrice> matrixList = null;

		// Ciclo di lettura file (finchè c'è da leggere)
		while (reader.hasNext()) {
			switch (reader.next()) {
			case XMLStreamConstants.START_DOCUMENT:
				System.out.println("Inizio a leggere il documento");
				break;

			case XMLStreamConstants.START_ELEMENT:
				switch (reader.getLocalName()) {
				case "TTree":
					// Se trovo il tag <TTree> creo il nodo Root
					root = new NodoTensore();
					System.out.println("Inizio a leggere l'albero");
					break;
					
				case "TensorNode":
					node = new NodoTensore();
					tensorList = new ArrayList<>();
					break;
				case "tensor":
					tensore = new Tensore(); // Non so ancora la dimensione del tensore
					matrixList = new ArrayList<>();
					break;
				case "matrix":
					arrayMatrix = new LinkedList<>();
					break;
				case "row":
					contaRighe++;
					break;
				}
				break;

			// Leggo i valori tra i tag di apertura e chiusura
			case XMLStreamConstants.CHARACTERS:
				if (reader.getTextLength() > 0) {
					content = reader.getText().trim();
				}
				break;

			// I tag di chiusura
			case XMLStreamConstants.END_ELEMENT:
				switch (reader.getLocalName()) {
				case "tree":
					System.out.println("Ho finito di leggere il documento");
					break;
				case "label":
					node.setLabel(content.charAt(0));
					break;
				case "column":
					arrayMatrix.add(Integer.parseInt(content));
					break;
				case "matrix":
					Matrice m  = creaMatriceDaList(arrayMatrix, contaRighe);
					matrixList.add(m);
					break;
				case "tensor":
					Matrice[] t = matrixList.toArray(new Matrice[matrixList.size()]);
					tensore.setTensore(t);	
					contaRighe = 0;
					break;
				case "TensorNode":
					node.setChildrenTensore(tensorList);
					root.addNodo(node);
					break;
				
				}
				break;

			case XMLStreamConstants.END_DOCUMENT:
				break;

			}

		}
		
		return root;
		
	}
	private Matrice creaMatriceDaList(Queue<Integer> queue, int nRighe) {
		Matrice m = new Matrice(queue.size() / nRighe);
		int[][] matrice = new int[nRighe][nRighe];
		
		for(int r=0; r<nRighe; r++)
			for(int c=0; c<nRighe; c++)
				matrice[r][c] = queue.poll();
		
		m.setMatrice(matrice);
		
		return m;
	}
}
