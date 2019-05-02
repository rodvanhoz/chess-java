package aplicacao;

import xadrez.PartidaXadrez;

public class Program {

	public static void main(String[] args) {
		
		PartidaXadrez p = new PartidaXadrez();
		UI.imprimeTabuleiro(p.getPecas());
	}

}
