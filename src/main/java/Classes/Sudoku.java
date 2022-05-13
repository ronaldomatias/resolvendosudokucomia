package Classes;

public class Sudoku {

	private static final int TAMANHO_TABULEIRO = 9;


	public static void main(String[] args) {

		int[][] tabuleiro = { 
				{ 2, 0, 0, 0, 0, 0, 0, 3, 5 }, 
				{ 0, 5, 0, 0, 1, 9, 6, 4, 0 },
				{ 0, 0, 0, 0, 4, 0, 7, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 2, 0, 6, 0 }, 
				{ 0, 4, 0, 0, 8, 1, 5, 9, 0 },
				{ 0, 0, 9, 7, 5, 0, 0, 0, 0 }, 
				{ 9, 0, 0, 8, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 2, 0, 0, 8, 0 },
				{ 0, 0, 5, 0, 0, 0, 0, 0, 3 } 
				};

		System.out.print("TABULEIRO DE ENTRADA \n");
		mostrarTabuleiro(tabuleiro);
		
		long tempoInicial = System.currentTimeMillis();
		resolverTabuleiro(tabuleiro);
		long tempoFinal = System.currentTimeMillis();
		long tempoExecucao = (tempoFinal - tempoInicial);
		
		System.out.print("TABULEIRO DE SAÍDA \n");
		mostrarTabuleiro(tabuleiro);
		System.out.println(tempoExecucao);
	}
	
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

	private static boolean resolverTabuleiro(int[][] tabuleiro) {
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