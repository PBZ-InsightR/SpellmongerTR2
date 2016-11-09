package edu.insightr.spellmonger;

import java.util.*;


/**
 * Used to define intelligent IA (using a strategy)
 * Created by Rod on 08/10/2016.
 * updated by thomas on 21/10/2016 (first part of algorithme)
 * updated by paul on 04/11/2016 (first realisation of the algorithme)
 */

class IA{
    //les attributs
    private double compteur=0;

    //les propriétées
    public double getCompteur(){return compteur;}
    private void setCompteur(double newCompteur){this.compteur=newCompteur;}

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
        this.setCompteur(this.getCompteur() + this.cardCompt(d));
    }

    public Card askForCard(ArrayList<Player> players, int currentPlayerPos) {
        Player p = players.get(currentPlayerPos);
        Deck hand = p.getHand();

        double decisionCoefficient = this.compteur/(2*hand.size());//   compteur/nbCarteRestante
        double cmptHealth = lifeCmpt(players, currentPlayerPos);
        if(cmptHealth<-2){//   si on amoins de poins que nos adversaires
            decisionCoefficient+=0.25;
        }
        if(cmptHealth>2){
            decisionCoefficient-=0.25;
        }
        String cardProprity[]=new String[6];
        if(decisionCoefficient<=-0.25){
            cardProprity[0] = "Medicine";
            cardProprity[1] = "Wolf";
            cardProprity[2] = "Eagle";
            cardProprity[3] = "Poison";
            cardProprity[4] = "Bear";
            cardProprity[5] = "Shield";
        }
        else if(decisionCoefficient>-0.25 && decisionCoefficient<=0.25){
            cardProprity[0] = "Wolf";
            cardProprity[1] = "Bear";
            cardProprity[2] = "Eagle";
            cardProprity[3] = "Poison";
            cardProprity[4] = "Shield";
            cardProprity[5] = "Medicine";
        }
        else{//if(decisionCoef>0.25)
            cardProprity[0] = "Shield";
            cardProprity[1] = "Bear";
            cardProprity[2] = "Poison";
            cardProprity[3] = "Medicine";
            cardProprity[4] = "Wolf";
            cardProprity[5] = "Eagle";
        }

        Card playedCard;
        for(int i=0; i<cardProprity.length; i++){//on parcourt tout le tableau de prioritées
            playedCard=FindCard(cardProprity[i],hand);
            if(playedCard!=null){
                return playedCard;
            }
        }
        return null;
    }

    private Card FindCard(String name, Deck myHand){
        for (int i=0; i<myHand.size(); i++){
            if (myHand.get(i).getName().equals(name)){
                return myHand.get(i);
            }
        }
        return null;
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

    public void cardsDistributed(Deck d, int pos) {}
}