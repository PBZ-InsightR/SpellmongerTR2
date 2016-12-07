package edu.insightr.spellmonger;

import java.util.*;


/**
 * Used to define intelligent IA (using a strategy)
 * Created by Rod on 08/10/2016.
 * updated by thomas on 21/10/2016 (first part of algorithme)
 * updated by paul on 04/11/2016 (first realisation of the algorithme)
 * updated by thomas on 21/10/2016 (first part of algorithme)
 * Updated by Rod on 17/10/2016
 * Updated by Thomas on 24/10/2016
 */

public class IA_v1 extends IA {
    //les attributs
    private int compteur;

    //les propriétées
    private int getCompteur(){return compteur;}
    private void setCompteur(int newCompteur){this.compteur=newCompteur;}

    //les methodes
    private int cardCompt(Deck d){
        int myCmpt = 0;
        for (int i=0; i<d.size(); i++){
            Card myCard = d.get(i);
            switch (myCard.getName()){
                case "Bear" :
                case "Poison" :
                    myCmpt-=2;
                    break;
                case "Wolf" :
                    myCmpt--;
                    break;
                case "Eagle" :
                case "Shield" :
                case "Medicine" :
                    myCmpt+=2;
                    break;

            }
        }
        return myCmpt;
    }

    public void memorizeCard(Deck d){
        this.setCompteur(this.getCompteur()+this.cardCompt(d));
    }

    public Card askForCard(ArrayList<Player> players, int currentPlayerPos) {
        Player p = players.get(currentPlayerPos);
        Deck hand = p.getPlayHand();

        double decisionCoefficient = this.compteur/(2*hand.size());//   compteur/nbCarteRestante
        double cmptHealth = lifeCmpt(players, currentPlayerPos);
        if(cmptHealth<-2){//   si on amoins de poins que nos adversaires
            decisionCoefficient+=0.25;
        }
        if(cmptHealth>2){
            decisionCoefficient-=0.25;
        }

        Card playedCard = null;
        if(decisionCoefficient<-0.25){
            playedCard = getCard(hand, new String[]{"Medicine", "Wolf", "Eagle" , "Poison","Bear","Shield"});
        }
        else if(decisionCoefficient>-0.25&&decisionCoefficient<0.25){
            playedCard = getCard(hand, new String[]{"Wolf", "Eagle" , "Bear","Poison","Shield","Medicine"});
        }
        else{//if(decisionCoef>0.25)
            playedCard = getCard(hand, new String[]{"Shield", "Bear", "Poison" , "Medicine","Wolf","Eagle"});
        }
        return playedCard;
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

    private double lifeCmpt(ArrayList<Player> p, int posIA){
        double sum = 0;
        for (int i=0; i<p.size(); i++) {
            if (i != posIA) {
                sum += p.get(i).getHealthPoint();
            }
        }
        return p.get(posIA).getHealthPoint() - sum / (p.size()-1);
    }

    public void boardPlayed(Deck board){};
    public void cardsDistributed() {
        compteur = 0;
    }
}