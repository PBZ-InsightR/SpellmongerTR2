package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jessica on 03/10/2016.
 * modified by Adrian
 * Test methods of class Creature
 */
public class CreatureTest {

    private Creature eagle;
    private Creature wolf;

    @Before
    public void initializeTests(){
        eagle = new Creature("Eagle");
        wolf = new Creature("Wolf");
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