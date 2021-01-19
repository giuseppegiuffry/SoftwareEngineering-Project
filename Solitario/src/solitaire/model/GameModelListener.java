package solitaire.model;

public interface GameModelListener {
	
	/**
	 * Called whenever the state of the 
	 * game model changes.
	 */
	void gameStateChanged();

}
