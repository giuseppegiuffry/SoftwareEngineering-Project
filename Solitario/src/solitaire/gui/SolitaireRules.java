package solitaire.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SolitaireRules {
	
	public static void display(String title, String message) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Solitario - Regole");
		window.setMinWidth(600);
		window.setMinHeight(500);
		window.setMaxWidth(600);
		
		TextArea textArea = new TextArea();
		textArea.setMinWidth(600);
		textArea.setMinHeight(500);
		textArea.setEditable(false);
		
		String rules = "Scopo del gioco\r\n"
					+ "\r\n"
					+ "Lo scopo del Solitario � di formare quattro pile di carte, le carte vanno spostate dalle colonne \r\n"
					+ "alle 4 basi libere. Ogni pila deve essere dello stesso seme. Inoltre le carte devono essere disposte \r\n"
					+ "in ordine, dall'Asso al Re (A-2-3-4-5-6-7-8-9-10-Fante-Dama-Re).\r\n"
					+ "\r\n"
					+ "Come spostare le carte\r\n"
					+ "\r\n"
					+ "Le carte possono essere spostate dalle colonne secondo le regole seguenti: Si pu� aggiungere una \r\n"
					+ "carta sopra un'altra carta scoperta se la carta che si vuole aggiungere � di colore diverso e di un \r\n"
					+ "valore immediatamente inferiore. Ad esempio: se in una determinata colonna l'ultima carta aperta � \r\n"
					+ "un 8 di fiori � possibile posizionare un 7 rosso (un 7 di cuori o 7 di quadri, il seme non � \r\n"
					+ "importante, conta soltanto il colore) sopra a questa. Sopra il 7 rosso sar� possibile attaccarvi \r\n"
					+ "un 6 nero, e cos� via.\r\n"
					+ "\r\n"
					+ "Le carte possono essere spostate da colonna a colonna, singolarmente o in gruppo (a patto che il \r\n"
					+ "giusto ordine non venga rispettato). Se quindi in una colonna ci sono un 4 rosso, un 5 nero e un 6 \r\n"
					+ "rosso impilati uno al di sotto dell'altro essi possono essere tutti e tre trasferiti (in una volta \r\n"
					+ "sola) al di sotto di un 7 nero.\r\n"
					+ "\r\n"
					+ "Se una carta in una delle colonne viene esposta in quel punto si scoprir� automaticamente un'altra \r\n"
					+ "carta, fino a quando la colonna resta vuota e quando ve ne � 1 completamente vuota per poter \r\n"
					+ "cominciare una nuova colonna vi potrai mettere soltanto un Re (o un gruppo di carte con un Re in \r\n"
					+ "cima).\r\n"
					+ "\r\n"
					+ "Alla fine lo scopo del Solitario � di poter impilare tutte le carte in ordine crescente sulle \r\n"
					+ "quattro basi (stack). Ogni pila di carte (stack) deve partire con un Asso. Se poi si libera un'altra \r\n"
					+ "carta di valore immediatamente superiore (e dello stesso seme), la si pu� mettere sopra l'Asso al \r\n"
					+ "fine di ottenere una pila dello stesso seme. Ad esempio, dopo aver messo l'asso di picche su uno \r\n"
					+ "stack vuoto sar� possibile in seguito mettervi sopra un due di picche, poi un tre di picche sul due,\r\n"
					+ "ecc. fino a quando la base (stack) sar� completa.\r\n"
					+ "\r\n"
					+ "Dopo che hai messo una carta in una delle basi la puoi rimettere, se necessario, nelle colonne.\r\n"
					+ "\r\n"
					+ "Come si usano le carte non utilizzate (stock)?\r\n"
					+ "\r\n"
					+ "Quando non � pi� possibile spostare le carte nelle colonne si vanno a vedere le carte rimaste nello \r\n"
					+ "stock. Stiamo spiegando un gioco che distribuisce 3 carte, come nel Solitario originale. \r\n"
					+ "E' possibile anche giocare con 1 carta, per questa variante si pu� guardare il capitolo sulle \r\n"
					+ "varianti del gioco.\r\n"
					+ "\r\n"
					+ "Nella versione in cui si distribuiscono 3 carte, accanto allo stock sono presenti 3 carte l'una \r\n"
					+ "sull'altra. La terza carta di queste 3 � la carta che pu� essere spostata. Le altre due carte non \r\n"
					+ "si possono usare, ma possono essere guardate. La carta che si trova al di sopra dello stock pu� \r\n"
					+ "essere spostata nelle colonne o nella base (stack), se possibile.\r\n"
					+ "\r\n"
					+ "Se non si possono usare le carte che sono aperte, se ne possono girare tre extra. Questo lo si pu� \r\n"
					+ "fare illimitatamente. Se hai avuto tutte le carte dello stock, rigira semplicemente tutte le carte \r\n"
					+ "e ricomincia di nuovo da sopra. Attenzione! Le carte per� non verranno mescolate di nuovo.\r\n"
					+ "\r\n"
					+ "Vincere a Solitario\r\n"
					+ "\r\n"
					+ "Il gioco continua ad andare avanti fino a quando non si saranno riempite tutte le 4 basi (stack) o \r\n"
					+ "fino a quando le carte da spostare non saranno finite. Avrai vinto se tutte le carte saranno state \r\n"
					+ "messe nelle loro basi che quindi saranno complete.";
		
		textArea.appendText(rules);
		textArea.positionCaret(0);
		
		StackPane layout = new StackPane();
		layout.getChildren().addAll(textArea);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 600, 500);
		window.setScene(scene);
		window.showAndWait();
			
	}
	

}
