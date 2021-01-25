package solitaire.gui;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import solitaire.cards.Card;
import solitaire.cards.CardImages;
import solitaire.model.GameModel;
import solitaire.model.GameModelListener;

/**
 * Component that shows the state of the discard pile and allows
 * dragging cards from it.
 */
public class DiscardPileView extends HBox implements GameModelListener {
	
	private static final int PADDING = 5;
	private CardDragHandler aDragHandler;
	
	DiscardPileView()
	{
		setPadding(new Insets(PADDING));
    	final ImageView image = new ImageView(CardImages.getBack());
    	image.setVisible(false);
       	getChildren().add(image);
    	aDragHandler = new CardDragHandler(image);
    	image.setOnDragDetected(aDragHandler);
    	GameModel.instance().addListener(this);
	}
	
	@Override
	public void gameStateChanged()
	{
		if(GameModel.instance().isDiscardPileEmpty())
		{
			getChildren().get(0).setVisible(false);
		}
		else
		{
			getChildren().get(0).setVisible(true);
			Card topCard = GameModel.instance().peekDiscardPile();
			ImageView image = (ImageView)getChildren().get(0);
			image.setImage(CardImages.getCard(topCard));
			aDragHandler.setCard(topCard);
		}
	}

}
