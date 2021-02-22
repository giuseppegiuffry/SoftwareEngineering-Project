package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Casella;
import domain.GiocoDellOca;

class GiocoDellOcaTest {
	
	static GiocoDellOca giocoDellOca;
	
	@BeforeEach
	void initTest() {
		// Creo una simulazione della partita con 4 giocatori
		giocoDellOca = GiocoDellOca.getInstance(4);
	}

	@Test
	void testGetGiocatori() {
		try {
			
			// Verifico che all'inizio della partita tutti i giocatori si trovano sulla casella di partenza (indice 0)
			int numGiocatori = giocoDellOca.getGiocatori().size();
			for (int i = 0; i < numGiocatori; i++) {
				Casella casellaPartenza = giocoDellOca.getGiocatori().get(i).getPosizione();
				assertEquals(0, casellaPartenza.getIndice());
			}
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

}
