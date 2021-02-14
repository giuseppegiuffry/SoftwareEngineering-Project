package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GiocoDellOca {
	
	private static final int NUM_GIOCATORI = 6;
	private static final int ROUND_TOTALI = 20;
	private List<Giocatore> giocatori = new ArrayList<Giocatore>(NUM_GIOCATORI);
	private Tabellone tabellone = new Tabellone();
	private Dado dado = new Dado();
	
	public GiocoDellOca() {
		for(int i = 1; i <= NUM_GIOCATORI; i++) {
			Giocatore g;
			g = new Giocatore("Giocatore " + i, dado, tabellone);
			giocatori.add(g);
		}
	}
	
	public void iniziaGioco() {
		for(int i = 0; i < ROUND_TOTALI; i++) {
			giocaRound();
		}
	}
	
	public List<Giocatore> getGiocatori() {
		return giocatori;
	}
	
	private void giocaRound() {
		for(Iterator<Giocatore> iterator = giocatori.iterator(); iterator.hasNext(); ) {
			Giocatore giocatore = (Giocatore) iterator.next();
			giocatore.eseguiTurno();
		}
	}

}
