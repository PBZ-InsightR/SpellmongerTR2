package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jessica on 03/10/2016.
 * Test methods of class Ritual
 */
public class RitualTest {

    /*
    To test:
    -getDeltaPoints
    -isHeal
    -getDamages
    -getHeal
     */

    private Ritual cardP;
    private Ritual cardS;
    private Ritual cardM;


    @Before
    public void initializeTests(){
        cardP = new Ritual("Poison");
        cardS = new Ritual("Shield");
        cardM = new Ritual("Medicine");
    }


    @Test
    public void testGetDeltaPoints() throws Exception {
        assertEquals(-3, cardP.getDeltaPoints());
        assertEquals(0, cardS.getDeltaPoints());
        assertEquals(3, cardM.getDeltaPoints());
    }

    @Test
    public void testIsHeal() throws Exception {
        assertTrue(cardM.isHeal());
        assertFalse(cardP.isHeal());
        assertFalse(cardS.isHeal());
    }

    @Test
    public void testIsShield() throws Exception {
        assertTrue(cardS.isShield());
        assertFalse(cardP.isShield());
        assertFalse(cardM.isShield());
    }

    @Test
    public void testGetDamages() throws Exception {
        assertEquals(3, cardP.getDamages());
        assertEquals(0, cardS.getDamages());
        assertEquals(0, cardM.getDamages());

    }

    @Test
    public void testGetHeal() throws Exception {
        assertEquals(0, cardP.getHeal());
        assertEquals(0, cardS.getHeal());
        assertEquals(3, cardM.getHeal());
    }

}