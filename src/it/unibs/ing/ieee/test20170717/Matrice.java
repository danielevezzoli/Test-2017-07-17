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

	public int determinante() {
		int det=0;
		for(int i=0; i<dimensione; i++) {
			det += laplace(minore(i,0));
		}
		return 0;
	}

	private int laplace(int[][] minore) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int[][] minore(int row, int col) {
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
			System.out.println();
			if(r != row)
				i++;
		}
		return tmp;
	}
	
	
	
}
