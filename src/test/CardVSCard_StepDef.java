package edu.insightr.spellmonger;

import cucumber.api.java.en.Given;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by adrianpothuaud on 07/12/2016.
 */
public class CardVSCard_StepDef {

    // Définition des interfaces
    public IhmConsole ihm = new IhmConsole();
    public IA_v1 ia = new IA_v1();

    // creating the game
    public Game game = new Game(ihm, ia);

    // creation des joueurs
    public Player p1, p2;

    // mapping between player name and payer instance
    public ArrayList<String> names;
    public ArrayList<Player> players;

    @Given("^\"([^\"]*)\" and \"([^\"]*)\" enter the game, receive (\\d+) cards and (\\d+) life points$")
    public void andEnterTheGameReceiveCardsAndLifePoints(String player1, String player2, int nbCards, int hp) throws Throwable {

        names = new ArrayList<String>();
        players = new ArrayList<Player>();

        p1 = new Player(player1, ihm);
        p2 = new Player(player2, ihm);

        names.add(player1);
        players.add(p1);
        names.add(player2);
        players.add(p2);

        // ajout des joueurs a la partie
        game.addPlayer(p1);
        game.addPlayer(p2);

        // verify player's hp
        assert (p1.getHealthPoint() == hp && p2.getHealthPoint() == hp);
    }

    @Given("^\"([^\"]*)\" plays a \"([^\"]*)\"$")
    public void playsA(String playerName, String cardType) throws Throwable {

        // create card and add to player
        Card c;

        // cardType could be: [Heal, Poison, Shield, Wolf, Eagle, Bear]
        // if ritual
        if(cardType == Ritual.RITUAL_MEDICINE) c = new Ritual(Ritual.RITUAL_MEDICINE);
        else if(cardType == Ritual.RITUAL_POISON) c = new Ritual(Ritual.RITUAL_POISON);
        else if(cardType == Ritual.RITUAL_SHIELD) c = new Ritual(Ritual.RITUAL_SHIELD);
            // if creature
        else if(cardType == Creature.CREA_BEAR) c = new Creature(Creature.CREA_BEAR);
        else if(cardType == Creature.CREA_EAGLE) c = new Creature(Creature.CREA_EAGLE);
        else c = new Creature(Creature.CREA_WOLF);

        // add card to player hand
        players.get(names.indexOf(playerName)).addCardToDeck(c);
    }

    public Player checkWinner(){

        int p1hp = players.get(0).getHealthPoint(), p2hp = players.get(1).getHealthPoint();

        return (p1hp > p2hp) ? p1 : p2;

    }

    @Given("^\"([^\"]*)\" wins the round$")
    public void winsTheRoud(String player) throws Throwable {

        //game.playRound();


        // verify winner by checking players hp

    }
}
