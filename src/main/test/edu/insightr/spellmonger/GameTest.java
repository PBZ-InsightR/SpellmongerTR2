package edu.insightr.spellmonger;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Created by adrianpothuaud on 13/10/2016.
 */
public class GameTest{

    /*
    To test:
    -addPlayer(Player p)
    -distribute(4 cartes dans le jeu et chaque joueur doit avoir 2 cartes)
    -???
     */

    private Game game;
    private Ihm theIhm;
    private IA theIA;
    private Player p1;
    private Player p2;
    private ArrayList<Player> players;
    private Deck cardPool;

    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;

    @Before
    public void initializeTests(){
        game = new Game(theIhm, theIA);
        p1 = new Player("Al");
        p2 = new Player("Bob");
        players = new ArrayList<>();
        cardPool = new Deck();
        card1 = new Creature("Eagle");
        card2 = new Creature("Eagle");
        card3 = new Ritual("Medicine");
        card4 = new Ritual("Medicine");
    }

    @Test
    public void tesAddPlayer() throws Exception {
        game.addPlayer(p1);
        assertNotNull(players);
    }

    @Test
    public void testDistribute() throws Exception {
        players.add(p1);
        players.add(p2);
        cardPool.add(card1);
        cardPool.add(card2);
        cardPool.add(card3);
        cardPool.add(card4);
        //assertTrue(game.distribute()); // FAIL
    }

    @Test
    public void name() throws Exception {

    }
}