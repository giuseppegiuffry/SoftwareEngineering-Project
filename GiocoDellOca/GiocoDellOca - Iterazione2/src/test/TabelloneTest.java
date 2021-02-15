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
		tabellone = new Tabellone();
	}

	@Test
	void testGetCasella() {
		try {
			Casella casellaPartenza = new CasellaRegolare("Casella", 1);
			Casella casellaArrivo = tabellone.getCasella(casellaPartenza, 5);
			for(int i = 0; i < tabellone.DIMENSIONE; i++) {
				System.out.println(tabellone.getCaselle().get(i).getNome());
			}
			assertEquals(6, casellaArrivo.getIndice());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}
	

}
