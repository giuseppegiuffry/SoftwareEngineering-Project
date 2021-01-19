package solitaire.gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import solitaire.cards.Card;
import solitaire.cards.CardImages;
import solitaire.cards.CardStack;
import solitaire.model.GameModel;
import solitaire.model.GameModelListener;
import solitaire.model.TableauPile;

public class CardPileView extends StackPane implements GameModelListener {

	private static final int PADDING = 5;
	private static final int Y_OFFSET = 17;
	private static final ClipboardContent CLIPBOARD_CONTENT = new ClipboardContent();

	
	private TableauPile aIndex;
	
	CardPileView(TableauPile pIndex)
	{
		aIndex = pIndex;
		setPadding(new Insets(PADDING));
    	setAlignment(Pos.TOP_CENTER);
    	buildLayout();
    	GameModel.instance().addListener(this);
	}
	
	private static Image getImage(Card pCard)
	{
		if( GameModel.instance().isVisibleInTableau(pCard) )
		{
			return CardImages.getCard(pCard);
		}
		else
		{
			return CardImages.getBack();
		}
	}
	
	private void buildLayout()
    {
		getChildren().clear();
		
		int offset = 0;
		CardStack stack = GameModel.instance().getTableauPile(aIndex);
		if( stack.isEmpty() ) // this essentially acts as a spacer
		{
			ImageView image = new ImageView(CardImages.getBack());
			image.setVisible(false);
			getChildren().add(image);
			return;
		}
		
		for( Card cardView : stack)
		{
			final ImageView image = new ImageView(getImage(cardView));
        	image.setTranslateY(Y_OFFSET * offset);
        	offset++;
        	getChildren().add(image);
        
        	setOnDragOver(createDragOverHandler(image, cardView));
    		setOnDragEntered(createDragEnteredHandler(image, cardView));
    		setOnDragExited(createDragExitedHandler(image, cardView));
    		setOnDragDropped(createDragDroppedHandler(image, cardView));
    		
        	if( GameModel.instance().isVisibleInTableau(cardView))
        	{
        		image.setOnDragDetected(createDragDetectedHandler(image, cardView));
        	}
		}
    }
	
	private EventHandler<MouseEvent> createDragDetectedHandler(final ImageView pImageView, final Card pCard)
	{
		return new EventHandler<MouseEvent>() 
		{
			@Override
			public void handle(MouseEvent pMouseEvent) 
			{
				Dragboard db = pImageView.startDragAndDrop(TransferMode.ANY);
				CLIPBOARD_CONTENT.putString(CardTransfer.serialize(GameModel.instance().getSubStack(pCard, aIndex)));
				db.setContent(CLIPBOARD_CONTENT);
				pMouseEvent.consume();
			}
		};
	}
	
	private EventHandler<DragEvent> createDragOverHandler(final ImageView pImageView, final Card pCard)
	{
		return new EventHandler<DragEvent>()
		{
			@Override
			public void handle(DragEvent pEvent) 
			{
				if(pEvent.getGestureSource() != pImageView && pEvent.getDragboard().hasString())
				{
					CardTransfer transfer = new CardTransfer(pEvent.getDragboard().getString());
					if( GameModel.instance().isLegalMove(transfer.getTop(), aIndex) )
					{
						pEvent.acceptTransferModes(TransferMode.MOVE);
					}
				}
				pEvent.consume();
			}
		};
	}
	
	private EventHandler<DragEvent> createDragEnteredHandler(final ImageView pImageView, final Card pCard)
	{
		return new EventHandler<DragEvent>()
		{
			@Override
			public void handle(DragEvent pEvent)
			{
				CardTransfer transfer = new CardTransfer(pEvent.getDragboard().getString());
				if( GameModel.instance().isLegalMove(transfer.getTop(), aIndex) )
				{
					pImageView.setEffect(new DropShadow());
				}
				pEvent.consume();
			}
		};
	}
	
	private EventHandler<DragEvent> createDragExitedHandler(final ImageView pImageView, final Card pCard)
	{
		return new EventHandler<DragEvent>()
		{
			@Override
			public void handle(DragEvent pEvent)
			{
				pImageView.setEffect(null);
				pEvent.consume();
			}
		};
	}
	
	private EventHandler<DragEvent> createDragDroppedHandler(final ImageView pImageView, final Card pCard)
	{
		return new EventHandler<DragEvent>() 
		{
			@Override
			public void handle(DragEvent pEvent)
			{
				Dragboard db = pEvent.getDragboard();
				boolean success = false;
				if(db.hasString()) 
				{
					GameModel.instance().getCardMove(new CardTransfer(db.getString()).getTop(), aIndex).perform(); 
					success = true;
				}

				pEvent.setDropCompleted(success);

				pEvent.consume();
			}
		};
	}

	@Override
	public void gameStateChanged()
	{
		buildLayout();
	}

}
