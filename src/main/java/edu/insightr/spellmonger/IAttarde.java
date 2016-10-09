package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Created by Rod on 08/10/2016.
 *
 * IA d'attardé, pour test rapide
 * Pour jouer, cette IA renvoie la 1ere carte de la main du joueur
 */
public class IAttarde extends IA {

    public Card askForCard(Player p) {
        return p.getHand().get(0);
    }

    public void cardsDistributed(Deck d, int pos) {
        // Gnééé pas besoin
    }

}
