package domain;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			int numGiocatori = 0;
			System.out.println("--------------------- Benvenuto al Gioco dell'Oca! ---------------------\n");
			do {
				System.out.println("Inserisci il numero di giocatori (2-6): ");
				while(!scanner.hasNextInt()) {
					System.out.println("Non hai inserito un numero, riprova!");
					scanner.next();
				}
				numGiocatori = scanner.nextInt();
			} while(numGiocatori < 2 || numGiocatori > 6);
			
			System.out.println("Hai scelto di avviare una simulazione con " + numGiocatori + " giocatori");
			
			GiocoDellOca giocoDellOca = GiocoDellOca.getInstance(numGiocatori);
			
			giocoDellOca.giocaPartita();
		}
	}

}
