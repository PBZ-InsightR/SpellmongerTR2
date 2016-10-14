package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Jessica on 03/10/2016.
 * modified by Adrian
 * Test methods of class Creature
 */
public class CreatureTest {

    /*
    To test:
    -isShield()
    -getDamages()
    -getHeal()
     */

    private Creature eagle;
    private Creature wolf;
    private Creature bear;

    @Before
    public void initializeTests(){
        eagle = new Creature("Eagle");
        wolf = new Creature("Wolf");
        bear = new Creature("Bear");
    }

    @Test
    public void testIsShield() throws  Exception {
        assertFalse(eagle.isShield());
        assertFalse(wolf.isShield());
        assertFalse(bear.isShield());
    }

    @Test
    public void testGetDamages() throws Exception {
        assertEquals(1, eagle.getDamages());
        assertEquals(2, wolf.getDamages());
        assertEquals(3, bear.getDamages());
    }

    @Test
    public void testGetHeal() throws Exception {
        assertEquals(0, eagle.getHeal());
        assertEquals(0, wolf.getHeal());
        assertEquals(0, bear.getHeal());
    }
}