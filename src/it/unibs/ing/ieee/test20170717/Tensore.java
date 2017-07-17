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
	
	@Override
	public int getIndice() {
		this.setIndice(this.calcolaIndice());
		return getIndice();
	}
	/**
	 * Calcola l'indice del nodo
	 * @return l'indice del nodo
	 */
	public int calcolaIndice() {
		int indice = 0;
		for(Matrice m : tensore)
			indice += m.determinante(m);
		
		return indice;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(tensore.length);
//		for (Matrice matrice : tensore) {
//			str.append(matrice + "\n");
//		}
//		str.append("____________________________");
		return str.toString();
	}
}
