package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Created by Rod on 07/10/2016.
 */
public abstract class Ihm {
    public abstract Card askForCard(Player p);
    public abstract void showPlayers(ArrayList<Player> players);
    public abstract void showPlayerHand(Deck hand, int position);
    public abstract void showDistribution(Deck d, int pos);
    public abstract void showPlayedCards(Deck d);
    public abstract void showWinner(Player winner);
}

