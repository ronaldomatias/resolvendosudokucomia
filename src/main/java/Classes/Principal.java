package Classes;

public class Principal {

	public static void main(String[] args) {

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
		
		int[][] executar = new TemperaSimulada().executar(entrada);

		for (int linha = 0; linha < 9; linha++) {

			for (int coluna = 0; coluna < 9; coluna++) {
				System.out.print(executar[linha][coluna]);
			}
			System.out.println();
		}
		System.out.println(new TemperaSimulada().custo(executar));
	}
}
