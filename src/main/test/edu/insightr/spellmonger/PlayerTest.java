package edu.insightr.spellmonger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jessica on 03/10/2016.
 * Used to test class Player
 */
public class PlayerTest {

    private Player player = new Player("A", 10);
    Deck deck = new Deck();
    Card cardC = new Creature("Eagle", 1);
    Card cardR = new Ritual("Curse", -3);

    @Test
    public void getHealthPoint() throws Exception {
        assertEquals(10, player.getHealthPoint());
    }

/*
    @Test
    public void getDeckDamages() throws Exception {
        deck.addCard(cardC);
        int deck_damage=deck.getDamages();
        assertEquals(deck_damage, player.getDeckDamages());
    }

    @Test
    public void setHealthPoint() throws Exception {
    }
*/
    @Test
    public void getName() throws Exception {
        assertEquals("A", player.getName());
    }
/*
    @Test
    public void addCardToDeck() throws Exception {
    }
*/
}