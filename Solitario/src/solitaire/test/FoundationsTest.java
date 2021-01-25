package solitaire.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import solitaire.cards.Card;
import solitaire.cards.CardStack;
import solitaire.cards.Deck;
import solitaire.cards.Rank;
import solitaire.cards.Suit;
import solitaire.model.FoundationPile;
import solitaire.model.Foundations;

class FoundationsTest {
	
	static Foundations foundations;
	static Deck deck;
	
	@BeforeEach
	void initTest() {
		foundations = new Foundations();
	}
	
	@Test
	void testInitialize() {
		try {
			assertTrue(foundations.isEmpty(FoundationPile.FIRST));
			assertTrue(foundations.isEmpty(FoundationPile.SECOND));
			assertTrue(foundations.isEmpty(FoundationPile.THIRD));
			assertTrue(foundations.isEmpty(FoundationPile.FOURTH));
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}
	
	@Test
	void testGetScore() {
		try {
			assertEquals(0, foundations.getTotalSize());
			foundations.push(Card.get(Rank.ACE, Suit.CLUBS), FoundationPile.FIRST);
			foundations.push(Card.get(Rank.ACE, Suit.DIAMONDS), FoundationPile.SECOND);
			assertEquals(2, foundations.getTotalSize());
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}

	
	@Test
	void testIsEmpty() {
		try {
			//Verifico che inizialmente le quattro pile di carte in Foundations siano vuote
			for(FoundationPile index : FoundationPile.values()) {
				CardStack stack = foundations.getPile(index);
				assertEquals(0, stack.size());
			}
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}
	
	@Test
	void testCanMoveTo() {
		try {
			//Caso 1: verifico che posso spostare un Asso in una qualsiasi base inizialmente vuota
			Card card1 = new Card(Rank.ACE, Suit.HEARTS);
			for(FoundationPile index : FoundationPile.values()) {
				assertTrue(foundations.canMoveTo(card1, index));
			}
			
			//Caso 2: verifico che non è possibile spostare una carta che non sia un Asso in una qualsiasi base vuota
			Card card2 = new Card(Rank.SEVEN, Suit.CLUBS);
			for(FoundationPile index : FoundationPile.values()) {
				assertFalse(foundations.canMoveTo(card2, index));
			}
			
			//Caso 3: verifico che è possibile spostare una carta su una base non vuota solo se questa ha lo stesso seme
			//e un valore immediatamente superiore a quella già presente
			Card foundationCard = new Card(Rank.SEVEN, Suit.CLUBS);
			Card cardToMove = new Card(Rank.EIGHT, Suit.CLUBS);
			foundations.push(foundationCard, FoundationPile.THIRD);
			assertTrue(foundations.canMoveTo(cardToMove, FoundationPile.THIRD));
			
			//Caso 4: verifico che non è possibile spostare una carta su una base non vuota se questa non ha lo stesso seme
			//e un valore immediatamente superiore a quella già presente
			Card cardToMove2 = new Card(Rank.FOUR, Suit.DIAMONDS);
			assertFalse(foundations.canMoveTo(cardToMove2, FoundationPile.THIRD));
			
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}

	@Test
	void testPeek() {
		try {
			//Inserisco una carta in una base vuota e verifico che la carta restituita dal metodo peek per quella
			//base sia uguale a quella inserita
			Card card = new Card(Rank.SEVEN, Suit.CLUBS);
			foundations.push(card, FoundationPile.SECOND);
			assertTrue(new Card(Rank.SEVEN, Suit.CLUBS).equals(foundations.peek(FoundationPile.SECOND)));
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	@Test
	void testPush() {
		try {
			//Inserisco una carta in una base vuota e verifico che la nuova dimensione dello stack sia 1
			Card card = new Card(Rank.SEVEN, Suit.CLUBS);
			foundations.push(card, FoundationPile.FOURTH);
			CardStack stack = foundations.getPile(FoundationPile.FOURTH);
			assertEquals(1, stack.size());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	@Test
	void testPop() {
		try {
			//Inserisco 3 carte in una base, ne rimuovo una e verifico che la nuova dimensione dello
			//stack sia 2
			Card card1 = new Card(Rank.THREE, Suit.CLUBS);
			Card card2 = new Card(Rank.JACK, Suit.SPADES);
			Card card3 = new Card(Rank.SIX, Suit.HEARTS);
			foundations.push(card1, FoundationPile.FOURTH);
			foundations.push(card2, FoundationPile.FOURTH);
			foundations.push(card3, FoundationPile.FOURTH);
			foundations.pop(FoundationPile.FOURTH);
			CardStack stack = foundations.getPile(FoundationPile.FOURTH);
			assertEquals(2, stack.size());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

}
