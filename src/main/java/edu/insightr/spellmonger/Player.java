package edu.insightr.spellmonger;

/**
 * @author Aurélie
 * Used to have a deck by player
 * Created by Aurélie on 28/09/2016.
 */

class Player {

    private String name;
    private Deck deck = new Deck(); // complete deck
    private Deck playHand = new Deck(); // 3 cards in play
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

    public Deck getPlayHand() {
        return playHand;
    }

    public Deck getDeck() { return deck; }

    public boolean noMoreCard() { return (getPlayHand().size() + getDeck().size()) == 0; }

    public void setHealthPoint(int hp) {
        healthPoint = hp;
    }

    public boolean isHuman() {
        return human;
    }

    public boolean isIA() {
        return !isHuman();
    }

    public void changeHealthPoints(int delta) {
        healthPoint += delta;
    }

    public String getName() {
        return name;
    }

    public boolean addCardToDeck(Card c) {
        return getDeck().add(c);
    }

    public void giveHand() {
        for (int i=0; i<3; i++) {
            if (getDeck().size()>0) getPlayHand().add(getDeck().draw());
        }
    }
}
