package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Created by Rod on 08/10/2016.
 */
public abstract class IA {
    public abstract void cardsDistributed(Deck d, int pos);
    public abstract Card askForCard(Player p);
}
