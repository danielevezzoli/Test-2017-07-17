package it.unibs.ing.ieee.test20170717;

public abstract class AbstractTensor {
	private int indice;
	private int id;
	private int idPadre;
	
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
	}
	public int getIndice() {
		return indice;
	}
	public int getId() {
		return id;
	}
	public int getIdPadre() {
		return idPadre;
	}
	
	
	
}
