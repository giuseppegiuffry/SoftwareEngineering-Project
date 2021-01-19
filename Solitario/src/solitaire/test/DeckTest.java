package solitaire.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import solitaire.cards.Card;

import solitaire.cards.Deck;


class DeckTest {
	
	static Deck deck;
	
	@BeforeEach
	void initTest() {
		deck = new Deck();
	}
	

	@Test
	void testShuffle() {
		try {
			//Creo due mazzi mischiati con shuffle e verifico che i due oggetti non sono uguali
			Deck deck1 = new Deck();
			Deck deck2 = new Deck();
			assertNotEquals(deck1, deck2);
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}


	@Test
	void testDraw() {
		try {
			//Creo un set di carte inizialmente vuoto e in questo inserisco tutte le 52 carte pescate dal deck
			Set<Card> cardSet = new HashSet<Card>();
			for(int i = 0; i < 52; i++) {
				Card card = deck.draw();
				assertFalse(cardSet.contains(card));
				cardSet.add(card);
			}
			assertTrue(deck.isEmpty());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	@Test
	void testSize() {
		try {
			//Verifico che inizialmente il mazzo creato è composto da 52 carte
			assertEquals(52, deck.size());
			
			//Pesco una carta dal mazzo e verifico la nuova dimensione
			deck.draw();
			assertEquals(51, deck.size());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

}
