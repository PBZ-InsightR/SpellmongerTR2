package edu.insightr.spellmonger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jessica on 03/10/2016.
 * Test methods of class Ritual
 */
public class RitualTest {
    @Test
    public void testGetDeltaPoints() throws Exception {
        Ritual ritual = new Ritual("Blessing", 3);
        assertEquals(3, ritual.getDeltaPoints());
    }

    @Test
    public void testIsHeal() throws Exception {
        Ritual ritual = new Ritual("Blessing", 3);
        assertTrue(ritual.isHeal());
    }

    @Test
    public void testIsDamage() throws Exception {
        Ritual ritual = new Ritual("Curse", -3);
        assertTrue(ritual.isDamage());
    }
/*
    @Test
    public void testGetDamages() throws Exception {

    }

    @Test
    public void testGetHeal() throws Exception {
    }
*/
}