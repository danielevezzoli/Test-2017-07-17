package it.unibs.ing.ieee.test20170717;

import java.util.ArrayList;
import java.util.List;

public class NodoTensore extends AbstractTensor{
	private List<AbstractTensor> children;
	
	public NodoTensore(int dimensione) {
		children = new ArrayList<>();
		this.setId(this.hashCode());
	}
}
