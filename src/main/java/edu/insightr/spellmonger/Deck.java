package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * @author Rodolphe
 * Used to set Deck car
 * Created by Rod on 30/09/2016.
 */
public class Deck extends ArrayList<Card> {

    Deck() { super(); }

    Deck(int size) { super(size); }

    Card draw() {
        return remove(0);
    }

    public String toString() {
        String s = "";
        int num=1;
        for (Card c : this) {
            s += (num++) + ": " + c.getName()+" \n";
        }
        return s;
    }

    /**
     * Returns a card of a certain type from this deck
     * @param cardClass : the class of the desired card type
     * @return Card
     */
    public Card findFromClass(Class<?> cardClass) {
        for (Card c : this) {
            if (cardClass.isInstance(c)) return c;
        }
        return null;
    }

    /**
     * Returns a card of a certain name from this deck, if any
     * @param name : the class name of the desired card type
     * @return Card
     */
    public Card findFromName(String name) {
        for (Card c : this) {
            if (c.getName().equals(name)) return c;
        }
        return null;
    }
}
