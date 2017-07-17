package it.unibs.ing.ieee.test20170717;

public class Tensore extends AbstractTensor{
	private Matrice[] tensore;
	
	public Tensore(int dimensione) {
		tensore = new Matrice[dimensione];
		this.setId(this.hashCode());
	}
}
