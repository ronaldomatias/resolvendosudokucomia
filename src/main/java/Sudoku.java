import java.io.IOException;

public class Sudoku {

	private static final int TAMANHO_TABULEIRO = 9;


	private static void mostrarTabuleiro(int[][] tabuleiro) {

		for (int linha = 0; linha < TAMANHO_TABULEIRO; linha++) {

			for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
				System.out.print(tabuleiro[linha][coluna]);
			}
			System.out.println();
		}
	}

	private static boolean numeroExisteNaLinha(int[][] tabuleiro, int numeroParaTentativa, int linha) {
		for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
			if (tabuleiro[linha][coluna] == numeroParaTentativa) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean numeroExisteNaColuna(int[][] tabuleiro, int numeroParaTentativa, int coluna) {
		for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
			if (tabuleiro[i][coluna] == numeroParaTentativa) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean numeroExisteNoTabuleiroLocal(int[][] tabuleiro, int numeroParaTentativa, int linha, int coluna) {
		int linhaTabuleiroLocal = linha - (linha % 3);
		int colunaTabuleiroLocal = coluna - (coluna % 3);

		for (int linhaLocal = linhaTabuleiroLocal; linhaLocal < linhaTabuleiroLocal + 3; linhaLocal++) {
			for (int colunaLocal = colunaTabuleiroLocal; colunaLocal < colunaTabuleiroLocal + 3; colunaLocal++) {
				if (tabuleiro[linhaLocal][colunaLocal] == numeroParaTentativa) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static boolean ehUmPosicionamentoValido(int[][] tabuleiro, int numeroParaTentativa, int linha, int coluna) {
		return !numeroExisteNaLinha(tabuleiro, numeroParaTentativa, linha) && !numeroExisteNaColuna(tabuleiro, numeroParaTentativa, coluna)
				&& !numeroExisteNoTabuleiroLocal(tabuleiro, numeroParaTentativa, linha, coluna);
	}

	
	public boolean resolverTabuleiro(int[][] tabuleiro){
		for (int linha = 0; linha < TAMANHO_TABULEIRO; linha++) {
			
			for (int coluna = 0; coluna < TAMANHO_TABULEIRO; coluna++) {
				
				if (tabuleiro[linha][coluna] == 0) {
					for (int numeroParaTentativa = 1; numeroParaTentativa <= TAMANHO_TABULEIRO; numeroParaTentativa++) {
						
						if (ehUmPosicionamentoValido(tabuleiro, numeroParaTentativa, linha, coluna)) {
							tabuleiro[linha][coluna] = numeroParaTentativa;
							
							if (resolverTabuleiro(tabuleiro)) {
								return true;
							} else {
								tabuleiro[linha][coluna] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		
		return true;
	}

	
}