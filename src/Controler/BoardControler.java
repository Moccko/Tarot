/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.*;

/**
 *
 * @author Roman
 */
public class BoardControler {

   private final BoardModel _model;
   private final DeckControler _initial_deck, _dog, _player_1, _player_2, _player_3, _player_4;

   public BoardControler ( BoardModel _model ) {
      this._model = _model;
      _initial_deck = new DeckControler(_model.getInitial_deck());
      _dog = new DeckControler(_model.getDog());
      _player_1 = new DeckControler(_model.getPlayer_1());
      _player_2 = new DeckControler(_model.getPlayer_2());
      _player_3 = new DeckControler(_model.getPlayer_3());
      _player_4 = new DeckControler(_model.getPlayer_4());
   }

   public void distribute () {
      for (int i = 0; i < 3; i++) {

      }
   }

   public DeckControler getInitial_deck () {
      return _initial_deck;
   }

   public DeckControler getDog () {
      return _dog;
   }

   public DeckControler getPlayer_1 () {
      return _player_1;
   }

   public DeckControler getPlayer_2 () {
      return _player_2;
   }

   public DeckControler getPlayer_3 () {
      return _player_3;
   }

   public DeckControler getPlayer_4 () {
      return _player_4;
   }
}
