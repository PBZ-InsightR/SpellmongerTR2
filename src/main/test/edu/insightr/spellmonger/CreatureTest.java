package edu.insightr.spellmonger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jessica on 03/10/2016.
 * Test methods of class Creature
 */
public class CreatureTest {
    @Test
    public void testGetDamages() throws Exception {
        Creature eagle = new Creature("Eagle", 1);
        assertEquals(1, eagle.getDamages());
    }

    @Test
    public void testGetHeal() throws Exception {
        Creature wolf = new Creature("Wolf", 1);
        assertEquals(0, wolf.getHeal());
    }
}