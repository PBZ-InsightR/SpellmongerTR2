package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Used to define intelligent IA (using a strategy)
 * Created by Paul on 21/10/2016.
 */
public abstract class IA {
    protected static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    public abstract void cardsDistributed();
    /*public abstract void cardsAlreadyPlayed(Deck played, int roundsPlayed);
    // a modifier pour ne passer à l'IA que les PV des adversaires
    public abstract Card askForCard(ArrayList<Player> players, int currentPlayerPos);
    public abstract void boardPlayed(Deck board);
    */
    //private abstract int cardCompt(Deck d);
    public abstract void memorizeCard(Deck d);
    public abstract Card askForCard(ArrayList<Player> players, int currentPlayerPos);
    public abstract void boardPlayed(Deck board);
    //private abstract Card getCard(Deck d, String[] names);
    //private abstract double lifeCmpt(ArrayList<Player> p, int posIA);
}

