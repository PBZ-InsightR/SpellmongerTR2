package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Created by Rod on 08/10/2016.
 *
 * IA d'attardé, pour test rapide
 * Pour jouer, cette IA renvoie la 1ere carte de la main du joueur
 */
public class IA_v1 extends IA {

    int deckPow = 0;

    public void cardsAlreadyPlayed(Deck played, int roundsPlayed) {
        // unused at the moment
        logger.info("called: cardsAlreadyPlayed");
    }

    private Card getCard(Deck d, String[] names) {
        Card c;
      for (int i=0; i<names.length; i++) {
          c = d.findFromName(names[i]);
          if (c != null) return c; // found
      }
      // none found, return first card
      return d.get(0);
    }

    public Card askForCard(ArrayList<Player> players, int currentPlayerPos) {
        Player p = players.get(currentPlayerPos);
        Deck hand = p.getPlayHand();
        double cmptHealth = lifeCmpt(players, currentPlayerPos);
        Card choosen = null;
        if (currentPlayerPos != 1) {
            if (deckPow < 0) {
                choosen = getCard(hand, new String[]{"Poison", "Bear", "Wolf", "Eagle", "Shield", "Medicine"});
            } else {
                choosen = getCard(hand, new String[]{"Shield", "Medicine", "Poison", "Bear", "Eagle", "Wolf"});
            }
        }
        else {
            if (deckPow < 0) {
                choosen = getCard(hand, new String[]{"Shield", "Medicine", "Poison", "Bear", "Eagle", "Wolf"});
            } else {
                choosen = getCard(hand, new String[]{"Poison", "Bear", "Wolf", "Eagle", "Shield", "Medicine"});
            }
        }
        return choosen;
    }

    public int calcBoardPower(Deck d){
        logger.info("*IA* calcBoardPower");
        int res = 0;
        int delta=0;
        for (int i=0; i<d.size(); i++){
            Card myCard = d.get(i);
            switch (myCard.getName()){
                case "Bear" :
                case "Poison" :
                    delta = -2;
                    break;
                case "Shield" :
                case "Medicine" :
                case "Eagle" :
                    delta = 2;
                    break;
                case "Wolf" :
                    delta = -1;
                    break;
            }
            logger.info("  *IA* " + myCard.getName() + " : " + delta);
            res += delta;
        }
        return res;
    }

    private double lifeCmpt(ArrayList<Player> p, int posIA){
        double sum = 0;
        for (int i=0; i<p.size(); i++) {
            if (i != posIA) {
                sum += p.get(i).getHealthPoint();
            }
        }
        return p.get(posIA).getHealthPoint() - sum / p.size();
    }

    public void cardsDistributed() {
        deckPow = 0;
    }

    public void boardPlayed(Deck board) {
        deckPow += calcBoardPower(board);
        logger.info("*IA* deck power : "+ deckPow);
    }
}
