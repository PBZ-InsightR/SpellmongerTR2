package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jessica on 03/10/2016.
 * modified by Adrian
 * Test methods of class Player
 */
public class PlayerTest {

    /*
    To test:
    -getHealthPoint
    -getHand
    -setHealthPoint
    -isHuman
    -isIA
    -changeHealthPoints
    -getName
    -addCardToDeck
     */

    private Player playerHuman;
    private Player playerIA;
    private Deck deck;
    private Card cardE;
    private Card cardW;
    private Card cardB;
    private Card cardP;
    private Card cardS;
    private Card cardM;
    private int n1;
    private int n2;

    @Before
    public void initializeTests(){
        playerHuman = new Player("Hum");
        playerIA = new Player("Bot", false);
        deck = new Deck();
        cardE = new Creature("Eagle");
        cardW = new Creature("Wolf");
        cardB = new Creature("Bear");
        cardP = new Ritual("Poison");
        cardS = new Ritual("Shield");
        cardM = new Ritual("Medicine");
    }

    @Test
    public void testGetHealthPoint() throws Exception {
        assertEquals(0, playerHuman.getHealthPoint());
        assertEquals(0, playerIA.getHealthPoint());
    }

    @Test
    public void testGetHand() throws Exception {
        assert(playerHuman.getHand() instanceof Deck);
        assert(playerIA.getHand() instanceof Deck);
    }

    @Test
    public void testSetHealthPoint() throws Exception {
        //result is valuable onlyif testGetHealthPoint is not KO
        n1=10;
        n2=20;
        playerHuman.setHealthPoint(n1);
        playerIA.setHealthPoint(n2);
        assertEquals(n1, playerHuman.getHealthPoint());
        assertEquals(n2, playerIA.getHealthPoint());
    }

    @Test
    public void testIsHuman() throws Exception {
        assertTrue(playerHuman.isHuman());
        assertFalse(playerIA.isHuman());
    }

    @Test
    public void testIsIA() throws Exception {
        assertTrue(playerIA.isIA());
        assertFalse(playerHuman.isIA());
    }

    @Test
    public void testChangeHealthPoints() throws Exception {
        int delta = 5;
        int playerHumanHealthPointInit = playerHuman.getHealthPoint();
        int playerIAHealthPointInit = playerIA.getHealthPoint();
        playerHuman.changeHealthPoints(delta);
        playerIA.changeHealthPoints(delta);
        assertEquals(playerHumanHealthPointInit + delta, playerHuman.getHealthPoint());
        assertEquals(playerIAHealthPointInit + delta, playerIA.getHealthPoint());
    }

    @Test
    public void testGetName() throws Exception {
        assert("Hum".equals(playerHuman.getName()));
        assert("Bot".equals(playerIA.getName()));
    }

    @Test
    public void testAddCardToDeck() throws Exception {
        assertTrue(playerHuman.addCardToDeck(cardB));
        assertTrue(playerIA.addCardToDeck(cardP));
        assertTrue(playerHuman.getHand().contains(cardB));
        assertTrue(playerIA.getHand().contains(cardP));
    }

}