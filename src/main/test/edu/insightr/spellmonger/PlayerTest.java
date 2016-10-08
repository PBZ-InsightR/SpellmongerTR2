package edu.insightr.spellmonger;

import org.junit.Test;
import edu.insightr.spellmonger.Player;

import static org.junit.Assert.*;

/**
 * Created by Jessica on 03/10/2016.
 * modified by Adrian
 * Test methods of class Player
 */
public class PlayerTest {

    @Before
    public void initializeTests(){
        private Player player = new Player("A", 10);
        Deck deck = new Deck();
        Card cardC = new Creature("Eagle", 1);
        Card cardR = new Ritual("Curse", -3);
    }

    @Test
    public void testGetHealthPoint() throws Exception {
        assertEquals(10, player.getHealthPoint());
    }

    @Test
    public void testGetDeckDamages() throws Exception {
        deck.addCard(cardC);
        player.addCardToDeck(cardC);
        assert(player.getDeckDamages()==1);
    }

    @Test
    public void testSetHealthPoint() throws Exception {
        //result is valuable onlyif testGetHealthPoint is not KO
        n=5;
        player.setHealthPoint(n);
        assertEquals(10+n, player.getHealthPoint());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("A", player.getName());
    }

    @Test
    public void testAddCardToDeck() throws Exception {
    }

}