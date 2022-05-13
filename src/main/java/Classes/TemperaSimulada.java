package Classes;

import java.util.Random;

public class TemperaSimulada {
	
	private float temperatura;
	private float resfriamento;

	public TemperaSimulada() {
		
		this.temperatura = 10000000000000000000000.0f;
		this.resfriamento = 0.998f;
	}

	
	public int[][] executar(int[][] entrada) {

		int[][] tabuleiroEntrada = entrada;
		int[][] solucao = copiar(tabuleiroEntrada);

		
		while (temperatura > 0.1) {

			int[][] copia = copiar(solucao);

			int[][] solucaoTemporaria = gerarVizinho(copia, tabuleiroEntrada);

			Integer custoSolucao = custo(solucao);
			Integer custoSolucaoTemporaria = custo(solucaoTemporaria);

			double probabilidade = Math.pow(Math.E, (-custoSolucaoTemporaria - custoSolucao) / temperatura);

			if (custoSolucaoTemporaria < custoSolucao || new Random().nextDouble() < probabilidade) {
				solucao = solucaoTemporaria;
			}

			temperatura = temperatura * resfriamento;
		}

		return solucao;
	}

	private int[][] gerarVizinho(int[][] solucao, int[][] tabuleiroEntrada) {

		int linha = new Random().nextInt(9);
		int coluna = new Random().nextInt(9);
		int valorCandidato = new Random().nextInt(9) + 1;

		if (ehUmPosicionamentoValido(tabuleiroEntrada, solucao, linha, coluna, valorCandidato)) {
			solucao[linha][coluna] = valorCandidato;
		}

		return solucao;
	}

	private int[][] copiar(int[][] solucao) {

		int[][] copia = new int[9][9];

		for (int linha = 0; linha < 9; linha++) {
			for (int coluna = 0; coluna < 9; coluna++) {
				copia[linha][coluna] = solucao[linha][coluna];
			}
		}

		return copia;
	}

	public int custo(int[][] tabuleiro) {
		
		int soma = 0;

		for (int linha = 0; linha < 9; linha++) {
			for (int coluna = 0; coluna < 9; coluna++) {
				if (tabuleiro[linha][coluna] == 0) {
					soma++;
				}
			}
		}

		return soma;
	}

	public void mostrarTabuleiro(int[][] tabuleiro) {

		for (int linha = 0; linha < 9; linha++) {

			for (int coluna = 0; coluna < 9; coluna++) {
				System.out.print(tabuleiro[linha][coluna]);
			}
			System.out.println();
		}
	}

	private boolean ehUmPosicionamentoValido(int[][] tabuleiroEntrada, int[][] tabuleiroAtual, int linha, int coluna, int valorCandidato) {

		if (	tabuleiroEntrada[linha][coluna] == 0 
				&& !numeroExisteNaLinha(tabuleiroAtual, valorCandidato, linha) 
				&& !numeroExisteNaColuna(tabuleiroAtual, valorCandidato, coluna)
				&& !numeroExisteNoTabuleiroLocal(tabuleiroAtual, valorCandidato, linha, coluna)) {
				
			return true;
		}
		
		return false;
	}

	private boolean numeroExisteNaLinha(int[][] tabuleiro, int numeroParaTentativa, int linha) {
		
		for (int coluna = 0; coluna < 9; coluna++) {
			if (tabuleiro[linha][coluna] == numeroParaTentativa) {
				return true;
			}
		}

		return false;
	}

	private boolean numeroExisteNaColuna(int[][] tabuleiro, int numeroParaTentativa, int coluna) {
		
		for (int i = 0; i < 9; i++) {
			if (tabuleiro[i][coluna] == numeroParaTentativa) {
				return true;
			}
		}

		return false;
	}

	private boolean numeroExisteNoTabuleiroLocal(int[][] tabuleiro, int numeroParaTentativa, int linha, int coluna) {
		
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

}

