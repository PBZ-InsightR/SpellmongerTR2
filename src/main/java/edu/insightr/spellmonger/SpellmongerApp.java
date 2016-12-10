package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

/*
Déporter SpellmongerApp, checkPlayers, drawACard, displayPlayers et nextRound
dans une nouvelle classe Party ?
 */

public class SpellmongerApp {

    private static final Logger logger = Logger.getLogger(SpellmongerApp.class);

    private SpellmongerApp(int nbrCards) {


    }


    /**
     * methode principale
     *
     * @param args : default
     */
    public static void main(String[] args) {


        //Définition des interfaces
        IhmConsole ihm = new IhmConsole();
        IA_v1 ia = new IA_v1();

        //creating the game
        Game game = new Game(ihm, ia);

        // ajout des joueurs a la partie
        game.addPlayer(new Player("Alf", ia));
        game.addPlayer(new Player("Bob",  ihm));
        //game.addPlayer(new Player("Cid"));
        //game.addPlayer(new Player("Don"));

        game.start();


    }


}
