package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by Jessica on 03/10/2016.
 * modified by Adrian
 * Test methods of class Creature
 */
public class CreatureTest{

    private Creature cardE;
    private Creature cardW;
    private Creature cardB;

    @Before
    public void initializeTests(){
        cardE = new Creature("Eagle");
        cardW = new Creature("Wolf");
        cardB = new Creature("Bear");
    }

    @Test
    public void testIsShield() throws  Exception {
        assertFalse(cardE.isShield());
        assertFalse(cardW.isShield());
        assertFalse(cardB.isShield());
    }

    @Test
    public void testGetDamages() throws Exception {
        org.junit.Assert.assertEquals(1, cardE.getDamages());
        org.junit.Assert.assertEquals(2, cardW.getDamages());
        org.junit.Assert.assertEquals(3, cardB.getDamages());
    }

    @Test
    public void testGetHeal() throws Exception {
        org.junit.Assert.assertEquals(0, cardE.getHeal());
        org.junit.Assert.assertEquals(0, cardW.getHeal());
        org.junit.Assert.assertEquals(0, cardB.getHeal());
    }
}