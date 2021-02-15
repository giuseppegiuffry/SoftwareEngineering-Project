package domain;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numGiocatori = 0;
		do {
			System.out.println("Inserisci il numero di giocatori (2-6): ");
			while(!scanner.hasNextInt()) {
				System.out.println("Non hai inserito un numero!");
				scanner.next();
			}
			numGiocatori = scanner.nextInt();
		} while(numGiocatori < 2 || numGiocatori > 6);
		
		System.out.println("Hai scelto di giocare con " + numGiocatori + " giocatori");
		
		GiocoDellOca giocoDellOca = new GiocoDellOca(numGiocatori);
		
		giocoDellOca.giocaPartita();
		

	}

}
