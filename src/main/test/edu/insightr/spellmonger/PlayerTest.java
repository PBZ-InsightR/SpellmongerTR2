package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jessica on 03/10/2016.
 * modified by Adrian
 * Test methods of class Player
 */
public class PlayerTest {

    private Player player;
    private Deck deck;
    private Card cardC;
    private Card cardR;
    private int n;

    @Before
    public void initializeTests(){
        player = new Player("A");
        deck = new Deck();
        cardC = new Creature("Eagle");
        cardR = new Ritual("Curse");
    }

    @Test
    public void testGetHealthPoint() throws Exception {
        assertEquals(0, player.getHealthPoint());
    }


    @Test
    public void testSetHealthPoint() throws Exception {
        //result is valuable onlyif testGetHealthPoint is not KO
        n=5;
        player.setHealthPoint(n);
        assertEquals(n, player.getHealthPoint());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("A", player.getName());
    }

}