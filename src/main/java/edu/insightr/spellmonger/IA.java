package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Used to define intelligent IA (using a strategy)
 * Created by Rod on 08/10/2016.
 */
abstract class IA {
    public abstract void cardsDistributed(Deck d, int pos);
    public abstract Card askForCard(Player p);
}
