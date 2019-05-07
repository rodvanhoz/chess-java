package xadrez;

import boardgame.BoardException;
import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		configuracaoInicial();
	}
	
	public PecaXadrez[][] getPecas() {
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i ++) {
			for (int j = 0; j < tabuleiro.getColunas(); j ++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		
		return mat;
	}
	
	public PecaXadrez performXadrezMovimento(XadrezPosicao origemPosicao, XadrezPosicao destinoPosicao) {
		Posicao origem  = origemPosicao.toPosicao();
		Posicao destino = destinoPosicao.toPosicao();
		
		validarSourcePosicao(origem);
		
		Peca pecaCapturada = fazerMovto(origem, destino);
		return (PecaXadrez) pecaCapturada;
	}
	
	private void validarSourcePosicao(Posicao posicao) {
		if (!tabuleiro.isPeca(posicao)) {
			throw new BoardException("Peça fora do tabuleiro");
		}
	}
	
	private Peca fazerMovto(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		
		tabuleiro.PosicaoPeca(p, destino);
		return pecaCapturada;
	}
	
	private void posicaoNovaPeca(char coluna, int linha, PecaXadrez pecaXadrez) {
		tabuleiro.PosicaoPeca(pecaXadrez, new XadrezPosicao(coluna, linha).toPosicao());
	}
	
	private void configuracaoInicial() {
		posicaoNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		posicaoNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		posicaoNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		posicaoNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		posicaoNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		posicaoNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		posicaoNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		posicaoNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		posicaoNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		posicaoNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		posicaoNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		posicaoNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));		
	}
}
