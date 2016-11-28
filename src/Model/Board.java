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
public class Board extends Observable {

   private final Deck _original_deck, _dog, _player_1, _player_2, _player_3, _player_4;

   public Board () {
      _original_deck = getCards();
      _dog = new Deck(1, 1);
      _player_1 = new Deck(1, 2);
      _player_2 = new Deck(0, 1);
      _player_3 = new Deck(1, 0);
      _player_4 = new Deck(2, 1);
   }

   private Deck getCards () {
      Deck deck = new Deck(2, 0);
      for (int color = 0; color < 5; color++) {
	 int value = 1;
	 while (value < 22) {
	    if (color < 4 && value > 14) {
	       break;
	    }
	    switch (color) {
	       case 0:
		  deck.add(new Card(SPADE, color));
		  break;
	       case 1:
		  deck.add(new Card(CLUB, color));
		  break;
	       case 2:
		  deck.add(new Card(HEART, color));
		  break;
	       case 3:
		  deck.add(new Card(DIAMOND, color));
		  break;
	       case 4:
		  deck.add(new Card(TRUMP, color));
		  break;
	    }
	    value++;
	 }
      }
      deck.add(new Card());
      return deck;
   }
}
