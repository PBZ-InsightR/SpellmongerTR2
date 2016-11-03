package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adrianpothuaud on 14/10/2016.
 */
public class IhmConsoleTest {

    /*
    To test:
    -askForCard(Player p)
    -showDistribution(Deck d, int pos)
    -showPlayers(ArrayList<Player> players)
    -showPlayerHand(Deck deck, int position)
    -showPlayedCards(Deck d)
    -showWinner(Player winner)
     */

    private Player p1;
    private Player p2;
    private Player winner;
    private Card card1;
    private Card card2;

    @Before
    public void initializeTests(){
        p1 = new Player("Al");
        p2 = new Player("Bob");
        card1 = new Creature("Eagle");
        card2 = new Ritual("Medicine");
        winner = p2;
    }


    @Test
    public void testAskForCard() throws Exception {
        p1.addCardToDeck(card1);
        p1.addCardToDeck(card2);
        assertEquals(card1, p1.getHand().get(0));
    }

    @Test
    public void testShowPlayers() throws Exception {

    }

    @Test
    public void testShowPlayerHand() throws Exception {

    }

    @Test
    public void testShowPlayedCards() throws Exception {

    }

    @Test
    public void testShowWinner() throws Exception {

    }

}