package it.unibs.ing.ieee.test20170717;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NodoTensore extends AbstractTensor{
	//Lista dei tensori figli del nodo
	private List<Tensore> childrenTensore;
	//Lista dei nodiTensore figli del nodo
	private List<NodoTensore> childrenNodoTensore;
	private char label;
	private boolean root = false;
	
	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}
	
	public NodoTensore(NodoTensore n) {
		childrenTensore = new ArrayList<>(n.getChildren());
		childrenNodoTensore = new ArrayList<>(n.getChildrenNodoTensore());
		label = n.getLabel();
	}

	public NodoTensore(char label) {
		childrenTensore = new ArrayList<>();
		childrenNodoTensore = new ArrayList<>();
		this.setId(this.hashCode());
		this.label = label;
		
	}
	/**
	 * Aggiunge un tensore al nodo
	 * @param t il tensore da aggiungere
	 */
	public void addTensore(Tensore t) {
		childrenTensore.add(t);
	} 
	
	/**
	 * Aggiunge un nodo tensore figlio al nodo
	 * @param n il nodo tensore da aggiungere
	 */
	public void addNodo(NodoTensore n) {
		childrenNodoTensore.add(n);
	}
	
	public List<Tensore> getChildren() {
		return childrenTensore;
	}

	public void setChildrenTensore(List<Tensore> tensorList) {
		this.childrenTensore = tensorList;
	}

	public NodoTensore() {}

	public char getLabel() {
		return label;
	}

	public List<NodoTensore> getChildrenNodoTensore() {
		return childrenNodoTensore;
	}

	public void setChildrenNodoTensore(List<NodoTensore> childrenNodoTensore) {
		this.childrenNodoTensore = childrenNodoTensore;
	}

	public void setLabel(char label) {
		this.label = label;
	}
	
	/**
	 * Calcola l'indice del nodo tensore in base a se è il nodo radice o meno
	 * @return l'indice del nodo
	 */
	public int calcIndice() {
		Stream<Integer> stream = childrenNodoTensore.stream().map(x -> x.getIndice());
		if(root)
			setIndice(stream.min((n1, n2) -> Integer.compare(n1, n2))
				  .get());
		else
			setIndice(stream.max((n1, n2) -> Integer.compare(n1, n2))
					  .get());
		
		return getIndice();
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer(this.getLabel() + "\n");
		
		str.append(this.getLabel());
		
		return str.toString();
	}
}
