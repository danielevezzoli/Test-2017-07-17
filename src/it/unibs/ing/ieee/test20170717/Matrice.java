package it.unibs.ing.ieee.test20170717;

public class Matrice {
	private int[][] matrice;
	private int dimensione;
	private int determinante;
	
	public Matrice(int _dimensione) {
		matrice = new int[_dimensione][_dimensione];
		dimensione = _dimensione;
	}
	
	public void setMatrice(int[][] matrice) {
		this.matrice = matrice;
	}

	public int[][] getMatrice() {
		return matrice;
	}

	public int getDimensione() {
		return dimensione;
	}

	public int getDeterminante() {
		return determinante;
	}

	/**
	 * Metodo che calcola il determinante di una matrice secondo il metodo di Sarrus
	 * @return il determinante della matrice
	 */
	private int sarrus() {
		if(this.dimensione == 3)
			return (matrice[0][0]*matrice[1][1]*matrice[2][2])+(matrice[0][1]*matrice[1][2]*matrice[2][0])+(matrice[0][2]*matrice[1][0]*matrice[2][1])
					-(matrice[2][0]*matrice[1][1]*matrice[0][2])-(matrice[0][0]*matrice[2][1]*matrice[1][2])-(matrice[0][1]*matrice[1][0]*matrice[2][2]);
		if(this.dimensione == 2)
			return (matrice[0][0]*matrice[1][1]) - (matrice[1][0]*matrice[0][1]);
		else
			return matrice[0][0];
	}
	/**
	 * Funzione per il calcolo del determinante di una matrice
	 * Se matrice ha dimensione < 3 utilizza Sarrus altrimenti utilizza Laplace
	 * @param matrice La matrice di cui calcolare il determinante
	 * @return il determinante della matrice
	 */
	public int determinante(Matrice matrice) {
		int[][] m = matrice.getMatrice();
		
		int det = 0;

		
		if(matrice.getDimensione()<3)
			return sarrus();
		
		for(int r = 0; r<matrice.getDimensione(); r++) {
			int valore = matrice.getMatrice()[r][0];
			Matrice tmp = matrice.minore(r, 0);

			det +=   valore * (int) Math.pow(-1, r+2) * determinante(tmp);
			
		}
		
		determinante = det;
		return det;
			
			
		
	}
	/**
	 * Metodo che calcola il minore complementare di una matrice
	 * @param row La riga da escludere
	 * @param col La colonna da escludere
	 * @return il minore
	 */
	public Matrice minore(int row, int col) {
		int newDim = dimensione-1;
		int i,j; i = j= 0;
		int[][] tmp = new int[newDim][newDim];
		for(int r = 0; r<dimensione; r++) {
			j=0;
			for(int c=0; c <dimensione; c++) {
				if(r != row && c != col) {
					tmp[i][j] = matrice[r][c];
				}
				if(c != col)
					j++;

			}
			if(r != row)
				i++;
		}
		Matrice m = new Matrice(newDim);
		m.setMatrice(tmp);
		return m;
	}
	

	public String toString() {
		StringBuffer str = new StringBuffer();
		for (int row = 0; row < dimensione; row ++) {
		    for (int col = 0; col < dimensione; col++) {
		    	str.append(matrice[row][col] + " ");
		    }
		    str.append("\n");
		}
		return str.toString();
	}
	
}
