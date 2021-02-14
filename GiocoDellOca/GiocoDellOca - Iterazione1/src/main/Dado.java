package main;

public class Dado {
	
	public static final int MAX = 6;
	private int valoreFaccia;
	
	public Dado() {
		lancia();
	}
	
	public void lancia() {
		valoreFaccia = (int) ((Math.random() * MAX) + 1);
	}
	
	public int getValoreFaccia() {
		return valoreFaccia;
	}

}
