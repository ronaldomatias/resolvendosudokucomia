import org.junit.jupiter.api.Test;

public class Testes {

	
	@Test
	public void testeCusto() {
		
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
		
		TemperaSimulada ts = new TemperaSimulada(entrada);
		
		ts.custo(entrada);
		
	}
}
