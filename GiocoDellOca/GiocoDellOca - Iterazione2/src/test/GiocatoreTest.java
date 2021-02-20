package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Casella;
import domain.CasellaAvanti;
import domain.CasellaIndietro;
import domain.CasellaRegolare;
import domain.Dado;
import domain.Giocatore;
import domain.Tabellone;

class GiocatoreTest {
	
	static Giocatore giocatore;
	
	@BeforeEach
	void initTest() {
		giocatore = new Giocatore("Giocatore", new Dado(), Tabellone.getInstance());
	}

	@Test
	void testEseguiTurno() {
		try {
			
			//Posiziono il giocatore sulla casella 30, eseguo un turno e verifico che la partita non è terminata
			Casella casella = new CasellaRegolare("Casella", 30);
			giocatore.setPosizione(casella);
			giocatore.eseguiTurno();
			assertNotEquals(62, giocatore.getPosizione().getIndice());
			
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}

	@Test
	void testGetPosizione() {
		try {
			Casella casella = new CasellaRegolare("Casella", 20);
			giocatore.setPosizione(casella);
			assertEquals(casella, giocatore.getPosizione());
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}


	@Test
	void testVaiAvanti() {
		try {
			Casella casella = new CasellaAvanti("Casella Avanti", 30, 5);
			giocatore.setPosizione(casella);
			giocatore.vaiAvanti(5);
			assertEquals(35, giocatore.getPosizione().getIndice());
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}

	@Test
	void testVaiIndietro() {
		try {
			Casella casella = new CasellaIndietro("Casella Indietro", 50, 10);
			giocatore.setPosizione(casella);
			giocatore.vaiIndietro(10);
			assertEquals(40, giocatore.getPosizione().getIndice());
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}

}
