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

   private final DeckModel _original_deck, _dog, _player_1, _player_2, _player_3, _player_4;

   public BoardModel () {
      _original_deck = getCards();
      _dog = new DeckModel(1, 1);
      _player_1 = new DeckModel(1, 2);
      _player_2 = new DeckModel(0, 1);
      _player_3 = new DeckModel(1, 0);
      _player_4 = new DeckModel(2, 1);
   }

   private DeckModel getCards () {
      DeckModel deck = new DeckModel(2, 0);
      for (int color = 0; color < 5; color++) {
	 int value = 1;
	 while (value < 22) {
	    if (color < 4 && value > 14) {
	       break;
	    }
	    switch (color) {
	       case 0:
		  deck.add(new CardModel(SPADE, color));
		  break;
	       case 1:
		  deck.add(new CardModel(CLUB, color));
		  break;
	       case 2:
		  deck.add(new CardModel(HEART, color));
		  break;
	       case 3:
		  deck.add(new CardModel(DIAMOND, color));
		  break;
	       case 4:
		  deck.add(new CardModel(TRUMP, color));
		  break;
	    }
	    value++;
	 }
      }
      deck.add(new CardModel());
      return deck;
   }
}
