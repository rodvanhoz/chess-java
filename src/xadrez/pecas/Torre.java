package xadrez.pecas;

import boardgame.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movtosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return mat;
	}
}
