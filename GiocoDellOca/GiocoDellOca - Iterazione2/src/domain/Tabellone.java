package domain;

import java.util.ArrayList;
import java.util.List;

public class Tabellone {
	
	private static Tabellone instance;
	public static final int DIMENSIONE = 63;
	private List<Casella> caselle = new ArrayList<>(DIMENSIONE);
	
	private Tabellone() {
		costruisciCaselle();
		collegaCaselle();
	}
	
	public static Tabellone getInstance() {
		if(instance == null) {
			instance = new Tabellone();
		}
		return instance;
	}
	
	public Casella getCasella(Casella partenza, int distanza) {
		int fineIndice = (partenza.getIndice() + distanza) % DIMENSIONE;
		return (Casella) caselle.get(fineIndice);
	}
	
	public Casella getCasellaIndietro(Casella partenza, int distanza) {
		int fineIndice = (partenza.getIndice() - distanza) % DIMENSIONE;
		return (Casella) caselle.get(fineIndice);
	}
	
	
	public Casella getCasellaPartenza() {
		return (Casella) caselle.get(0);
	}
	
	public Casella getCasellaArrivo() {
		return (Casella) caselle.get(DIMENSIONE - 1);
	}
	
	private void costruisciCaselle() {
		for(int i = 1; i <= DIMENSIONE; i++) {
			costruisci(i);
		}
		costruisciCaselleAvanti();
		costruisciCaselleIndietro();
		costruisciCasellaArrivo();
	}
	
	private void costruisci(int i) {
		Casella casella = new CasellaRegolare("Casella " + i, i - 1);
		caselle.add(casella);
	}
	
	private void costruisciCaselleAvanti() {
		Casella casellaA1 = new CasellaAvanti("CasellaAvanti 1", 11, (int) (Math.random() * 3) + 1);
		Casella casellaA2 = new CasellaAvanti("CasellaAvanti 2", 24, (int) (Math.random() * 3) + 1);
		Casella casellaA3 = new CasellaAvanti("CasellaAvanti 3", 32, (int) (Math.random() * 3) + 1);
		Casella casellaA4 = new CasellaAvanti("CasellaAvanti 4", 43, (int) (Math.random() * 3) + 1);
		Casella casellaA5 = new CasellaAvanti("CasellaAvanti 5", 56, (int) (Math.random() * 3) + 1);
		caselle.set(11, casellaA1);
		caselle.set(24, casellaA2);
		caselle.set(32, casellaA3);
		caselle.set(43, casellaA4);
		caselle.set(56, casellaA5);
	}
	
	private void costruisciCaselleIndietro() {
		Casella casellaI1 = new CasellaIndietro("CasellaIndietro 1", 7, (int) (Math.random() * 3) + 1);
		Casella casellaI2 = new CasellaIndietro("CasellaIndietro 2", 18, (int) (Math.random() * 3) + 1);
		Casella casellaI3 = new CasellaIndietro("CasellaIndietro 3", 28, (int) (Math.random() * 3) + 1);
		Casella casellaI4 = new CasellaIndietro("CasellaIndietro 4", 37, (int) (Math.random() * 3) + 1);
		Casella casellaI5 = new CasellaIndietro("CasellaIndietro 5", 50, (int) (Math.random() * 3) + 1);
		caselle.set(7, casellaI1);
		caselle.set(18, casellaI2);
		caselle.set(28, casellaI3);
		caselle.set(37, casellaI4);
		caselle.set(50, casellaI5);
	}
	
	private void costruisciCasellaArrivo() {
		Casella casellaArrivo = new CasellaArrivo("Casella Arrivo", 62);
		caselle.set(62, casellaArrivo);
	}
	
	
	
	private void collegaCaselle() {
		for(int i = 0; i < (DIMENSIONE - 1); i++) {
			collega(i);
		}
	}
	
	private void collega(int i) {
		Casella attuale = (Casella) caselle.get(i);
		Casella prossima = (Casella) caselle.get(i + 1);
		attuale.setProssimaCasella(prossima);	
	}
	
	public List<Casella> getCaselle() {
		return caselle;
	}

}
