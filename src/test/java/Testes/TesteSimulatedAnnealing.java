package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Classes.TemperaSimulada;

public class TesteSimulatedAnnealing {
	
	private TemperaSimulada temperaSimulada;
	private int[][] entrada;
	
	@Before
	public void configuracoes() {
		
		temperaSimulada = new TemperaSimulada();
		
		entrada = new int[][]{ 
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
	}
	
	
	@Test
	public void testeFuncaoCusto() {
		
		assertEquals(55, temperaSimulada.custo(entrada));
	}

	
	@Test
	public void testeTemperaSimulada() {
		
		int[][] tabuleiro = temperaSimulada.executar(entrada);

		temperaSimulada.mostrarTabuleiro(tabuleiro);
		
		System.out.println(new TemperaSimulada().custo(tabuleiro));
	}
	
	
}
