package domain;

public class CasellaArrivo extends Casella {
	
	public CasellaArrivo(String nome, int indice) {
		super(nome, indice);	
	}
	
	public void arrivatoSu(Giocatore g) {
		g.finePartita();
	}

}
