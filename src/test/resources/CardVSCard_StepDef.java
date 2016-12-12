package edu.insightr.spellmonger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.lang.model.type.NullType;
import java.util.Map;

/**
 * Created by adrianpothuaud on 07/12/2016.
 */
public class CardVSCard_StepDef {

    // Définition des interfaces
    IhmConsole ihm = new IhmConsole();
    IA_v1 ia = new IA_v1();

    // creating the game
    Game game = new Game(ihm, ia);

    // creation des joueurs
    Player p1, p2;

    // mapping between player name and payer instance
    Map<String, Player> myMap;

    @Given("^\"([^\"]*)\" and \"([^\"]*)\" enter the game, receive (\\d+) cards and (\\d+) life points$")
    public void andEnterTheGameReceiveCardsAndLifePoints(String player1, String player2, int nbCards, int hp) throws Throwable {

        p1 = new Player(player1, ihm);
        p2 = new Player(player2, ihm);

        myMap.put(player1, p1);
        myMap.put(player2, p2);

        // ajout des joueurs a la partie
        game.addPlayer(p1);
        game.addPlayer(p2);

        // verify player's hp
        assert (p1.getHealthPoint() == hp && p2.getHealthPoint() == hp);

    }

    @When("^\"([^\"]*)\" plays a \"([^\"]*)\"$")
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
        myMap.get(playerName).addCardToDeck(c);

    }

    public Player checkWinner(Map<String, Player> myMap){

        int p1hp = myMap.get(p1).getHealthPoint(), p2hp = myMap.get(p2).getHealthPoint();

        return (p1hp > p2hp) ? p1 : p2;

    }

    @Then("^\"([^\"]*)\" wins the round$")
    public void winsTheRoud(String player) throws Throwable {

        game.playRound();

        // verify winner by checking players hp
        assert(checkWinner(myMap) == myMap.get(player));

    }
}
