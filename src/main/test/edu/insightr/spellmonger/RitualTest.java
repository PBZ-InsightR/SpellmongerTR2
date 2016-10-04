package edu.insightr.spellmonger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jessica on 03/10/2016.
 * Used to test class Ritual
 */
public class RitualTest {
    @Test
    public void getDeltaPoints() throws Exception {
        Ritual ritual = new Ritual("Blessing", 3);
        assertEquals(3, ritual.getDeltaPoints());
    }

    @Test
    public void isHeal() throws Exception {
        Ritual ritual = new Ritual("Blessing", 3);
        assertTrue(ritual.isHeal());
    }

    @Test
    public void isDamage() throws Exception {
        Ritual ritual = new Ritual("Curse", -3);
        assertTrue(ritual.isDamage());
    }
/*
    @Test
    public void getDamages() throws Exception {

    }

    @Test
    public void getHeal() throws Exception {
    }
*/
}