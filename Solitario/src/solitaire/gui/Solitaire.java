package solitaire.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import solitaire.cards.Suit;
import solitaire.model.FoundationPile;
import solitaire.model.GameModel;
import solitaire.model.TableauPile;

/**
 * Application class for Solitaire. The responsibility of this class is limited 
 * to assembling the major UI components and launching the application. 
 * All gesture handling logic is handled by its composed elements, 
 * which act as observers of the game model.
 */
public class Solitaire extends Application {
	
	private static final int WIDTH = 680;
	private static final int HEIGHT = 500;
	private static final int MARGIN_OUTER = 10;
	private static final String TITLE = "Solitaire";
	private static final String VERSION = "1.0";
	
	private DeckView aDeckView = new DeckView();
	private DiscardPileView aDiscardPileView = new DiscardPileView();
	private SuitStack[] aSuitStacks = new SuitStack[Suit.values().length];
	private CardPileView[] aStacks = new CardPileView[TableauPile.values().length];
	 
	public Solitaire() {}

	/**
	 * Launches the application.
	 * @param pArgs This program takes no argument.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage pPrimaryStage) throws Exception {
		
		BorderPane rootMenu = new BorderPane();
		
		pPrimaryStage.setTitle(TITLE + " " + VERSION);
		
		GridPane root = new GridPane();
		
		final Menu menu1 = new Menu("File");
        final Menu menu2 = new Menu("Opzioni");
        final Menu menu3 = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        
        MenuItem menuItem1 = new MenuItem("Nuova partita");
        MenuItem menuItem2 = new MenuItem("Esci");
        MenuItem menuItem3 = new MenuItem("Regole del gioco");
        
        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);
        menu2.getItems().add(menuItem3);
        menuBar.getMenus().addAll(menu1, menu2, menu3);
        
        menuItem1.setOnAction(e -> {
        	
        	GameModel.instance().reset();
        });
        
        menuItem2.setOnAction(e -> {
        	Platform.exit();
        	System.exit(0);
        });
        
        menuItem3.setOnAction(e -> {
        	SolitaireRules.display("Solitario - Regole", "Ecco le regole");
        });
        
        rootMenu.setTop(menuBar);
        rootMenu.setCenter(root);
		
        root.setStyle("-fx-background-color: green;");
        root.setHgap(MARGIN_OUTER);
        root.setVgap(MARGIN_OUTER);
        root.setPadding(new Insets(MARGIN_OUTER));
        
        root.add(aDeckView, 0, 0);
        root.add(aDiscardPileView, 1, 0);
        
        root.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCharacter().equals("r")) {
					GameModel.instance().tryToAutoPlay();
				}
				else if(event.getCharacter().equals("u")) {
					GameModel.instance().undoLast();
				}
				event.consume();
			}
        });
        
        
        for(FoundationPile index : FoundationPile.values())
        {
        	aSuitStacks[index.ordinal()] = new SuitStack(index);
        	root.add(aSuitStacks[index.ordinal()], 3+index.ordinal(), 0);
        }
        
        for(TableauPile index : TableauPile.values())
        {
        	aStacks[index.ordinal()] = new CardPileView(index);
        	root.add(aStacks[index.ordinal()], index.ordinal(), 1);
        }
        
		
        pPrimaryStage.setResizable(false);
        pPrimaryStage.setScene(new Scene(rootMenu, WIDTH, HEIGHT));
        pPrimaryStage.show();
	}

}
