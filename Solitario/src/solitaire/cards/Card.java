package solitaire.cards;

/**
 * An immutable description of a playing card. This abstraction is designed 
 * to be independent of game logic, so it does not provide any service 
 * that relies on the knowledge of the rules of any particular game.
 */
public class Card {
	
	// Indexed by suit, then rank
	private static final Card[][] CARDS = new Card[Suit.values().length][];
		
	// Create the flyweight objects
	static
	{
		for( Suit suit : Suit.values() )
		{
			CARDS[suit.ordinal()] = new Card[Rank.values().length];
			for( Rank rank : Rank.values() )
			{
				CARDS[suit.ordinal()][rank.ordinal()] = new Card(rank, suit);
			}
		}
	}
		
	private final Rank aRank;
	private final Suit aSuit;
		
	public Card(Rank pRank, Suit pSuit )
	{
		aRank = pRank;
		aSuit = pSuit;
	}
		
	/**
	* Get a flyweight Card object.
	* @param pRank The rank of the card (from ace to king)
	* @param pSuit The suit of the card (clubs, diamond, spades, hearts)
	* @return The card object representing the card with pRank and pSuit
	*/
	public static Card get(Rank pRank, Suit pSuit) throws IllegalArgumentException
	{
		if(pRank == null || pSuit == null)
			throw new IllegalArgumentException("Invalid argument passed");
			
		return CARDS[pSuit.ordinal()][pRank.ordinal()];
	}
		
	/**
	* Get a flyweight card object based on its serialized form.
	* @param pId The id string for the card.
	* @return The card object with id string pId
	*/
	public static Card get(String pId) throws IllegalArgumentException
	{
		if(pId == null)
			throw new IllegalArgumentException("Invalid argument passed");
			
		int id = Integer.parseInt(pId);
		return get(Rank.values()[id % Rank.values().length], Suit.values()[id / Rank.values().length]);
	}
		
	/**
	* Return the id string for this card.
	* 
	* @return A string uniquely representing this card. The string
	* format is not specified except that it is fully compatible
	* with the format expected by Card.get(String).
	*/
	public String getIDString()
	{
		return Integer.toString(getSuit().ordinal() * Rank.values().length + getRank().ordinal());
	}
		
	/**
	 * Obtain the rank of the card.
	 * @return An object representing the rank of the card.
	 */
	public Rank getRank()
	{
		return aRank;
	}
		
	/**
	* Obtain the suit of the card.
	* @return An object representing the suit of the card 
	*/
	public Suit getSuit()
	{
		return aSuit;
	}
		
	/**
	* Obtain a string with the rank and the suit of the card
	*/
	@Override
	public String toString()
	{
		return aRank + " of " + aSuit;
	}
		
	public boolean equals(Card pCard) {
		if(this.aRank == pCard.aRank && this.aSuit == pCard.aSuit) {
			return true;
		}
		return false;
	}
		
}
