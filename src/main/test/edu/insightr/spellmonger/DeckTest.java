package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Jessica on 03/10/2016.
 * Modified by Adrian
 * Test methods of class Desk
 */
public class DeckTest {

    /*
    Les tests unitaires doivent être indépendants les uns des autres:
    La méthode Before va regénérer un deck et des cartes avant chaque test
     */
    private Deck deck;
    private Card cardC;
    private Card cardR;

    @Before
    public void initializeTests() {
        cardC = new Creature("Eagle");
        cardR = new Ritual("Curse");
        ArrayList<Card> set = new ArrayList<Card>();
        set.add(cardC);
        deck = new Deck();
    }

    @Test
    public void testAddCard() throws Exception {
        assertTrue(deck.add(cardR));
    }

    @Test
    public void testRemoveCard() throws Exception {
        assertFalse(deck.remove(cardR)); // doit retourner false car le deck est réinitialisé avant chaque test
        deck.add(cardR);
        assertTrue(deck.remove(cardR)); //maintenant doit etre true
    }

    @Test
    public void testGetSize() throws Exception {
        deck.add(cardC);
        assertEquals(1, deck.size());
    }

}