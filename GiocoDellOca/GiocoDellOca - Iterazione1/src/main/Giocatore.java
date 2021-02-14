package main;

public class Giocatore {
	
	private String nome;
	private Pedina pedina;
	private Tabellone tabellone;
	private Dado dado;
	
	public Giocatore(String nome, Dado dado, Tabellone tabellone) {
		this.nome = nome;
		this.dado = dado;
		this.tabellone = tabellone;
		pedina = new Pedina(tabellone.getCasellaPartenza());
	}
	
	public void eseguiTurno() {
		int valoreTotale = lanciaDado();
		
		Casella nuovaPosizione = tabellone.getCasella(pedina.getPosizione(), valoreTotale);
		pedina.setPosizione(nuovaPosizione);
	}
	
	private int lanciaDado() {
		int valoreTotale = 0;
		
		for(int i = 0; i < Dado.MAX; i++) {
			dado.lancia();
			valoreTotale += dado.getValoreFaccia();
		}
		return valoreTotale;
	}
	
	public Casella getPosizione() {
		return pedina.getPosizione();
	}
	
	public String getNome() {
		return nome;
	}

}
