package solitaire.model;

import java.util.HashMap;
import java.util.Map;

import solitaire.cards.Card;
import solitaire.cards.CardStack;
import solitaire.cards.Rank;

/**
 * Represents the four piles that must be completed to win the game, with the ace
 * at the bottom, face up, and all cards of the same suit on top, in sequence.
 */
public class Foundations {
	
	private final Map<FoundationPile, CardStack> aPiles = new HashMap<>();
	
	/**
	 * Creates an initialized FoundationPiles object that consists of four empty piles.
	 */
	public Foundations()
	{
		initialize();
	}
	
	/**
	 * @return The total number of cards in all the foundation piles.
	 */
	public int getTotalSize()
	{
		int total = 0;
		for( CardStack stack : aPiles.values())
		{
			total += stack.size();
		}
		return total;
	}
	
	/**
	 * Initializes the FoundationPiles object to reset it to four empty piles.
	 */
	public void initialize()
	{
		for( FoundationPile index : FoundationPile.values() )
		{
			aPiles.put(index, new CardStack());
		}
	}
	
	/**
	 * @param pLocation The location of the pile to check.
	 * @return True if the pile at pLocation is empty
	 * @pre pLocation != null
	 */
	public boolean isEmpty(FoundationPile pLocation) throws IllegalArgumentException
	{
		if(pLocation == null)
			throw new IllegalArgumentException("Invalid argument passed");
		return aPiles.get(pLocation).isEmpty();
	}
	
	public CardStack getPile(FoundationPile pPile)
	{
		return new CardStack(aPiles.get(pPile));
	}
	
	/**
	 * @param pCard The card we wish to move
	 * @param pLocation The desired location for pCard
	 * @return True if pCard can be moved to the top of pLocation. 
	 *     This is only possible if its rank is immediately superior
	 *     to that of the card currently on top of the pile or, in
	 *     the case of an ace, if the location is empty.
	 * @pre pCard != null && pLocation != null
	 */
	public boolean canMoveTo(Card pCard, FoundationPile pLocation ) throws IllegalArgumentException
	{
		if(pCard == null && pLocation == null)
			throw new IllegalArgumentException("Invalid argument passed");
		
		if( isEmpty(pLocation))
		{
			return pCard.getRank() == Rank.ACE;
		}
		else
		{
			return pCard.getSuit() == peek(pLocation).getSuit() && 
					pCard.getRank().ordinal() == peek(pLocation).getRank().ordinal()+1;
		}
	}
	
	/**
	 * @param pLocation The location of the pile to peek at
	 * @return The card on top of the pile at pLocation
	 * @pre pLocation != null && !aPiles.get(pLocation).isEmpty();
	 */
	public Card peek(FoundationPile pLocation) throws IllegalArgumentException
	{
		if(pLocation == null && aPiles.get(pLocation).isEmpty())
			throw new IllegalArgumentException("Invalid argument passed");
		return aPiles.get(pLocation).peek();
	}
	
	/**
	 * Place pCard onto the pile at the desired location.
	 * 
	 * @param pCard The card to place.
	 * @param pLocation The location where to place the card.
	 * @pre pCard != null && pLocation != null
	 */
	public void push(Card pCard, FoundationPile pLocation) throws IllegalArgumentException
	{
		if(pLocation == null && pLocation == null)
			throw new IllegalArgumentException("Invalid argument passed");
		aPiles.get(pLocation).push(pCard);
	}
	
	/**
	 * Remove the card at the top of the pile at pLocation,
	 * and returns it.
	 * 
	 * @param pLocation The location where to obtain the card.
	 * @pre pLocation != null && !isEmpty(pLocation)
	 */
	public Card pop(FoundationPile pLocation) throws IllegalArgumentException
	{
		if(pLocation == null && isEmpty(pLocation))
			throw new IllegalArgumentException("Invalid argument passed");
		return aPiles.get(pLocation).pop();
	}

}
