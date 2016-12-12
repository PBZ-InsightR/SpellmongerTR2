package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by adrianpothuaud on 13/10/2016.
 */
public class GameTest{

    /*
    Write test for:
    -buildDeck
    -Initialize
    -PlayRound
    -matchCards
    -nextRound
    -checkPlayers
    -start
     */

    private Game game;
    private Ihm ihm;
    private IA ia;
    private Map<String, Integer> tabCards;
    private ArrayList<Player> players;
    private Deck cardPool;

    private Player p1;
    private Player p2;
    private Card cardE1;
    private Card cardE2;
    private Card cardM1;
    private Card cardM2;

    @Before
    public void initializeTests(){
        ia = new IA_v1();
        ihm = new IhmConsole();
        game = new Game(ihm, ia);
        tabCards = new HashMap<>();
        players = new ArrayList<>();
        cardPool = new Deck();
        p1 = new Player("Al", ihm);
        p2 = new Player("Bob", ihm);
        cardE1 = new Creature("Eagle");
        cardE2 = new Creature("Eagle");
        cardM1 = new Ritual("Medicine");
        cardM2 = new Ritual("Medicine");
    }

    @Test
    public void tesAddPlayer() throws Exception {
        game.addPlayer(p1);
        assertNotNull(players);
    }


    @Test
    public void testBuildDeck() throws Exception {

    }


    @Test
    public void testInitialize() throws Exception {

    }

    @Test
    public void testDistribute() throws Exception {
        players.add(p1);
        players.add(p2);
        cardPool.add(cardE1);
        cardPool.add(cardE2);
        cardPool.add(cardM1);
        cardPool.add(cardM2);
        //assertTrue(game.distribute()); // FAIL
    }


    @Test
    public void testPlayRound() throws Exception {

    }

    @Test
    public void testMatchCards() throws Exception {

    }

    @Test
    public void testNextRound() throws Exception {

    }

    @Test
    public void testCheckPlayers() throws Exception {

    }

    @Test
    public void testGetWinner() throws Exception {
        assertNull(game.getWinner());
        game.addPlayer(p1);
        game.addPlayer(p2);
        assertEquals(p1,game.getWinner());
    }

    @Test
    public void testIsEnded() throws Exception {
        game.addPlayer(p1);
        assertTrue(game.isEnded());
        game.addPlayer(p2);
        assertFalse(game.isEnded());

    }

    @Test
    public void testStart() throws Exception {
        assertTrue(game.start());

    }
}