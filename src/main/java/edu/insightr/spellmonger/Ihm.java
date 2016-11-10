package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Used to define human interface
 * Created by Rod on 07/10/2016.
 */
abstract class Ihm {
    protected static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    public abstract Card askForCard(Player p);
    public abstract void showPlayers(ArrayList<Player> players);
    public abstract void showPlayerHand(Deck hand, int position);
    public abstract void showDistribution(Deck d, int pos);
    public abstract void showPlayedCards(Deck d);
    public abstract void showWinner(Player winner);
}

