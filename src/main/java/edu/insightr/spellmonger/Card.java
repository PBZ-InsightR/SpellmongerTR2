package edu.insightr.spellmonger;

/**
 * Used to have a Card Deck no matter the card
 * Created by Aurélie on 28/09/2016.
 */
public abstract class Card {
    private String name;
    int damage;

    public Card(String name){
        this.name = name;
    }

    public int getDamage(){
        return this.damage;
    }

    String getName(){
        return this.name;
    }
    // Juste pour corriger erreur avec une branche ..
}
