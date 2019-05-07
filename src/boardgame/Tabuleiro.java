package boardgame;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new BoardException("Erro ao criar o tabuleiro. Deverá ser criado pelo menos com tamanho de 1 x 1");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Peca peca(int linha, int coluna) {
		if (!posicaoExists(linha, coluna)) {
			throw new BoardException("Posição fora do tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if (!posicaoExists(posicao)) {
			throw new BoardException("Posição fora do tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public Peca removePeca(Posicao posicao) {
		if (!posicaoExists(posicao)) {
			throw new BoardException("Posição inválida no tabuleiro");
		}
		if (peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}	
	
	public void PosicaoPeca(Peca peca, Posicao posicao) {
		if (isPeca(posicao)) {
			throw new BoardException("Já existe uma peça na posição " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean posicaoExists(int linha, int coluna) {
		return linha >= 0 && linha <= linhas && coluna >= 0 && coluna <= colunas;
	}
	
	public boolean posicaoExists(Posicao posicao) {
		return posicaoExists(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean isPeca(Posicao posicao) {
		if (!posicaoExists(posicao)) {
			throw new BoardException("Posição fora do tabuleiro");
		}
		return peca(posicao) != null;	
	}
}
