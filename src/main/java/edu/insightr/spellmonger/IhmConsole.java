package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Used to define "human" player on console
 * Created by Rod on 07/10/2016.
 */
class IhmConsole extends Ihm {
    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    public Card askForCard(Player p) {
        return p.getPlayHand().get(0);
    }

    public void showDistribution(Deck d, int pos) {
        logger.info("** player #" + pos + " gets cards : " + d.toString());
    }

    public void showPlayers(ArrayList<Player> players) {
        players.forEach(p -> {
            logger.info("- Player " + p.getName() + " : health = " + p.getHealthPoint());
        });
    }

    public void showPlayerHand(Deck deck, int position) {
        logger.info("- Hand of player #" + position + ": " + deck.toString());
    }

    public void showPlayedCards(Deck d) {
        logger.info("=== HANDS PLAYED : ");
        for (int pos = 0; pos < d.size(); pos++) {
            logger.info("  > player #" + pos + " plays : " + d.get(pos).getName());
        }
    }

    public void showWinner(Player winner) {
        logger.info("\n");
        logger.info("********************************************");
        if (winner != null)
            logger.info("THE WINNER IS " + winner.getName() + " ! ");
        else
            logger.info("DRAW !");
        logger.info("********************************************");

    }

}
