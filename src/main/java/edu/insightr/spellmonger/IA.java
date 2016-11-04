package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Used to define intelligent IA (using a strategy)
 * Created by Paul on 21/10/2016.
 */
abstract class IA {

    public abstract void cardsDistributed(Deck d, int pos);
    //public abstract Card askForCard(Player p);

    public abstract Card askForCard(ArrayList<Player> players, int currentPlayerPos);

    public abstract int cardCmpt(Deck d);

    public abstract double lifeCmpt(ArrayList<Player> p, int posIA);

    public abstract boolean inHand(String name, Deck myHand);
}
