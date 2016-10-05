package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * @author Rodolphe
 * Used to set Deck
 * Created by Rod on 30/09/2016.
 */
class Deck {
    private ArrayList<Card> cards;

    Deck() {
        cards = new ArrayList<Card>();
    }

    public boolean addCard(Card c) {
        if (c instanceof Creature) {
            cards.add(c);
            return true;
        } else return false;
    }

    public boolean removeCard(Card c) {
        return cards.remove(c);
    }

    int getDamages() {
        int total = 0;
        for (Card c : cards) {
            if (c instanceof Creature) {
                total += ((Creature) c).getDamages();
            }
        }
        return total;
    }

    int getSize() {
        return cards.size();
    }

}
