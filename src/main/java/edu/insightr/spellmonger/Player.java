package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Used to have a deck by player
 * Created by Aurélie on 28/09/2016.
 */
class Player {

    private ArrayList<Card> deck;
    private String name;

    Player(String name){
        this.name = name;
        this.deck = new ArrayList<>(35);
        /*for(int i = 0; i < 35; i++){
            if(i%6 == 0){

                //deck.add(new Card());
            }
        }*/

    }

    private ArrayList<Card> getDeck(){
        return this.deck;
    }

    public Card getCard(int position){
        return this.deck.get(position);
    }

    public void discard(int currentCardNumber) {
        this.getDeck().remove(currentCardNumber);
    }

    String getName(){
        return this.name;
    }
}
