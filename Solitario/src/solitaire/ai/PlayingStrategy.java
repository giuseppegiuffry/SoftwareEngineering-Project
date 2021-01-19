package solitaire.ai;

import solitaire.model.GameModelView;
import solitaire.model.Move;

public interface PlayingStrategy {
	
	/**
	 * Returns a legal move for the game, or the 
	 * Null move if that is not possible.
	 * 
	 * @param pModel A game model to query.
	 * @return The move computed.
	 */
	Move getLegalMove(GameModelView pModel);

}
