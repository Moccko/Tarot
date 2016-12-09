package Model;

import static Model.COLOR.*;
import java.util.*;

/**
 * Represents the datas of the game
 */
public class BoardModel extends Observable {

   private final DeckModel _initial_deck, _dog, _player_1, _player_2, _player_3, _player_4;

   /**
    * Constructs the model with 6 decks
    */
   public BoardModel () {
      _initial_deck = getCards();
      _dog = new DeckModel(1, 1);
      _player_1 = new DeckModel(1, 2);
      _player_2 = new DeckModel(0, 1);
      _player_3 = new DeckModel(1, 0);
      _player_4 = new DeckModel(2, 1);
   }

   /**
    * Initializes the cards contained in the initial deck, then shuffles them
    *
    * @return a deck containing all cards
    */
   private DeckModel getCards () {
      DeckModel deck = new DeckModel(0, 0);
      int cpt = 1;
      for (COLOR color : COLOR.values()) {
	 int value = 1;
	 while (value < 22) {
	    if (color != TRUMP && value > 14) {
	       break;
	    } else if (color == EXCUSE) {
	       deck.add(new CardModel(cpt++)); // we add the excuse to the deck
	       break;
	    }
	    deck.add(new CardModel(color, value, cpt++));
	    value++;
	 }
      }
      deck.shuffle();
      return deck;
   }

   public DeckModel getInitial_deck () {
      return _initial_deck;
   }

   public DeckModel getDog () {
      return _dog;
   }

   public DeckModel getPlayer_1 () {
      return _player_1;
   }

   public DeckModel getPlayer_2 () {
      return _player_2;
   }

   public DeckModel getPlayer_3 () {
      return _player_3;
   }

   public DeckModel getPlayer_4 () {
      return _player_4;
   }
}
