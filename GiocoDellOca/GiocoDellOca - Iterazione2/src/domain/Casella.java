package domain;

public abstract class Casella {
	
	private String nome;
	private Casella prossimaCasella;
	private int indice;
	
	public Casella(String nome, int indice) {
		this.nome = nome;
		this.indice = indice;
	}
	
	public void setProssimaCasella(Casella c) {
		prossimaCasella = c;
	}
	
	public Casella getProssimaCasella() {
		return prossimaCasella;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public boolean equals(Casella casella) {
		if(this.indice == casella.indice) {
			return true;
		}
		return false;
	}
	
	public abstract void arrivatoSu(Giocatore g);

}
