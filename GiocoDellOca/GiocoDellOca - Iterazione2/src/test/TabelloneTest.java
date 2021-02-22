package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Casella;
import domain.CasellaRegolare;
import domain.Tabellone;

class TabelloneTest {
	
	static Tabellone tabellone;
	
	@BeforeEach
	void initTest() {
		tabellone = Tabellone.getInstance();
	}

	@Test
	void testGetCasella() {
		try {
			// Verifico che il metodo mi fa spostare dalla casella con indice 1 alla casella con indice (1+5),
			// dove 5 rappresenta il valore del dado lanciato
			Casella casellaPartenza = new CasellaRegolare("Casella", 1);
			Casella casellaArrivo = tabellone.getCasella(casellaPartenza, 5);
			
			assertEquals(6, casellaArrivo.getIndice());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}
	
	@Test
	void testGetCasellaPartenza() {
		try {
			Casella casellaPartenza = tabellone.getCasellaPartenza();
			assertEquals("Casella 1", casellaPartenza.getNome());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}
	
	@Test
	void testGetCasellaArrivo() {
		try {
			Casella casellaArrivo = tabellone.getCasellaArrivo();
			assertEquals("Casella Arrivo", casellaArrivo.getNome());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}
	
}
