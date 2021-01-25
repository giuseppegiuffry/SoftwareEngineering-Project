package solitaire.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import solitaire.cards.Card;
import solitaire.cards.CardStack;
import solitaire.cards.Rank;
import solitaire.cards.Suit;

class CardStackTest {
	
	static CardStack cardStack, fullCardStack;
	
	@BeforeEach
	void initTest() {
		//Creo un mazzo vuoto
		cardStack = new CardStack();
		
		//Creo un mazzo con 52 carte mischiate
		List<Card> cards = new ArrayList<>();
		for(Suit suit : Suit.values())
		{
            for(Rank rank : Rank.values())
            {
                cards.add(Card.get(rank, suit));
            }
		}
		Collections.shuffle(cards);
    	fullCardStack = new CardStack(cards);
		
	}

	@Test
	void testPush() {
		try {
        	//creo una regina di picche e inserisco questa carta in un mazzo vuoto,
			//verifico che la dimensione del nuovo mazzo è 1 in seguito all'inserimento
        	Card card = new Card(Rank.QUEEN, Suit.SPADES);
        	cardStack.push(card);
        	assertSame(card, cardStack.peek());
        	assertEquals(1, cardStack.size());
        	Card card2 = new Card(Rank.TEN, Suit.DIAMONDS);
        	cardStack.push(card2);
        	assertSame(card2, cardStack.peek());
        	assertEquals(2, cardStack.size());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	@Test
	void testPop() {
		try {
        	//inserisco 3 carte nel mazzo e ne rimuovo una con pop; verifico che la nuova dimensione è corretta
        	Card card1 = new Card(Rank.QUEEN, Suit.SPADES);
        	Card card2 = new Card(Rank.TWO, Suit.CLUBS);
        	Card card3 = new Card(Rank.TEN, Suit.HEARTS);
        	cardStack.push(card1);
        	cardStack.push(card2);
        	cardStack.push(card3);
        	assertEquals(card3, cardStack.pop());
        	assertEquals(2, cardStack.size());	
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	@Test
	void testPeek() {
		try {
			//Inserisco due carte e pesco quella in cima allo stack
			Card card1 = new Card(Rank.QUEEN, Suit.SPADES);
			Card card2 = new Card(Rank.NINE, Suit.CLUBS);
			cardStack.push(card1);
			cardStack.push(card2);
			assertEquals(card2, cardStack.peek());
			assertEquals(2, cardStack.size());
        } catch (Exception e) {
        	fail("Unexpected exception");
        };
	}

	@Test
	void testSize() {
		try {
			//Inserisco 3 carte nel mezzo e verifico che la nuova dimensione sia quella corretta
			Card card1 = new Card(Rank.QUEEN, Suit.SPADES);
        	Card card2 = new Card(Rank.TWO, Suit.CLUBS);
        	Card card3 = new Card(Rank.TEN, Suit.HEARTS);
        	cardStack.push(card1);
        	cardStack.push(card2);
        	cardStack.push(card3);
        	assertEquals(3, cardStack.size());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	@Test
	void testClear() {
		try {
			
			cardStack.clear();
			assertTrue(cardStack.isEmpty());
			//Inserisco due carte, chiamo il metodo clear e verifico che la nuova dimensione sia 0
			Card card1 = new Card(Rank.QUEEN, Suit.SPADES);
        	Card card2 = new Card(Rank.TWO, Suit.CLUBS);
        	cardStack.push(card1);
        	cardStack.push(card2);
        	assertFalse(cardStack.isEmpty());
        	cardStack.clear();
        	assertTrue(cardStack.isEmpty());
        	
        	//Uso un mazzo di 52 carte mischiate, chiamo il metodo clear e verifico che il mazzo sia vuoto
        	fullCardStack.clear();
        	assertEquals(0, fullCardStack.size());
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

	@Test
	void testIsEmpty() {
		try {
			//Verifico che inizialmente il mazzo è vuoto
			assertTrue(cardStack.isEmpty());
			
			//Inserisco 2 carte e verifico che il mazzo non è vuoto
			Card card1 = new Card(Rank.QUEEN, Suit.SPADES);
        	Card card2 = new Card(Rank.TWO, Suit.CLUBS);
        	cardStack.push(card1);
        	cardStack.push(card2);
        	assertFalse(cardStack.isEmpty());
        	
        } catch (Exception e) {
        	fail("Unexpected exception");
        }
	}

}
