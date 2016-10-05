package edu.insightr.spellmonger;

/**
 * @author Aurélie
 * Used to have a deck by player
 * Created by Aurélie on 28/09/2016.
 */

class Player {

    private Deck deck;
    private String name;
    private int healthPoint;

    Player(String name, int healthPoint) {
        this.name = name;
        this.healthPoint = healthPoint;
        deck = new Deck();
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getDeckDamages() {
        return deck.getDamages();
    }

    public void setHealthPoint(int delta) {
        healthPoint = getHealthPoint() + delta;
    }

    String getName() {
        return name;
    }

    public boolean addCardToDeck(Card c) {
        return deck.addCard(c);
    }
}