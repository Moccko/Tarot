/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.COLOR.*;
import java.util.Observable;

/**
 *
 * @author Roman
 */
public class BoardModel extends Observable {

   private final DeckModel _initial_deck, _dog, _player_1, _player_2, _player_3, _player_4;
   private Boolean _finished;

   public BoardModel () {
      super();
      _initial_deck = getCards();
      _dog = new DeckModel();
      _player_1 = new DeckModel();
      _player_2 = new DeckModel();
      _player_3 = new DeckModel();
      _player_4 = new DeckModel();
      _finished = false;
   }

   private DeckModel getCards () {
      DeckModel deck = new DeckModel();
      for (int color = 0; color < 5; color++) {
	 int value = 1;
	 while (value < 22) {
	    if (color < 4 && value > 14) {
	       break;
	    }
	    switch (color) {
	       case 0:
		  deck.add(new CardModel(SPADE, value));
		  break;
	       case 1:
		  deck.add(new CardModel(CLUB, value));
		  break;
	       case 2:
		  deck.add(new CardModel(HEART, value));
		  break;
	       case 3:
		  deck.add(new CardModel(DIAMOND, value));
		  break;
	       case 4:
		  deck.add(new CardModel(TRUMP, value));
		  break;
	    }
	    value++;
	 }
      }
      deck.add(new CardModel());
      return deck;
   }

   public void distribute () {
      CardModel card = new CardModel();
      setChanged();
      notifyObservers(card); // à voir plus tard
   }

   public void setFinished () {
      _finished = true;
      setChanged();
      notifyObservers();
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
