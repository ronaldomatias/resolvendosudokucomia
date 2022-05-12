import java.util.Random;

public class TemperaSimulada {
	private float temperatura;
	private float resfriamento;
	private int[][] entrada;

	public TemperaSimulada(int[][] entrada) {
		this.entrada = entrada;
		this.temperatura = 10000.0f;
		this.resfriamento = 0.95f;
	}

	public int[][] executar() {
		
		
		Sudoku sudoku = new Sudoku();
		int[][] entrada = { 
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
		
		int[][] solucao = entrada;
		
		while (temperatura > 0.1) {

			int[][] copia = copiar(solucao);
			
			int[][] solucaoTemporaria = entrada;

			
			
			
			Integer custoSolucao = custo(solucao);
			Integer custoSolucaoTemporaria = custo(solucaoTemporaria);
			
			// calcula o custo da solução e verifica se 
			double probabilidade = Math.pow(Math.E, (-custoSolucaoTemporaria - custoSolucao) / temperatura);

			if (custoSolucaoTemporaria < custoSolucao || new Random().nextDouble() < probabilidade) {
				solucao = solucaoTemporaria;
			}
			
			temperatura = temperatura * resfriamento;
		}
		
		return solucao;

	}

	private int[][] solucaoAleatoria(int[][] solucao) {
		
		return null;
	}

	
	private int[][] copiar(int[][] solucao) {
		int[][] copia = new int[9][9];
		
		return copia;
	}

	
	public int custo(int[][] tabuleiro) {
		
		int soma = 0;
		
		for (int lin = 0; lin < 9; lin++) {
			int custo[] = new int[9];
			for (int col = 0; col < 9; col++) {
				if (custo[tabuleiro[lin][col] - 1] != 0)
					soma++;
				custo[tabuleiro[lin][col] - 1] = 1;
			}
		}
		
		for (int lin = 0; lin < 9; lin++) {
			int custo[] = new int[9];
			for (int col = 0; col < 9; col++) {
				if (custo[tabuleiro[col][lin] - 1] != 0)
					soma++;
				custo[tabuleiro[col][lin] - 1] = 1;
			}
		}
		
		return soma;
	}
}
