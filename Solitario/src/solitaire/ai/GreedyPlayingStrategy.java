package solitaire.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import solitaire.cards.Card;
import solitaire.cards.CardStack;
import solitaire.model.FoundationPile;
import solitaire.model.GameModelView;
import solitaire.model.Move;
import solitaire.model.TableauPile;

public class GreedyPlayingStrategy implements PlayingStrategy {
	
	private static final List<Function<GameModelView, Move>> SUBSTRATEGIES = new ArrayList<>();

	static
	{
		SUBSTRATEGIES.add(GreedyPlayingStrategy::substrategyDiscardIfDiscardPileIsEmpty);
		SUBSTRATEGIES.add(GreedyPlayingStrategy::substrategyMoveDiscardToFoundation);
		SUBSTRATEGIES.add(GreedyPlayingStrategy::substrategyMoveDiscardToTableau);
		SUBSTRATEGIES.add(GreedyPlayingStrategy::substrategyMoveFromTableauToFoundation);
		SUBSTRATEGIES.add(GreedyPlayingStrategy::substrategyMoveWithinTableau);
		SUBSTRATEGIES.add(GreedyPlayingStrategy::substrategyDiscard);
	}
	
	/**
	 * Creates a new strategy.
	 */
	public GreedyPlayingStrategy() {}
	
	/*
	 * If the discard pile is empty, discard. 
	 */
	private static Move substrategyDiscardIfDiscardPileIsEmpty(GameModelView pModel)
	{
		if( pModel.isDiscardPileEmpty() && !pModel.isDeckEmpty() )
		{
			return pModel.getDiscardMove();
		}
		else
		{
			return pModel.getNullMove();
		}
	}
	
	/*
	 * If it's possible to move the top of the discard pile to the foundation, do it.
	 */
	private static Move substrategyMoveDiscardToFoundation(GameModelView pModel)
	{
		if( pModel.isDiscardPileEmpty() )
		{
			return pModel.getNullMove();
		}
		for(FoundationPile pile : FoundationPile.values())
		{
			if( pModel.isLegalMove(pModel.peekDiscardPile(), pile))
			{
				return pModel.getCardMove(pModel.peekDiscardPile(), pile);
			}
		}
		return pModel.getNullMove();
	}
	
	private static Move substrategyMoveDiscardToTableau(GameModelView pModel)
	{
		if( pModel.isDiscardPileEmpty() )
		{
			return pModel.getNullMove();
		}
		for(TableauPile pile : TableauPile.values())
		{
			if( pModel.isLegalMove(pModel.peekDiscardPile(), pile))
			{
				return pModel.getCardMove(pModel.peekDiscardPile(), pile);
			}
		}
		return pModel.getNullMove();
	}
	
	private static Move substrategyMoveFromTableauToFoundation(GameModelView pModel)
	{
		for(TableauPile tableauPile : TableauPile.values())
		{
			CardStack stack = pModel.getTableauPile(tableauPile);
			if( !stack.isEmpty() )
			{
				Card card = stack.peek();
				for(FoundationPile foundationPile : FoundationPile.values())
				{
					if( pModel.isLegalMove(card, foundationPile))
					{
						return pModel.getCardMove(card, foundationPile);
					}
				}
			}	
		}
		return pModel.getNullMove();
	}
	
	/* Only if it reveals a card or empties a pile. We also don't move kings between empty piles */
	private static Move substrategyMoveWithinTableau(GameModelView pModel)
	{
		for( TableauPile pile : TableauPile.values())
		{
			CardStack stack = pModel.getTableauPile(pile);
			for( Card card : stack )
			{
				if( pModel.isBottomKing(card))
				{
					continue;
				}
				if( pModel.isLowestVisibleInTableau(card))
				{
					for( TableauPile pile2 : TableauPile.values() )
					{
						if( pModel.isLegalMove(card, pile2))
						{
							return pModel.getCardMove(card, pile2);
						}
					}
				}
			}
		}
		return pModel.getNullMove();
	}
	
	private static Move substrategyDiscard(GameModelView pModel)
	{
		if( pModel.isDeckEmpty() )
		{
			return pModel.getNullMove();
		}
		else
		{
			return pModel.getDiscardMove();
		}
	}
	
	@Override
	public Move getLegalMove(GameModelView pModel)
	{
		for( Function<GameModelView, Move> substrategy : SUBSTRATEGIES )
		{
			Move move = substrategy.apply(pModel);
			if( !move.isNull() )
			{
				return move;
			}
		}
		return pModel.getNullMove();
	}

	
}
