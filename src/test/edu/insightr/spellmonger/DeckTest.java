package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jessica on 06/12/2016.
 */
public class DeckTest {
    /*
    Write tests for:
        -findFromClass
     */

    private Deck deck;
    private Card cardE;
    private Card cardM;


    @Before
    public void initializeTests(){
        deck = new Deck();
        cardE = new Creature("Eagle");
        cardM = new Ritual("Medicine");
        deck.add(cardE);
        deck.add(cardM);
    }

    @Test
    public void testDraw() throws Exception {
        assertEquals(cardE,deck.draw());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("1: Eagle \n2: Medicine \n", deck.toString());
    }

    @Test
    public void testFindFromClass() throws Exception {
        deck.add(cardE);
        //assertEquals(cardE, deck.findFromClass(Creature));

    }

    @Test
    public void testFindFromName() throws Exception {
        assertEquals(cardM, deck.findFromName("Medicine"));
    }

}