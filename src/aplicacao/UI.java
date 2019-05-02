package aplicacao;

import xadrez.PecaXadrez;

public class UI {

	public static void imprimeTabuleiro(PecaXadrez[][] p) {
		for (int i = 0; i < p.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < p[i].length; j ++) {
				imprimePeca(p[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("  a b c d e f g h");
		
	}
	
	private static void imprimePeca(PecaXadrez p) {
		if (p == null) {
			System.out.print("-");
		}
		else {
			System.out.print(p);
		}
		
		System.out.print(" ");
	}
}
