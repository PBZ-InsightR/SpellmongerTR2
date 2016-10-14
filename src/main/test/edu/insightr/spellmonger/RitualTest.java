package edu.insightr.spellmonger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jessica on 03/10/2016.
 * Test methods of class Ritual
 */
public class RitualTest {

    private Ritual ritual;

    @Test
    public void testGetDeltaPoints() throws Exception {
        ritual = new Ritual("Poison");
        assertEquals(-3, ritual.getDeltaPoints());
    }

    @Test
    public void testIsShield() throws Exception {
        ritual = new Ritual("Shield");
        assertTrue(ritual.isShield());
    }

    @Test
    public void testGetDamages() throws Exception {
        ritual = new Ritual("Shield");
        assertEquals(0, ritual.getDamages());
        ritual = new Ritual("Poison");
        assertEquals(3, ritual.getDamages());
    }

    @Test
    public void testGetHeal() throws Exception {
        ritual = new Ritual("Medicine");
        assertEquals(3, ritual.getHeal());
        ritual = new Ritual("Shield");
        assertEquals(0,ritual.getHeal());
    }

}