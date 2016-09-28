package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Used to have a deck by player
 * Created by Aurélie on 28/09/2016.
 */
class Player {

    private ArrayList<Card> deck;
    private String name;

    public Player (String name){
        this.name = name;
        this.deck = new ArrayList<>();
    }

    ArrayList<Card> getDeck(){
        return this.deck;
    }

    public Card getCard(int position){
        return this.deck.get(position);
    }
}
