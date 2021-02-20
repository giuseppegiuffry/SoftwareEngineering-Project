package domain;

public class CasellaIndietro extends Casella {
	
	private int numeroCaselle;

	public CasellaIndietro(String nome, int indice, int numeroCaselle) {
		super(nome, indice);
		this.numeroCaselle = numeroCaselle;
	}
	
	public void arrivatoSu(Giocatore g) {
		g.vaiIndietro(numeroCaselle);
	}

}
