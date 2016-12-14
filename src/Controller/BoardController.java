/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;

/**
 *
 * @author Roman
 */
public class BoardController {

   private final BoardModel _model;
   private final DeckController _initial_deck, _dog, _player_1, _player_2, _player_3, _player_4;

   public BoardController ( BoardModel _model ) {
      this._model = _model;
      _initial_deck = new DeckController(_model.getInitial_deck());
      _dog = new DeckController(_model.getDog());
      _player_1 = new DeckController(_model.getPlayer_1());
      _player_2 = new DeckController(_model.getPlayer_2());
      _player_3 = new DeckController(_model.getPlayer_3());
      _player_4 = new DeckController(_model.getPlayer_4());
   }

   public void distribute () {
      for (int i = 0; i < 3; i++) {

      }
   }

   public DeckController getInitial_deck () {
      return _initial_deck;
   }

   public DeckController getDog () {
      return _dog;
   }

   public DeckController getPlayer_1 () {
      return _player_1;
   }

   public DeckController getPlayer_2 () {
      return _player_2;
   }

   public DeckController getPlayer_3 () {
      return _player_3;
   }

   public DeckController getPlayer_4 () {
      return _player_4;
   }
}
