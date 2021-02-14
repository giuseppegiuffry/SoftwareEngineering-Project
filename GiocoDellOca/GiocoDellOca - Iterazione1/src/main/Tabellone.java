package main;

import java.util.ArrayList;
import java.util.List;

public class Tabellone {
	
	private static final int DIMENSIONE = 63;
	private List<Casella> caselle = new ArrayList<Casella>(DIMENSIONE);
	
	public Tabellone() {
		costruisciCaselle();
		collegaCaselle();
	}
	
	public Casella getCasella(Casella partenza, int distanza) {
		int fineIndice = (partenza.getIndice() + distanza) % DIMENSIONE;
		return (Casella) caselle.get(fineIndice);
	}
	
	public Casella getCasellaPartenza() {
		return (Casella) caselle.get(0);
	}
	
	private void costruisciCaselle() {
		for(int i = 1; i <= DIMENSIONE; i++) {
			costruisci(i);
		}
	}
	
	private void costruisci(int i) {
		Casella c = new Casella("Casella " + i, i - 1);
		caselle.add(c);
	}
	
	private void collegaCaselle() {
		for(int i = 0; i < (DIMENSIONE - 1); i++) {
			collega(i);
		}
		/*
		Casella prima = (Casella) caselle.get(0);
		Casella ultima = (Casella) caselle.get(DIMENSIONE - 1);
		ultima.setProssimaCasella(prima);
		*/
	}
	
	private void collega(int i) {
		Casella attuale = (Casella) caselle.get(i);
		Casella prossima = (Casella) caselle.get(i + 1);
		attuale.setProssimaCasella(prossima);	
	}

}
