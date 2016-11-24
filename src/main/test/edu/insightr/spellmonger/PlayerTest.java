package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Jessica on 03/10/2016.
 * modified by Adrian
 * Test methods of class Player
 */
public class PlayerTest{

    /*
    To test:
    -getHealthPoint
    -getPlayHand
    -getDeck
    -noMoreCard
    -setHealthPoint
    -isHuman
    -isIA
    -changeHealthPoints
    -getName
    -addCardToDeck
    -giveHand
     */

    private Player playerHuman;
    private Player playerIA;
    private Card cardB;
    private Card cardP;
    private int n1;
    private int n2;

    @Before
    public void initializeTests(){
        playerHuman = new Player("Hum");
        playerIA = new Player("Bot", false);
        cardB = new Creature("Bear");
        cardP = new Ritual("Poison");
    }

    @Test
    public void testGetHealthPoint() throws Exception {
        org.junit.Assert.assertEquals(0, playerHuman.getHealthPoint());
        org.junit.Assert.assertEquals(0, playerIA.getHealthPoint());
    }

    @Test
    public void testGetPlayHand() throws Exception {
        assert(playerHuman.getPlayHand() instanceof Deck);
        assert(playerIA.getPlayHand() instanceof Deck);
    }

    @Test
    public void testGetDeck() throws Exception {
        assert(playerHuman.getDeck() instanceof Deck);
        assert(playerIA.getDeck() instanceof Deck);
    }

    @Test
    public void testNoMoreCard() throws Exception {
        org.junit.Assert.assertTrue(playerHuman.noMoreCard());

        playerHuman.getPlayHand().add(cardB);
        org.junit.Assert.assertFalse(playerHuman.noMoreCard());
    }

    @Test
    public void testSetHealthPoint() throws Exception {
        //result is valuable only if testGetHealthPoint is not KO
        n1=10;
        n2=20;
        playerHuman.setHealthPoint(n1);
        playerIA.setHealthPoint(n2);
        org.junit.Assert.assertEquals(n1, playerHuman.getHealthPoint());
        org.junit.Assert.assertEquals(n2, playerIA.getHealthPoint());
    }

    @Test
    public void testIsHuman() throws Exception {
        org.junit.Assert.assertTrue(playerHuman.isHuman());
        org.junit.Assert.assertFalse(playerIA.isHuman());
    }

    @Test
    public void testIsIA() throws Exception {
        org.junit.Assert.assertTrue(playerIA.isIA());
        org.junit.Assert.assertFalse(playerHuman.isIA());
    }

    @Test
    public void testChangeHealthPoints() throws Exception {
        int delta = 5;
        int playerHumanHealthPointInit = playerHuman.getHealthPoint();
        int playerIAHealthPointInit = playerIA.getHealthPoint();
        playerHuman.changeHealthPoints(delta);
        playerIA.changeHealthPoints(delta);
        org.junit.Assert.assertEquals(playerHumanHealthPointInit + delta, playerHuman.getHealthPoint());
        org.junit.Assert.assertEquals(playerIAHealthPointInit + delta, playerIA.getHealthPoint());
    }

    @Test
    public void testGetName() throws Exception {
        assert("Hum".equals(playerHuman.getName()));
        assert("Bot".equals(playerIA.getName()));
    }

    @Test
    public void testAddCardToDeck() throws Exception {
        org.junit.Assert.assertTrue(playerHuman.addCardToDeck(cardB));
        org.junit.Assert.assertTrue(playerIA.addCardToDeck(cardP));
        org.junit.Assert.assertTrue(playerHuman.getDeck().contains(cardB));
        org.junit.Assert.assertTrue(playerIA.getDeck().contains(cardP));
    }

    @Test
    public void testGiveHand() throws Exception {

        /*playerHuman.giveHand();
        org.junit.Assert.assertNotNull(playerHuman.getDeck());
        org.junit.Assert.assertNotNull(playerHuman.getPlayHand());
        org.junit.Assert.assertEquals(playerHuman.getDeck(), playerHuman.getPlayHand());
        */

        Deck giveHand = new Deck();
        giveHand.add(cardB);
        giveHand.add(cardB);
        giveHand.add(cardP);
        playerHuman.addCardToDeck(cardB);
        playerHuman.addCardToDeck(cardB);
        playerHuman.addCardToDeck(cardP);
        playerHuman.giveHand();
        org.junit.Assert.assertEquals(giveHand, playerHuman.getPlayHand());
    }
}