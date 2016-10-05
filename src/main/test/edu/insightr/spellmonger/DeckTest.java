package edu.insightr.spellmonger;

import org.junit.Test;

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
    @Before
    public void initializeTests() {
        private Deck deck = new Deck();/*empty deck*/
        private Card cardC = new Creature("Eagle", 1);
        private Card cardR = new Ritual("Curse", -3);
    }

    @Test
    public void testAddCard() throws Exception {
        assertTrue(deck.addCard(cardC));
        /*
        Ajouter une assertion (nécessite une nouvelle méthode?): deck "contains" cardC
         */
        assertFalse(deck.addCard(cardR));/*Pourquoi faux?*/
    }

    @Test
    public void testRemoveCard() throws Exception {
        assertFalse(deck.removeCard(cardR)); // doit retourner false car le deck est réinitialisé avant chaque test
        //ajout
        deck.addCard(cardR);
        assertTrue(deck.removeCard(cardR)); //maintenant doit etre true
    }

    @Test
    public void testGetDamages() throws Exception {
        //deck réinitalisé sans cartes
        deck.addCard(cardC);//ajout carte avec 1 dommage
        assertEquals(1, deck.getDamages());
    }

    @Test
    public void testGetSize() throws Exception {
        deck.addCard(cardC);
        assertEquals(1, deck.getSize());
    }

}