package Classes;

import java.util.ArrayList;
import java.util.List;

public class FormatarEntradas {

	
	public List<int[][]>  formatarEntradas(){

		String entradas = "000000010400000000020000000000050407008000300001090000300400200050100000000806000000000010400000000020000000000050604008000300001090000300400200050100000000807000000000012000035000000600070700000300000400800100000000000120000080000040050000600000000012003600000000007000410020000000500300700000600280000040000300500000000000000000012008030000000000040120500000000004700060000000507000300000620000000100000000000012040050000000009000070600400000100000000000050000087500601000300200000000000000012050400000000000030700600400001000000000080000920000800000510700000003000000000012300000060000040000900000500000001070020000000000350400001400800060000000000000012400090000000000050070200000600000400000108000018000000000030700502000000000000012500008000000700000600120000700000450000030000030000800000500700020000000000000012700060000000000050080200000600000400000109000019000000000030800502000000000000012800040000000000060090200000700000400000501000015000000000030900602000000000000012980000000000600000100700080402000000000300600070000300050040000000010000000000013000030080070000000000206000030000900000010000600500204000400700100000000000000013000200000000000080000760200008000400010000000200000750600340000000008000000000013000500070000802000000400900107000000000000200890000050040000600000010000000000013000700060000508000000400800106000000000000200740000050020000400000010000000000013000700060000509000000400900106000000000000200740000050080000400000010000000000013000800070000502000000400900107000000000000200890000050040000600000010000000000013020500000000000000103000070000802000004000000000340500670000200000010000000000013040000080200060000609000400000800000000300000030100500000040706000000000000000013040000080200060000906000400000800000000300000030100500000040706000000000";
		int qtdTabuleiros = entradas.length()/81;
		
		List<int[][]> tabuleiros = new ArrayList<int[][]>();

		int contador = 0, caractere = 0;
		
		while(contador < qtdTabuleiros) {
			
			int[][] tabuleiro = new int[9][9];
			
			for (int linha = 0; linha < 9; linha++) {
				for (int coluna = 0; coluna < 9; coluna++) {
					
					tabuleiro[linha][coluna] = entradas.charAt(caractere) - 48;
					
					caractere++;
				}
			}
			
			tabuleiros.add(tabuleiro);
			contador++;
		}
		
		return tabuleiros;
	}
	
	
	
	

}
