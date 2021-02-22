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
			System.out.println("------- Test Esegui Turno -------");
			
			// Posiziono il giocatore sulla casella 30, eseguo un turno e verifico che la partita non è terminata,
			// ovvero che il giocatore non si trova nella casella di arrivo con indice 62
			// Verifico anche che il giocatore si sposterà dalla sua casella iniziale in seguito al lancio del dado
			Casella casella = new CasellaRegolare("Casella", 30);
			giocatore.setPosizione(casella);
			giocatore.eseguiTurno();
			assertNotEquals(62, giocatore.getPosizione().getIndice());
			assertNotEquals(casella, giocatore.getPosizione());
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
	void testLanciaDado() {
		try {
			int valoreDado = giocatore.lanciaDado();
			assertTrue(valoreDado >= 1 && valoreDado <= 6);
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}


	@Test
	void testVaiAvanti() {
		try {
			System.out.println("\n------- Test Vai Avanti -------");
			Casella casella = new CasellaAvanti("Casella Avanti", 30, 5);
			giocatore.setPosizione(casella);
			
			// Controllo il tipo di casella su cui è arrivato il giocatore tramite il metodo polimorfo
			// Essendo su una CasellaAvanti, il giocatore chiamerà il metodo vaiAvanti
			casella.arrivatoSu(giocatore);
			assertEquals(35, giocatore.getPosizione().getIndice());
			assertNotEquals(casella, giocatore.getPosizione());
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}

	@Test
	void testVaiIndietro() {
		try {
			System.out.println("\n------- Test Vai Indietro -------");
			Casella casella = new CasellaIndietro("Casella Indietro", 50, 10);
			giocatore.setPosizione(casella);
			
			// Controllo il tipo di casella su cui è arrivato il giocatore tramite il metodo polimorfo
			// Essendo su una CasellaIndietro, il giocatore chiamerà il metodo vaiIndietro
			casella.arrivatoSu(giocatore);
			assertEquals(40, giocatore.getPosizione().getIndice());
			assertNotEquals(casella, giocatore.getPosizione());
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}

}
