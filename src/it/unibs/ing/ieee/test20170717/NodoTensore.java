package it.unibs.ing.ieee.test20170717;

import java.util.ArrayList;
import java.util.List;

public class NodoTensore extends AbstractTensor{
	private List<Tensore> childrenTensore;
	private List<NodoTensore> childrenNodoTensore;
	private char label;
	
	public NodoTensore(char label) {
		childrenTensore = new ArrayList<>();
		this.setId(this.hashCode());
		this.label = label;
		
	}
	
	public void addTensore(Tensore t) {
		childrenTensore.add(t);
	} 
	
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

	public void setLabel(char label) {
		this.label = label;
	}
	
	public String toString() {
		return String.format("Nodes: %d\nTensors: %d", childrenNodoTensore.size(),childrenTensore.size());
	}
}
