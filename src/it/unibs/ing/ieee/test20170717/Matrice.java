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
//			
		}
		return 0;
	}

	public int laplace(Matrice matrice) {
		int[][] m = matrice.getMatrice();
		
		int det = 0;
		
		if(matrice.getDimensione()==1)
			return matrice.getMatrice()[0][0];
		
		for(int r = 0; r<matrice.getDimensione(); r++) {
			int valore = matrice.getMatrice()[r][0];
			Matrice tmp = matrice.minore(r, 0);
			
//			tmp.print();
//			System.out.println("\n\n\n");
			det +=   valore * (int) Math.pow(-1, r+2) * laplace(tmp);
			
		}
		
		return det;
			
			
		
	}

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
	

	public void print() {
		for (int row = 0; row < dimensione; row ++) {
		    for (int col = 0; col < dimensione; col++) {
		    	System.out.print(matrice[row][col] + " ");
		    }
		    System.out.println();
		}
	}
	
}
