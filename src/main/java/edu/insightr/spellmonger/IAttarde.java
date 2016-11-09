package edu.insightr.spellmonger;

import java.util.ArrayList;

/**
 * Created by Rod on 08/10/2016.
 *
 * IA d'attardé, pour test rapide
 * Pour jouer, cette IA renvoie la 1ere carte de la main du joueur
 */
public class IAttarde extends IA {
/*
    public Card askForCard(ArrayList<Player> players, int currentPlayerPos) {
        Player p = players.get(currentPlayerPos);
        Deck hand = p.getHand();
        int cmptIA = cardCmpt(hand);
        double cmptHealth = lifeCmpt(players, currentPlayerPos);
        boolean cardInHand = false;
        Card choosen = null;
        if (cmptIA < -2){
            if (cmptHealth < -3){
                while (!cardInHand) {
                    double rand = Math.random();
                    if (rand < 0.45) {
                        if (inHand("Bear", hand)) {
                            choosen = new Creature("Bear");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.45 && rand < 0.9) {
                        if (inHand("Poison", hand)) {
                            choosen = new Ritual("Poison");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.9 && rand < 0.925) {
                        if (inHand("Shield", hand)) {
                            choosen = new Ritual("Shield");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.925 && rand < 0.95) {
                        if (inHand("Medicine", hand)) {
                            choosen = new Ritual("Medicine");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.95 && rand < 0.975) {
                        if (inHand("Eagle", hand)) {
                            choosen = new Creature("Eagle");
                            cardInHand = true;
                        }
                    } else {
                        if (inHand("Wolf", hand)) {
                            choosen = new Creature("Wolf");
                            cardInHand = true;
                        }
                    }
                }
            }
            else if (cmptHealth > 3){
                while (!cardInHand) {
                    double rand = Math.random();
                    if (rand < 0.03) {
                        if (inHand("Bear", hand)) {
                            choosen = new Creature("Bear");
                            cardInHand = true;
                        }
                    } else if (rand >=0.03  && rand < 0.06) {
                        if (inHand("Poison", hand)) {
                            choosen = new Ritual("Poison");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.06 && rand < 0.36) {
                        if (inHand("Shield", hand)) {
                            choosen = new Ritual("Shield");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.36 && rand < 0.4) {
                        if (inHand("Medicine", hand)) {
                            choosen = new Ritual("Medicine");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.4 && rand < 0.7) {
                        if (inHand("Eagle", hand)) {
                            choosen = new Creature("Eagle");
                            cardInHand = true;
                        }
                    } else {
                        if (inHand("Wolf", hand)) {
                            choosen = new Creature("Wolf");
                            cardInHand = true;
                        }
                    }
                }
            }
            else{
                while (!cardInHand) {
                    double rand = Math.random();
                    if (rand < 0.02) {
                        if (inHand("Bear", hand)) {
                            choosen = new Creature("Bear");
                            cardInHand = true;
                        }
                    } else if (rand >=0.02  && rand < 0.04) {
                        if (inHand("Poison", hand)) {
                            choosen = new Ritual("Poison");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.04 && rand < 0.28) {
                        if (inHand("Shield", hand)) {
                            choosen = new Ritual("Shield");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.28 && rand < 0.52) {
                        if (inHand("Medicine", hand)) {
                            choosen = new Ritual("Medicine");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.52 && rand < 0.76) {
                        if (inHand("Eagle", hand)) {
                            choosen = new Creature("Eagle");
                            cardInHand = true;
                        }
                    } else {
                        if (inHand("Wolf", hand)) {
                            choosen = new Creature("Wolf");
                            cardInHand = true;
                        }
                    }
                }
            }
        }
        else if (cmptIA > 2){
            if (cmptHealth < -3){
                while (!cardInHand) {
                    double rand = Math.random();
                    if (rand < 0.24) {
                        if (inHand("Bear", hand)) {
                            choosen = new Creature("Bear");
                            cardInHand = true;
                        }
                    } else if (rand >=0.24  && rand < 0.48) {
                        if (inHand("Poison", hand)) {
                            choosen = new Ritual("Poison");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.48 && rand < 0.72) {
                        if (inHand("Shield", hand)) {
                            choosen = new Ritual("Shield");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.72 && rand < 0.96) {
                        if (inHand("Medicine", hand)) {
                            choosen = new Ritual("Medicine");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.96 && rand < 0.98) {
                        if (inHand("Eagle", hand)) {
                            choosen = new Creature("Eagle");
                            cardInHand = true;
                        }
                    } else {
                        if (inHand("Wolf", hand)) {
                            choosen = new Creature("Wolf");
                            cardInHand = true;
                        }
                    }
                }
            }
            else if (cmptHealth > 3){
                while (!cardInHand) {
                    double rand = Math.random();
                    if (rand < 0.2) {
                        if (inHand("Bear", hand)) {
                            choosen = new Creature("Bear");
                            cardInHand = true;
                        }
                    } else if (rand >=0.2  && rand < 0.4) {
                        if (inHand("Poison", hand)) {
                            choosen = new Ritual("Poison");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.4 && rand < 0.5) {
                        if (inHand("Shield", hand)) {
                            choosen = new Ritual("Shield");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.5 && rand < 0.6) {
                        if (inHand("Medicine", hand)) {
                            choosen = new Ritual("Medicine");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.6 && rand < 0.8) {
                        if (inHand("Eagle", hand)) {
                            choosen = new Creature("Eagle");
                            cardInHand = true;
                        }
                    } else {
                        if (inHand("Wolf", hand)) {
                            choosen = new Creature("Wolf");
                            cardInHand = true;
                        }
                    }
                }
            }
            else{
                while (!cardInHand) {
                    double rand = Math.random();
                    if (rand < 0.03) {
                        if (inHand("Bear", hand)) {
                            choosen = new Creature("Bear");
                            cardInHand = true;
                        }
                    } else if (rand >=0.03  && rand < 0.06) {
                        if (inHand("Poison", hand)) {
                            choosen = new Ritual("Poison");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.6 && rand < 0.36) {
                        if (inHand("Shield", hand)) {
                            choosen = new Ritual("Shield");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.36 && rand < 0.4) {
                        if (inHand("Medicine", hand)) {
                            choosen = new Ritual("Medicine");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.4 && rand < 0.7) {
                        if (inHand("Eagle", hand)) {
                            choosen = new Creature("Eagle");
                            cardInHand = true;
                        }
                    } else {
                        if (inHand("Wolf", hand)) {
                            choosen = new Creature("Wolf");
                            cardInHand = true;
                        }
                    }
                }
            }
        }
        else{
            if (cmptHealth < 3){
                while (!cardInHand) {
                    double rand = Math.random();
                    if (rand < 0.15) {
                        if (inHand("Bear", hand)) {
                            choosen = new Creature("Bear");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.15 && rand < 0.3) {
                        if (inHand("Poison", hand)) {
                            choosen = new Ritual("Poison");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.3 && rand < 0.55) {
                        if (inHand("Shield", hand)) {
                            choosen = new Ritual("Shield");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.55 && rand < 0.8) {
                        if (inHand("Medicine", hand)) {
                            choosen = new Ritual("Medicine");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.8 && rand < 0.9) {
                        if (inHand("Eagle", hand)) {
                            choosen = new Creature("Eagle");
                            cardInHand = true;
                        }
                    } else {
                        if (inHand("Wolf", hand)) {
                            choosen = new Creature("Wolf");
                            cardInHand = true;
                        }
                    }
                }
            }
            else if (cmptHealth > 3){
                while (!cardInHand) {
                    double rand = Math.random();
                    if (rand < 0.15) {
                        if (inHand("Bear", hand)) {
                            choosen = new Creature("Bear");
                            cardInHand = true;
                        }
                    } else if (rand >=0.15  && rand < 0.3) {
                        if (inHand("Poison", hand)) {
                            choosen = new Ritual("Poison");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.3 && rand < 0.4) {
                        if (inHand("Shield", hand)) {
                            choosen = new Ritual("Shield");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.4 && rand < 0.5) {
                        if (inHand("Medicine", hand)) {
                            choosen = new Ritual("Medicine");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.5 && rand < 0.75) {
                        if (inHand("Eagle", hand)) {
                            choosen = new Creature("Eagle");
                            cardInHand = true;
                        }
                    } else {
                        if (inHand("Wolf", hand)) {
                            choosen = new Creature("Wolf");
                            cardInHand = true;
                        }
                    }
                }
            }
            else{
                while (!cardInHand) {
                    double rand = Math.random();
                    if (rand < 0.25) {
                        if (inHand("Bear", hand)) {
                            choosen = new Creature("Bear");
                            cardInHand = true;
                        }
                    } else if (rand >=0.25  && rand < 0.5) {
                        if (inHand("Poison", hand)) {
                            choosen = new Ritual("Poison");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.5 && rand < 0.6) {
                        if (inHand("Shield", hand)) {
                            choosen = new Ritual("Shield");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.6 && rand < 0.7) {
                        if (inHand("Medicine", hand)) {
                            choosen = new Ritual("Medicine");
                            cardInHand = true;
                        }
                    } else if (rand >= 0.7 && rand < 0.85) {
                        if (inHand("Eagle", hand)) {
                            choosen = new Creature("Eagle");
                            cardInHand = true;
                        }
                    } else {
                        if (inHand("Wolf", hand)) {
                            choosen = new Creature("Wolf");
                            cardInHand = true;
                        }
                    }
                }
            }
        }
        return choosen;
    }

    public int cardCmpt(Deck d){
        int myCmpt = 0;
        for (int i=0; i<d.size(); i++){
            Card myCard = d.get(i);
            switch (myCard.getName()){
                case "Bear" :
                case "Poison" :
                case "Shield" :
                case "Medicine" :
                    myCmpt++;
                    break;
                case "Eagle" :
                case "Wolf" :
                    myCmpt--;
                    break;
            }
        }
        return myCmpt;
    }

    public double lifeCmpt(ArrayList<Player> p, int posIA){
        double sum = 0;
        for (int i=0; i<p.size(); i++) {
            if (i != posIA) {
                sum += p.get(i).getHealthPoint();
            }
        }
        return p.get(posIA).getHealthPoint() - sum / p.size();
    }

    public boolean inHand(String name, Deck myHand){
        boolean cardInHand = false;
        for (int i=0; i<myHand.size(); i++){
            if (myHand.get(i).getName().equals(name)){
                cardInHand = true;
            }
        }
        return cardInHand;
    }

    public void cardsDistributed(Deck d, int pos) {

    }
*/
}
