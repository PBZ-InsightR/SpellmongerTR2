
package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * Used to define game constants (such as hp, decks, ...)
 * Created by Rod on 07/10/2016.
 * Update by Loiseau Thomas et Michon Paul
 */
class Game {
    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    private final int START_HEALTHPOINTS = 20;    // starting health points for players

    private Ihm ihm;    // the ihm used for the game
    private IA ia;      // the IA used for the game
    private final Map<String, Integer> tabCards = new HashMap<>();  // for cards repartition
    private Deck cardPool = new Deck();   // cards stack for the game

    private ArrayList<Player> players = new ArrayList<>();    // list of players
    private ArrayList<Player> eliminated = new ArrayList<>(); // for eliminated players

    private int roundCounter;   // game round


    Game(Ihm theIhm, IA theIA) {
        ihm = theIhm;
        ia = theIA;
        // initialize cards types & quantities
        tabCards.put("Poison", 2);
        tabCards.put("Shield", 5);
        tabCards.put("Medicine", 3);
        tabCards.put("Eagle", 10);
        tabCards.put("Wolf", 10);
        tabCards.put("Bear", 10);
    }


    boolean addPlayer(Player p) {
        return players.add(p);
    }


    private void buildDeck() {
        // on crée les cartes en fonction de la répartition prévue dans tabCards
        tabCards.forEach((cardName, cardNbr) -> {
            for (int i = 0; i < cardNbr; i++) {
                try {
                    // on tente de creer une Ritual, une erreur arrivera si c'est une Creature
                    cardPool.add(new Ritual(cardName));
                } catch (IllegalArgumentException e) {
                    // on n'a pas pu créer une Ritual, on tente de créer une Creature
                    // si erreur => plantage normal, pas de try catch ici
                    cardPool.add(new Creature(cardName));
                }
            }
        });
    }


    private boolean Initialize() {
        boolean bRes = false;

        roundCounter = 0;

        if (players.size() >= 2) {

            // cree le deck de jeu
            buildDeck();

            Collections.shuffle(cardPool);

            // initialise les PV des joueurs
            players.forEach(p -> p.setHealthPoint(START_HEALTHPOINTS));

            logger.info("cardPool size : " + cardPool.size());

            if (distribute()) {
                // c'est bon
                bRes = true;
            }
        }
        return bRes;
    }

    private boolean distribute() {
        // on distribue tout le paquet (nombre égal pour chaque joueur)
        int nbr = cardPool.size() / players.size();
        // on distribue le nombre de cartes prévu à chaque joueur
        for (int i = 0; i < nbr; i++) {
            // pour chaque joueur, on retire la 1ere carte du deck, et on
            // la donne au joueur
            players.forEach(p -> p.addCardToDeck(cardPool.draw()));
        }

        // fournit à l'IA les joueurs (avec leur deck)
        for (int i=0; i< players.size(); i++) {
          Player p = players.get(i);
            if (p.isIA()) ia.cardsDistributed(p.getHand(), i);
            ihm.showDistribution(p.getHand(), i);
        }
        return true;
    }


    private void playRound() {

        nextRound();

        logger.info("\n");
        logger.info("Playing round " + roundCounter);
        Deck board = new Deck(players.size());

        // fournit les mains des joueurs à l'ihm avant le jeu
        for (int pos = 0; pos < players.size(); pos++) {
            ihm.showPlayerHand(players.get(pos).getHand(), pos);
        }

        // récupère les cartes jouées par chaque joueur
        for (int pos = 0; pos < players.size(); pos++){
            Player p = players.get(pos);
            Card c;
            if (p.isIA()) {
                c = ia.askForCard(players, pos);
            } else {
                c = ihm.askForCard(p);
            }
            // sort la carte jouée de la main du joueur
            p.getHand().remove(c);
            // attention : en cas de thread asynchrones, on va avoir un souci avec la position
            board.add(c);
        }

        // si besoin, l'ihm montre le board joué
        ihm.showPlayedCards(board);

        // on va calculer les rencontres entre tous les joueurs
        // on part du joueur 0, jusqu'à l'avant-dernier
        // (le dernier ayant déjà rencontré tout le monde à la fin de la boucle)
        for (int idxAttack = 0; idxAttack < players.size() - 1; idxAttack++) {
            Card cAttack = board.get(idxAttack);
            Player pAttack = players.get(idxAttack);
            // on traite le soin du joueur à l'attaque
            pAttack.changeHealthPoints(cAttack.getHeal());

            // on traite chaque joueur restant
            for (int idxDefend = idxAttack + 1; idxDefend < players.size(); idxDefend++) {
                Card cDefend = board.get(idxDefend);
                Player pDefend = players.get(idxDefend);
                // on calcule le résultat de la rencontre
                matchCards(cAttack, pAttack, cDefend, pDefend);
            }
        }

        // on remet les cartes du board dans le tas
        cardPool.addAll(board);
        board.clear();

        // on regarde si un joueur a perdu
        checkPlayers();

    }

    private void matchCards(Card c1, Player p1, Card c2, Player p2) {
        int d1 = c1.getDamages();
        int d2 = c2.getDamages();
        if (c1 instanceof Creature && c2 instanceof Creature) {
            // 2 creatures s'affrontent
            if (d1 > d2) {
                // le joueur 2 mange sa race
                p2.changeHealthPoints(-(d1 - d2));
            } else if (d2 > d1) {
                // le joueur 1 mange sa race
                p1.changeHealthPoints(-(d2 - d1));
            }
            // note : si 2 creatures identiques, rien ne se passe
        } else {
            // 2 rituels s'affrontent ou 1 rituel affronte 1 creature
            if (!c1.isShield() && !c2.isShield()) {
                // pas de shield présent, on applique les dégats éventuels aux 2 joueurs
                p1.changeHealthPoints(-d2);
                p2.changeHealthPoints(-d1);
            }
        }
    }

    private void nextRound() {
        roundCounter++;
        // si les joueurs n'ont plus de cartes, on redistribue
        if (players.get(0).getHand().size() == 0) {
            Collections.shuffle(cardPool);
            distribute();
        }
    }


    /**
     * Remove dead players
     *
     *
     */
    private void checkPlayers() {
        ArrayList<Player> keep = new ArrayList<>(); // players to keep in play
        // check all players
        for (Player p : players) {
            if (p.getHealthPoint() > 0) {
                logger.info("* Player " + p.getName() + " has " + p.getHealthPoint() + " HP left !");
                keep.add(p);
            } else {
                logger.info("* Player " + p.getName() + " is eliminated !");
                eliminated.add(p);
            }
        }
        players = keep;
    }


    private Player getWinner() {
        if (players.size() > 0) return players.get(0);
        else return null;
    }


    private boolean isEnded() {
        return players.size() < 2;
    }


    boolean start() {
        boolean bRes = false;
        if (ihm == null) throw new MissingResourceException("IHM object not defined", "Ihm", "100");
        if (ia == null) throw new MissingResourceException("IA object not defined", "IA", "200");
        if (Initialize()) {
            while (!isEnded()) {
                playRound();
            }
            Player winner = getWinner();
            ihm.showWinner(winner);

            bRes = true;
        }
        return bRes;
    }

}
