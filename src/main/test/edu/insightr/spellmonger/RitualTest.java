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

    private Ritual poison;
    private Ritual shield;
    private Ritual medicine;


    @Before
    public void initializeTests(){
        poison = new Ritual("Poison");
        shield = new Ritual("Shield");
        medicine = new Ritual("Medicine");
    }


    @Test
    public void testGetDeltaPoints() throws Exception {
        assertEquals(-3, poison.getDeltaPoints());
        assertEquals(0, shield.getDeltaPoints());
        assertEquals(3, medicine.getDeltaPoints());
    }

    @Test
    public void testIsHeal() throws Exception {
        assertFalse(poison.isHeal());
        assertFalse(shield.isHeal());
        assertTrue(medicine.isHeal());

    }

    @Test
    public void testIsShield() throws Exception {
        assertFalse(poison.isShield());
        assertTrue(shield.isShield());
        assertFalse(medicine.isShield());
    }

    @Test
    public void testGetDamages() throws Exception {
        assertEquals(3, poison.getDamages());
        assertEquals(0, shield.getDamages());
        assertEquals(0, medicine.getDamages());

    }

    @Test
    public void testGetHeal() throws Exception {
        assertEquals(0, poison.getHeal());
        assertEquals(0, shield.getHeal());
        assertEquals(3, medicine.getHeal());
    }

}