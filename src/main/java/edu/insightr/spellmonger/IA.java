package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Used to define intelligent IA (using a strategy)
 * Created by Paul on 21/10/2016.
 */
abstract class IA {

    public abstract void cardsDistributed();

    public abstract void cardsAlreadyPlayed(Deck played, int roundsPlayed);

    // a modifier pour ne passer à l'IA que les PV des adversaires
    public abstract Card askForCard(ArrayList<Player> players, int currentPlayerPos);

    public abstract void boardPlayed(Deck board);
}
