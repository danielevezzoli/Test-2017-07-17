package it.unibs.ing.ieee.test20170717;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class ParserXML {
	File filename;
	public void parseXml(String filename) throws FileNotFoundException, XMLStreamException {

		try {
			this.filename = new File(filename);
		} catch (Exception e) {
			System.err.println("Il file " + filename + " non è disponibile o non è presente nella directory");
		}


		// Inizializzo le variabili
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(filename));
		
		String content = "";
		List<Tensore> tensorList = null;
		char corrente = '0';
		NodoTensore nodoCorrente = null;
		Tensore tensore = null;
		Queue<Integer> arrayMatrix = null;
		int contaRighe = 0;
		List<Matrice> matrixList = null;
		List<Tensore> copy = null;
		Stack<NodoTensore> ordineNodi = new Stack<>();
		List<NodoTensore> list = new ArrayList<>();

		// Ciclo di lettura file (finchè c'è da leggere)
		while (reader.hasNext()) {
			switch (reader.next()) {
			case XMLStreamConstants.START_DOCUMENT:
				System.out.println("Inizio a leggere il documento");
				break;

			case XMLStreamConstants.START_ELEMENT:
				switch (reader.getLocalName()) {
				case "TTree":
					System.out.println("Inizio albero.");
					break;
				case "TensorNode":
					nodoCorrente =  new NodoTensore();
					tensorList = new ArrayList<>();
					break;
				case "tensor":
					tensore = new Tensore();
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
					nodoCorrente.setLabel(content.charAt(0));
					ordineNodi.push(nodoCorrente);
					break;
				case "column":
					arrayMatrix.add(Integer.parseInt(content));
					break;
				case "matrix":					
					Matrice m  = creaMatriceDaList(arrayMatrix, contaRighe);
					matrixList.add(m);
					contaRighe = 0;
					break;
				case "tensor":
					//Converte un ArrayList in un array (Con aiuto di Stack Overflow)
					Matrice[] t = matrixList.toArray(new Matrice[matrixList.size()]);
					
					tensore.setTensore(t);
					tensore.setIdPadre(corrente);
					tensorList.add(tensore);
					break;
				case "TensorNode":
					nodoCorrente.setChildrenTensore(tensorList);
					NodoTensore uscente = ordineNodi.pop();
					if(!ordineNodi.isEmpty()) {
						NodoTensore tmp = ordineNodi.pop();
						tmp.addNodo(uscente);
						ordineNodi.push(tmp);
						list.add(tmp);
					}
					break;
				case "TTree":
					System.out.println("Fine albero");
					break;
				}
				break;

			case XMLStreamConstants.END_DOCUMENT:
				break;

			}

		}
		
	}
	/**
	 * Crea una matrice quadrata di ordine nRighe
	 * @param list La lista da spezzare
	 * @param nRighe Il numero di righe e di colonne
	 * @return La matrice creata
	 */
	private Matrice creaMatriceDaList(Queue<Integer> list, int nRighe) {
		Queue queue = new LinkedList(list);
		Matrice m = new Matrice(queue.size() / nRighe);
		int[][] matrice = new int[nRighe][nRighe];
		
		for(int r=0; r<nRighe; r++)
			for(int c=0; c<nRighe; c++)
				matrice[r][c] = (int) queue.poll();
		
		m.setMatrice(matrice);
		
		return m;
	}
}
