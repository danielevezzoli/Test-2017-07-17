package it.unibs.ing.ieee.test20170717;

public class MainTest {

	public static void main(String[] args) {
		Matrice m = new Matrice(4);
		int[][] table = new int[4][4];
		int n=1;
		for (int row = 0; row < 4; row ++)
		    for (int col = 0; col < 4; col++) {
		        table[row][col] = n;
		        n++;
		    }
		
		for (int row = 0; row < 4; row ++) {
		    for (int col = 0; col < 4; col++)
		    	System.out.print(table[row][col]+"  ");
		    System.out.println();
		}
		
		m.setMatrice(table);
		table = m.minore(1, 2);
		
		for (int row = 0; row < 3; row ++) {
		    for (int col = 0; col < 3; col++)
		    	System.out.print(table[row][col]);
		    System.out.println();
		}
		
	}

}
