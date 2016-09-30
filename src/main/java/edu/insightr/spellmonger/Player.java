package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Used to have a deck by player
 * Created by Aurélie on 28/09/2016.
 */

class Player {

    private Deck deck;
    private String name;
    private int healthPoint;

    Player(String name, int healthPoint){
        this.name = name;
        this.deck = new Deck();
        this.healthPoint = healthPoint;
    }


    public Deck getDeck() {
        return this.deck;
    }

    public int getHealthPoint() {
        return healthPoint;
    }


    String getName(){
        return this.name;
    }

    public void addCreature(Creature c) {
        this.getDeck().addCard(c);
    }


}