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
		for(int i = 0; i < DIMENSIONE; i++) {
			costruisci(i);
		}
	}
	
	private void costruisci(int i) {
		switch (i) {
		case 11:
		case 24:
		case 32:
		case 43:
		case 56:
			Casella casellaAvanti = new CasellaAvanti("CasellaAvanti", i, (int) (Math.random() * 3) + 1);
		    caselle.add(i, casellaAvanti);
			break;
		case 7:
		case 18:
		case 28:
		case 37:
		case 50:
			Casella casellaIndietro = new CasellaIndietro("CasellaIndietro", i, (int) (Math.random() * 3) + 1);
		    caselle.add(i, casellaIndietro);
			break;
		case 62:
			Casella casellaArrivo = new CasellaArrivo("Casella Arrivo", i);
			caselle.add(i, casellaArrivo);
			break;
		default:
			Casella casellaRegolare = new CasellaRegolare("Casella " + (i+1), i);
			caselle.add(i, casellaRegolare);
			break;
		}
		
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
