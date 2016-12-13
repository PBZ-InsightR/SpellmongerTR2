package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by adrianpothuaud on 14/10/2016.
 */
public class IhmConsoleTest {

    private Player playerHuman;
    private Player playerIA;
    private Deck deck;
    private Card cardE;
    private Card cardW;
    private Card cardB;
    private IhmConsole ihm;

    @Before
    public void InitializeTests() throws Exception {
        ihm = new IhmConsole();
        playerHuman = new Player("Hum", ihm);
        //playerIA = new Player("Bot", ihm);
        //playerIA = new Player("Bot", ia);
        deck = new Deck();
        cardE = new Creature("Eagle");
        cardW = new Creature("Wolf");
        ihm = new IhmConsole();
    }

    @Test//returns first card of player's hand
    public void askForCard_1Card_inDeck() throws Exception {
        //needs a player
        //1st test 1 card in deck
        playerHuman.addCardToDeck(cardB);
        org.junit.Assert.assertEquals(ihm.askForCard(playerHuman), cardB);
    }

    @Test//returns first card of player's hand
    public void askForCard_SevCards_inDeck() throws Exception {
        //needs a player
        //1st test 1 card in deck
        playerHuman.addCardToDeck(cardB);
        playerHuman.addCardToDeck(cardE);
        playerHuman.addCardToDeck(cardW);
        org.junit.Assert.assertTrue(ihm.askForCard(playerHuman) instanceof Card);
    }

    //les autres méthodes sont des méthodes de logging, pas de tests nécessaires...

}