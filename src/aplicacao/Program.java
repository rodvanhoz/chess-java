package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.XadrezPosicao;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez p = new PartidaXadrez();
		
		while (true) {
			UI.imprimeTabuleiro(p.getPecas());
			System.out.println();
			
			System.out.print("Origem: ");
			XadrezPosicao origem = UI.readXadrezPosicao(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			XadrezPosicao destino = UI.readXadrezPosicao(sc);
			
			PecaXadrez pecaCapturada = p.performXadrezMovimento(origem, destino);
		}
	}

}
