package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GiocoDellOca {
	
	private static GiocoDellOca instance;
	private static final int ROUND_TOTALI = 20;
	private List<Giocatore> giocatori = new ArrayList<>();
	private Tabellone tabellone = Tabellone.getInstance();
	private Dado dado = new Dado();
	private boolean finePartita;

	private GiocoDellOca(int numeroGiocatori) {
		for (int i = 1; i <= numeroGiocatori; i++) {
			Giocatore g;
			g = new Giocatore("Giocatore " + i, dado, tabellone);
			giocatori.add(g);
		}
	}
	
	public static GiocoDellOca getInstance(int numeroGiocatori) {
		if(instance == null) {
			instance = new GiocoDellOca(numeroGiocatori);
		}
		return instance;
	}
	
	public void giocaPartita() {
		for(int i = 0; i < ROUND_TOTALI; i++) {
			System.out.println("\nRound " + i);
			giocaRound();
		}
	}
	
	
	public boolean getFinePartita() {
		return finePartita;
	}
	
	public void setFinePartita(boolean b) {
		this.finePartita = b;
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
