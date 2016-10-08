package edu.insightr.spellmonger;

/**
 * @author Aurélie
 * Used to have a deck by player
 * Created by Aurélie on 28/09/2016.
 */

class Player {

    private String name;
    private Deck hand = new Deck();
    private int healthPoint = 0;
    private boolean human;

    public Player(String playerName, boolean isHuman) {
        name = playerName;
        human = isHuman;
    }

    public Player(String name) {
        this(name, true);
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public Deck getHand() {
        return hand;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public boolean isHuman() {
        return human;
    }

    public boolean isIA() {
        return !isHuman();
    }

    public void changeHealthPoints(int delta) {
        healthPoint = getHealthPoint() + delta;
    }

    String getName() {
        return name;
    }

    public boolean addCardToDeck(Card c) {
        return hand.add(c);
    }

}
