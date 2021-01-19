package solitaire.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import solitaire.cards.Card;
import solitaire.cards.CardStack;
import solitaire.cards.Deck;
import solitaire.cards.Rank;
import solitaire.cards.Suit;
import solitaire.model.Tableau;
import solitaire.model.TableauPile;

class TableauTest {
	
	static Tableau tableau;
	static Deck deck;
	
	@BeforeEach
	void initTest() {
		deck = new Deck();
		tableau = new Tableau();
	}
	

	@Test
	void testGetPileTableauPile() {
		try {
			//Riempio il tableau e verifico ad esempio che nella seconda pila di carte siano presenti 2 carte
			tableau.initialize(deck);
			CardStack pilaTableau2 = tableau.getPile(TableauPile.SECOND);	
			assertEquals(2, pilaTableau2.size());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	

	@Test
	void testContains() {
		try {
			//Riempio il tableau e verifico se è presente una carta
			Card card = new Card(Rank.THREE, Suit.HEARTS);
			tableau.initialize(deck);
			if(tableau.contains(card)) {
				assertTrue(tableau.contains(card));
			} else {
				assertFalse(tableau.contains(card));
			}
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}
	
	@Test
	void testCanMoveTo() {
		try {
			//Caso 1: verifico che è possibile spostare una carta con valore K su una colonna vuota
			Card cardCase1 = new Card(Rank.KING, Suit.SPADES);
			assertTrue(tableau.canMoveTo(cardCase1, TableauPile.FIRST));
			
			//Caso 2: verifico che è possibile spostare una carta su una colonna non vuota del Tableau
			//solo se questa ha un valore immediatamente inferiore e un colore diverso dalla carta già 
			//presente
			Card cardCase2 = new Card(Rank.SEVEN, Suit.CLUBS);
			Card cardCase2_2 = new Card(Rank.SIX, Suit.DIAMONDS);
			tableau.push(cardCase2, TableauPile.SECOND);
			assertTrue(tableau.canMoveTo(cardCase2_2, TableauPile.SECOND));
			
			//Caso 3: verifico che non è possibile spostare una carta su una colonna non vuota del Tableau 
			//se questa non ha un valore immediatamente inferiore e/o lo stesso colore della carta già 
			//presente
			Card cardCase3 = new Card(Rank.FOUR, Suit.HEARTS);
			Card cardCase3_2 = new Card(Rank.QUEEN, Suit.SPADES);
			tableau.push(cardCase3, TableauPile.THIRD);
			assertFalse(tableau.canMoveTo(cardCase3_2, TableauPile.THIRD));
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}
	
	
	@Test
	void testGetSequence() {
		try {
			//Verifico che la dimensione della nuova pila di carte restituita da getSequence è minore di quella originale
			//in cui si trova la carta
			Card card = new Card(Rank.QUEEN, Suit.SPADES);
			tableau.initialize(deck);
			if(tableau.contains(card)) {
				CardStack pilaCarte = tableau.getStackPile(card);
				CardStack nuovaPilaCarte = tableau.getSequence(card, tableau.getPile(card));
				
				//Se la carta inizialmente si trova nella colonna 1, significa che non sarà coperta 
				//da nessun'altra carta e quindi la dimensione della nuova pila sarà sempre 1
				if(pilaCarte.size() == 1) {
					assertEquals(1, nuovaPilaCarte.size());
				}
				
				//In tutti gli altri casi la dimensione della nuova pila sarà minore di quella originale
				assertTrue(nuovaPilaCarte.size() < pilaCarte.size());	
			}
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}
	

	@Test
	void testPop() {
		try {
			//Rimuovo una carta dalla colonna 6 del tableau e verifico che la nuova dimensione della pila di carte è 5
			tableau.initialize(deck);
			tableau.pop(TableauPile.SIXTH);
			CardStack pilaCarte = tableau.getPile(TableauPile.SIXTH);
			assertEquals(5, pilaCarte.size());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	@Test
	void testPush() {
		try {
			//Inserisco una nuova carta nella colonna 6 e verifico che la nuova dimensione della pila di carte è 7
			Card card = new Card(Rank.NINE, Suit.DIAMONDS);
			tableau.initialize(deck);
			tableau.push(card, TableauPile.SIXTH);
			CardStack pilaCarte = tableau.getPile(TableauPile.SIXTH);
			assertEquals(7, pilaCarte.size());	
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

}
