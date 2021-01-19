package solitaire.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import solitaire.cards.Card;

import solitaire.cards.Rank;
import solitaire.cards.Suit;
import solitaire.model.FoundationPile;
import solitaire.model.GameModel;
import solitaire.model.Move;
import solitaire.model.OtherLocation;
import solitaire.model.TableauPile;

class GameModelTest {
	
	static GameModel gameModel;
	
	@BeforeEach
	void initTest() {
		gameModel = GameModel.instance();
	}
	

	@Test
	@DisplayName("Test mazzo stock coperto inizialmente non vuoto")
	void testIsDeckEmpty() {
        try {
            assertFalse(gameModel.isDeckEmpty());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	@Test
	@DisplayName("Test pila delle carte scartate inizialmente vuoto")
	void testIsDiscardPileEmpty() {
        try {
            assertTrue(gameModel.isDiscardPileEmpty());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	@Test
	@DisplayName("Test pile di carte delle quattro basi inizialmente vuote")
	void testIsFoundationPileEmpty() {
        try {
        	for(FoundationPile index : FoundationPile.values()) {
        		assertTrue(gameModel.isFoundationPileEmpty(index));
        	}
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}


	@Test
	@DisplayName("Test per verificare la posizione di una carta sul tavolo")
	void testFind() {
		try {
			
			Card card = new Card(Rank.KING, Suit.SPADES);
			
			//Caso 1: la carta si trova nella pila delle carte scartate dal mazzo (Discard Pile)
			if(!gameModel.isInTableau(card)) {
				Move discardMove = gameModel.getDiscardMove();
				do {
					discardMove.perform();
				} while(!gameModel.peekDiscardPile().equals(card));
				
				assertEquals(OtherLocation.DISCARD_PILE, gameModel.find(card));
			
			} 
			//Caso 2: la carta si trova in una delle sette pile di carte del Tableau
			else {
				for(TableauPile index : TableauPile.values()) {
					if(index.equals(gameModel.find(card))) {
						assertEquals(index, gameModel.find(card));
					}
				}
			}
				
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}
	
	@Test
	@DisplayName("Test per verificare il punteggio ottenuto")
	void testGetScore() {
		assertEquals(0, gameModel.getScore());
		assertFalse(gameModel.isCompleted());
	}

}
