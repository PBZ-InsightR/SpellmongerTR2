package edu.insightr.spellmonger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jessica on 03/10/2016.
 * Used to test class Desk
 */
public class DeckTest {

    private Deck deck = new Deck();
    private Card cardC = new Creature("Eagle", 1);
    private Card cardR = new Ritual("Curse", -3);

    @Test
    public void addCard() throws Exception {
        assertTrue(deck.addCard(cardC));
        assertFalse(deck.addCard(cardR));
    }

    @Test
    public void removeCard() throws Exception {
        /* dans la class Deck:
        public boolean removeCard(Card c) {return cards.remove(c);}
        méthode booléenne, pourtant on ne retroune pas de true/false (?)
         */
        //assertFalse(deck.removeCard(cardR)); // doit retourner true et non false
    }

    @Test
    public void getDamages() throws Exception {
        deck.addCard(cardC);
        assertEquals(1, deck.getDamages());
    }

    @Test
    public void getSize() throws Exception {
        deck.addCard(cardC);
        assertEquals(1, deck.getSize());
    }

}