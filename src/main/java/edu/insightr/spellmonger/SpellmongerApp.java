package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.*;

/*
Déporter SpellmongerApp, checkPlayers, drawACard, displayPlayers et nextRound
dans une nouvelle classe Party ?
 */

public class SpellmongerApp {

    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    private ArrayList<Card> cardPool;   // cards stack for the game
    private ArrayList<Card> graveyard;  // cards trash
    private ArrayList<Player> players = new ArrayList<Player>();    // list of players
    private ArrayList<Player> eliminated = new ArrayList<Player>(); // for eliminated players

    private int roundCounter = 0;   // game round
    private int currentPlayer;


    private SpellmongerApp(int nbrCards) {

        // creation des structures
        cardPool = new ArrayList<Card>();
        graveyard = new ArrayList<Card>();

        // on crée des variables qui serviront de références, pour ne pas réécrire inutilement du code
        int modulo = 6;
        int nbrRitual = 2;
        int nbrCreature = 3;

        // modification du code précédent, j'ai changé la génération du deck.
        // un modulo simple qui détermine si c'est une cr?ature ou un blesing, et qui ajoute de fa?on ?gale chaque carte
        // (1 rituel sur 2 est curse l'autre blessing
        // (1 monstre sur 3 est aigle/wolf/bear)
        for (int i = 0; i < nbrCards; i++) {
            if (i % modulo == 0) {
                // ritual
                switch (i % nbrRitual) {
                    case 0:
                        cardPool.add(new Ritual("Curse", -3));
                        break;
                    case 1:
                        cardPool.add(new Ritual("Blessing", 3));
                        break;
                }
            } else {
                // creature
                switch (i % nbrCreature) {
                    case 0:
                        cardPool.add(new Creature("Eagle", 1));
                        break;
                    case 1:
                        cardPool.add(new Creature("Wolf", 2));
                        break;
                    case 2:
                        cardPool.add(new Creature("Bear", 3));
                        break;
                }
            }
        }

        logger.info("cardPool size : " + cardPool.size());

        // shuffle the cards list
        Collections.shuffle(cardPool);

    }

    /**
     * Return TRUE if the winner is found
     *
     * @return boolean
     */
    private void checkPlayers() {
        ArrayList<Player> keep = new ArrayList<Player>(); // players to keep in play
        // check all players
        for (Player p : players) {
            if (p.getHealthPoint() > 0) {
                keep.add(p);
            } else {
                logger.info("* Player " + p.getName() + " is eliminated !");
                eliminated.add(p);
            }
        }
        players = keep;
    }


    private void nextRound() {
        roundCounter++;
        if (++currentPlayer >= players.size()) currentPlayer = 0;
    }

    /**
     * methode principale
     *
     * @param args
     */
    public static void main(String[] args) {

        SpellmongerApp app = new SpellmongerApp(70);

        int START_HP = 150;

        // ajout des joueurs a la partie
        app.players.add(new Player("Alf", START_HP));
        app.players.add(new Player("Bob", START_HP));
        app.players.add(new Player("Cid", START_HP));
        app.players.add(new Player("Don", START_HP));

        // randomize starting player
        app.currentPlayer = (int) Math.floor(Math.random() * app.players.size());

        // main game loop
        while (app.players.size() > 1) {

            // play one round
            app.drawACard();

            // elimination
            app.checkPlayers();

            // display game status
            app.displayPlayers();

            // prepare for next round
            app.nextRound();

        }

        logger.info("\n");
        logger.info("********************************************");
        logger.info("THE WINNER IS " + app.players.get(0).getName() + " ! ");
        logger.info("********************************************");

    }


    private void drawACard() {

        logger.info("\n");
        logger.info("Playing round " + roundCounter);

        // get the player
        Player curPlayer = players.get(currentPlayer);
        Card curCard;

        if (cardPool.size() > 0) {
            // take the first card out of stack
            curCard = cardPool.remove(0); // remove gets the card out of stack !
        } else {
            // no more cards in stack : using a special card Exhaust
            curCard = new Ritual("Exhaust", 0);
        }

        logger.info("Player " + curPlayer.getName() + " plays " + curCard.getName());

        // apply heal to player (if any)
        // note : Creature cards returns 0 heal
        curPlayer.setHealthPoint(curCard.getHeal());
        logger.info("Player " + curPlayer.getName() + " is healed for " + curCard.getHeal() + " points");

        // apply card + deck damages to other player
        for (Player p : players) {
            if (p != curPlayer) {
                int damCard = curCard.getDamages();
                int damDeck = curPlayer.getDeckDamages();
                // apply damages card + deck
                // note : Blessing cards return 0 damages, others cards do
                p.setHealthPoint(- (damCard + damDeck));
                logger.info("Player " + p.getName() + " is damaged for " + damCard + " + " + damDeck + " points");
            }
        }

        // add card to player's deck or discard it
        if (!curPlayer.addCardToDeck(curCard)) {
            // add card to trash
            graveyard.add(curCard);
        }

    }

    /**
     * display list of players with HP
     */
    private void displayPlayers() {
        logger.info("Players status summary :");
        for (Player p : players) {
            logger.info("- Player " + p.getName() + " : health = " + p.getHealthPoint());
        }
    }

}
