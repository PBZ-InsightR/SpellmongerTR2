package edu.insightr.spellmonger;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Used to manage "human" player on console
 * Created by Rod on 07/10/2016.
 */
class IhmConsole extends Ihm {

    public void showRound(int round) {
        System.out.println("Playing round #"+ round);
    }

    private int getDigit(int min, int max) {
        int c = 0;
        try {
            do {
                c = System.in.read()-'0';
            } while (c < min || c > max);
        } catch (IOException e) {
        }
        return c;
    }

    public Card askForCard(Player p) {
        System.out.printf("Player %s, it's your turn \n", p.getName());
        // demande quelle carte
        Deck d = p.getPlayHand();
        Card card;
        int size = d.size();
        int c = 0;
        // display choices
        System.out.print(d.toString());
        // player choose
        System.out.print("Choose a card from 1 to " + size + " : ");
        do {
            c = getDigit(1, size);
        } while (c < 1 || c > size);
        card = p.getPlayHand().get((c - 1));
        return card;
    }

    public void showDistribution(Deck d, int pos) {
        // not needed in ihm console
    }

    public void showPlayers(ArrayList<Player> players) {
        players.forEach(p -> {
            System.out.println("- Player " + p.getName() + " : health = " + p.getHealthPoint());
        });
    }

    public void showPlayerHand(Deck deck, int position) {
        // not needed in console ihm
    }

    public void showPlayedCards(Deck d) {
        System.out.println("=== HANDS PLAYED : ");
        for (int pos = 0; pos < d.size(); pos++) {
            System.out.println("  > player #" + pos + " plays : " + d.get(pos).getName());
        }
    }

    public void showWinner(Player winner) {
        System.out.println("\n");
        System.out.println("********************************************");
        if (winner != null)
            System.out.println("THE WINNER IS " + winner.getName() + " ! ");
        else
            System.out.println("DRAW !");
        System.out.println("********************************************");

    }

}
