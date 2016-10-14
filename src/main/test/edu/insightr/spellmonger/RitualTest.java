package edu.insightr.spellmonger;

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
    -isShield
    -getDamages
    -getHeal
     */

    private Ritual ritual;

    @Test
    public void testGetDeltaPoints() throws Exception {
        ritual = new Ritual("Poison");
        assertEquals(-3, ritual.getDeltaPoints());
    }

    @Test
    public void testIsHeal() throws Exception {

    }

    @Test
    public void testIsShield() throws Exception {

    }

    @Test
    public void testGetDamages() throws Exception {

    }

    @Test
    public void testGetHeal() throws Exception {

    }

}