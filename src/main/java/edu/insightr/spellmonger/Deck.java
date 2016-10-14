package edu.insightr.spellmonger;

import java.util.ArrayList;


/**
 * @author Rodolphe
 * Used to set Deck car
 * Created by Rod on 30/09/2016.
 */
class Deck extends ArrayList<Card> {

    Deck() { super(); }

    Deck(int size) { super(size); }

    Card draw() {
        return remove(0);
    }

    public String toString() {
        String s = "";
        for (Card c : this) {
            s += c.getName()+", ";
        }
        return s;
    }
}
