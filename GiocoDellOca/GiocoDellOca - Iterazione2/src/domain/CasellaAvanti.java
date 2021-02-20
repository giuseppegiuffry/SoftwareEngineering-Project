package domain;

public class CasellaAvanti extends Casella {
	
	private int numeroCaselle;

	public CasellaAvanti(String nome, int indice, int numeroCaselle) {
		super(nome, indice);
		this.numeroCaselle = numeroCaselle;
	}
	
	public void arrivatoSu(Giocatore g) {
		g.vaiAvanti(numeroCaselle); 
	}

}
