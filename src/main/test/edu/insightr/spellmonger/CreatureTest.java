package edu.insightr.spellmonger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jessica on 03/10/2016.
 * modified by Adrian
 * Test methods of class Creature
 */
public class CreatureTest {

    @Before
    public void initializeTests(){
        Creature eagle = new Creature("Eagle", 1);
        Creature wolf = new Creature("Wolf", 1);
    }

    @Test
    public void testGetDamages() throws Exception {
        assert(eagle instanceof Creature);
        assertEquals(1, eagle.getDamages());
    }

    @Test
    public void testGetHeal() throws Exception {
        assertEquals(0, wolf.getHeal());
    }
}