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
public class DeckController {

   private DeckModel _model;

   public DeckController ( DeckModel _model ) {
      this._model = _model;
   }

   public void give ( CardModel card, DeckModel deck ) {
      _model.setRole(ROLE.SENDER);
      deck.setRole(ROLE.RECEIVER);
      _model.giveCard(card, deck);
   }
   
   public void shuffle(){
      _model.shuffle();
   }
   
   public void sort(){
      _model.sort();
   }
}
