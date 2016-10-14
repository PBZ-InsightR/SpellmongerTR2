package edu.insightr.spellmonger;

import java.util.*;


/**
 * Used to define intelligent IA (using a strategy)
 * Created by Rod on 08/10/2016.
 * update by thomas
 */
abstract class IA {
    public abstract void cardsDistributed(Deck d, int pos);
    public abstract Card askForCard(Player p);
    /*public Card askForCard(Player p)
    {
        Deck main= p.getHand();
        Deck graveyard=Game.graveyard;
        if(graveyard.isEmpty()){
            Random rand = new Random();
            return main.get(rand.nextInt(main.size()));
        }
        else{
            Map<Card, Integer> frequencyMain = CollectionUtils.getCardinalityMap(main);
            //ne fonctionne pas jen'arrive pas a trouver CollectionUtils dans les bibli
        }
    }*/
}

