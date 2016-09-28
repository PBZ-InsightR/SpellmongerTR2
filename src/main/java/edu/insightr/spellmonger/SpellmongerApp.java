package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellmongerApp {
    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    private Map<String, Integer> playersLifePoints = new HashMap<>(2);
    private Map<String, Integer> playersCreature = new HashMap<>(2);
    private List<Card> cardPool = new ArrayList<>(70);

    private SpellmongerApp() {
        playersLifePoints.put("Alice", 20);
        playersLifePoints.put("Bob", 20);
        playersCreature.put("Alice", 0);
        playersCreature.put("Bob", 0);
        int ritualMod = 3;

        for (int i = 0; i < 70; i++) {
            if (i % ritualMod == 0) {
                cardPool.add(new Ritual("curse"));
            }
            if (i % ritualMod != 0) {
                cardPool.add(new Creature("eagle"));
            }

            if (ritualMod == 3) {
                ritualMod = 2;
            } else {
                ritualMod = 3;
            }

        }
    }

    public static void main(String[] args) {
        SpellmongerApp app = new SpellmongerApp();

        boolean onePlayerDead = false;
        Player currentPlayer = new Player("Alice");
        Player opponent = new Player("Bob");
        int currentCardNumber = 0;
        int roundCounter = 1;
        Player winner = null;

        while (!onePlayerDead) {
            logger.info("\n");
            logger.info("***** ROUND " + roundCounter);

            app.drawACard(currentPlayer, opponent, currentCardNumber);

            logger.info(opponent.getName() + " has " + app.playersLifePoints.get(opponent.getName()) + " life points and " + currentPlayer.getName() + " has " + app.playersLifePoints.get(currentPlayer.getName()) + " life points ");

            if (app.playersLifePoints.get(currentPlayer.getName()) <= 0) {
                winner = opponent;
                onePlayerDead = true;
            }
            if (app.playersLifePoints.get(opponent.getName()) <= 0) {
                winner = currentPlayer;
                onePlayerDead = true;
            }

            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;

            currentCardNumber++;
            roundCounter++;
        }

        logger.info("\n");
        logger.info("******************************");
        logger.info("THE WINNER IS " + winner.getName() + " !!!");
        logger.info("******************************");


    }

    private void drawACard(Player currentPlayer, Player opponent, int currentCardNumber) {

        /*28.09 : not functionning ! name is never "creature" or "ritual" ...
        if ritual
        * */
        if ("eagle".equalsIgnoreCase(cardPool.get(currentCardNumber).getName())) {
            logger.info(currentPlayer.getName() + " draw a Creature");
            playersCreature.put(currentPlayer.getName(), playersCreature.get(currentPlayer.getName()) + 1);
            int nbCreatures = playersCreature.get(currentPlayer.getName());
            if (nbCreatures > 0) {
                playersLifePoints.put(opponent.getName(), (playersLifePoints.get(opponent.getName()) - nbCreatures));
                logger.info("The " + nbCreatures + " creatures of " + currentPlayer.getName() + " attack and deal " + nbCreatures + " damages to its opponent");
            }
        }
        if ("curse".equalsIgnoreCase(cardPool.get(currentCardNumber).getName())) {
            logger.info(currentPlayer.getName() + " draw a Ritual");
            int nbCreatures = playersCreature.get(currentPlayer.getName());
            if (nbCreatures > 0) {
                playersLifePoints.put(opponent.getName(), (playersLifePoints.get(opponent.getName()) - nbCreatures - 3));
                logger.info("The " + nbCreatures + " creatures of " + currentPlayer.getName() + " attack and deal " + nbCreatures + " damages to its opponent");
            }
            logger.info(currentPlayer.getName() + " cast a ritual that deals 3 damages to " + opponent);
        }
    }

}

