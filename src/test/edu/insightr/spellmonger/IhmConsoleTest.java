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
    private Card cardP;
    private Card cardS;
    private Card cardM;
    private IhmConsole ihm;

    @Before
    public void InitializeTests() throws Exception {
        playerHuman = new Player("Hum");
        playerIA = new Player("Bot", false);
        deck = new Deck();
        cardE = new Creature("Eagle");
        cardW = new Creature("Wolf");
        cardB = new Creature("Bear");
        cardP = new Ritual("Poison");
        cardS = new Ritual("Shield");
        cardM = new Ritual("Medicine");
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