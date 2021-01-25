package solitaire.cards;

public enum Suit {
	
	CLUBS, DIAMONDS, HEARTS, SPADES; 
	
	/**
	 * @param pSuit The suit to test against.
	 * @return True if this suit and pSuit are of the same color.
	 * @pre pSuit != null;
	 */
	public boolean sameColorAs(Suit pSuit)
	{
		
		if( this == CLUBS || this == SPADES )
		{
			return pSuit == CLUBS || pSuit == SPADES;
		}
		else
		{
			return pSuit == DIAMONDS || pSuit == HEARTS;
		}
	}

}
