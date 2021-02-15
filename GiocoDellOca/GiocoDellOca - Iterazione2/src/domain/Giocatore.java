package domain;

public class Giocatore {
	
	private String nome;
	private Casella posizione;
	private Tabellone tabellone;
	private Dado dado;
	
	public Giocatore(String nome, Dado dado, Tabellone tabellone) {
		this.nome = nome;
		posizione = tabellone.getCasellaPartenza();
		this.dado = dado;
		this.tabellone = tabellone;
	}
	
	public Giocatore(String nome) {
		this.nome = nome;
	}
	
	public void eseguiTurno() {
		int valoreDado = lanciaDado();
		
		int posAttuale = getPosizione().getIndice();
		int posNuova = posAttuale + valoreDado;
		
		System.out.print(nome + " è nella casella " + posAttuale + ".");
		System.out.println(" Lancia " + valoreDado + " e raggiunge la casella " + posNuova);
		
		Casella nuovaCasella = tabellone.getCasella(getPosizione(), valoreDado);
		
		setPosizione(nuovaCasella);
		
		nuovaCasella.arrivatoSu(this);
		
		if(posNuova > 62) {
			finePartita();
		}
		
	}
	
	public int lanciaDado() {
		int valoreDado = 0;
		
		dado.lancia();
		valoreDado += dado.getValoreFaccia();
		return valoreDado;
	}
	
	public Casella getPosizione() {
		return posizione;
	}
	
	public void setPosizione(Casella posizione) {
		this.posizione = posizione;
	}
	
	public void vaiAvanti(int numeroCaselle) {
		
		int posAttuale = getPosizione().getIndice();
		int posNuova = posAttuale + numeroCaselle;
		
		System.out.println(nome + " ha raggiunto una CasellaAvanti. Va avanti di " + numeroCaselle + " casella/e. "
				+ "Raggiunge la casella " + posNuova);
		
		Casella nuovaCasella = tabellone.getCasella(getPosizione(), numeroCaselle);
		
		setPosizione(nuovaCasella);
			
	}
	
	public void vaiIndietro(int numeroCaselle) {
		
		int posAttuale = getPosizione().getIndice();
		int posNuova = posAttuale - numeroCaselle;
		
		System.out.println(nome + " ha raggiunto una CasellaIndietro. Torna indietro di " + numeroCaselle + " casella/e. "
				+ "Raggiunge la casella " + posNuova);
		
		Casella nuovaCasella = tabellone.getCasellaIndietro(getPosizione(), numeroCaselle);
		
		setPosizione(nuovaCasella);
	
	}
	
	public void finePartita() {
		System.out.println("\n" + nome + " ha raggiunto (o superato) la casella di arrivo (62) e ha vinto la partita!");
		System.exit(0);
	}
	
	public String getNome() {
		return nome;
	}

}
