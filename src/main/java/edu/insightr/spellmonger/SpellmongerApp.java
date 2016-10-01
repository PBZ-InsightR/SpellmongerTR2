package edu.insightr.spellmonger;

import org.apache.log4j.Logger;
import org.apache.log4j.pattern.IntegerPatternConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

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
        // on crée des variables qui serviront de références, pour ne pas réécrire inutilement du code
        int modulo = 6;
        int nbrRitual = 2;
        int nbrCreature = 3;


        // modification du code précédent, j'ai changé la génération du deck.
        // un modulo simple qui détermine si c'est une cr?ature ou un blesing, et qui ajoute de fa?on ?gale chaque carte
        // *1 rituel sur 2 est curse l'autre blessing
        // *1 monstre sur 3 est aigle/wolf/bear)
        //
        // A la fin on utilise la methode void shuffle(List) de la classe Collections pour réordonner tous les éléments
        // de la liste de façon aléatoire
        for (int i = 0; i < 70; i++) {
            if (i % modulo == 0) {
                // ritual
                switch (i % (modulo * nbrRitual)) {
                    case 0:
                        cardPool.add(new Curse());
                        break;
                    case 1:
                        cardPool.add(new Blessing());
                        break;
                }
            } else {
                // creature
                switch (i % (modulo * nbrCreature)) {
                    case 0:
                        cardPool.add(new Eagle());
                        break;
                    case 1:
                        cardPool.add(new Wolf());
                        break;
                    case 2:
                        cardPool.add(new Bear());
                        break;
                }
            }

        }
        Collections.shuffle(cardPool);//réordonner tous les éléments de la liste de façon aléatoire
    }

    public static void main(String[] args) {
        SpellmongerApp app = new SpellmongerApp();

        boolean onePlayerDead = false;
        Player currentPlayer = new Player("Alice", 20);
        Player opponent = new Player("Bob", 20);
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

        String nameType = cardPool.get(currentCardNumber).getName();
        switch(nameType){
            case "Eagle" :
            case "Bear" :
            case "Wolf" :
                logger.info(currentPlayer.getName() + " draw a Creature : " + cardPool.get(currentCardNumber).getName());
                playersCreature.put(currentPlayer.getName(), playersCreature.get(currentPlayer.getName()) + 1);
                currentPlayer.getDeck().addCard(cardPool.get(currentCardNumber));
                break;

            case "Blessing" :
                logger.info(currentPlayer.getName() + " draw a Blessing");
                playersLifePoints.put(opponent.getName(), (playersLifePoints.get(currentPlayer.getName()) + 3));
                currentPlayer.setHealthPoint(3);
                break;

            case "Curse" :
                logger.info(currentPlayer.getName() + " draw a Curse");
                playersLifePoints.put(opponent.getName(), (playersLifePoints.get(opponent.getName()) - 3));
                opponent.setHealthPoint(-3);
                break;
        }
        playersLifePoints.put(opponent.getName(), (playersLifePoints.get(opponent.getName()) - currentPlayer.getDeck().getDamages()));
        opponent.setHealthPoint(currentPlayer.getDeck().getDamages());
        logger.info("The " + currentPlayer.getDeck().getSize() + " creatures of " + currentPlayer.getName() + " attack and deal " + currentPlayer.getDeck().getDamages() + " damages to its opponent");
    }



}
