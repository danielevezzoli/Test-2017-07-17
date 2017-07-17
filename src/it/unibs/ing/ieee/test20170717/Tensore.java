package it.unibs.ing.ieee.test20170717;

public class Tensore extends AbstractTensor{
	private Matrice[] tensore;
	
	public Tensore(int dimensione) {
		tensore = new Matrice[dimensione];
		this.setId(this.hashCode());
	}
	
	public Tensore() {}
	
	public Matrice[] getTensore() {
		return tensore;
	}

	public void setTensore(Matrice[] tensore) {
		this.tensore = tensore;
	}

	public int calcolaIndice() {
		int indice = 0;
		for(Matrice m : tensore)
			indice += m.laplace(m);
		
		return indice;
	}
}
