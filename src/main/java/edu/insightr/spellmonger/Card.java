package edu.insightr.spellmonger;

/**
 * Used to have a Card Deck no matter the card
 * Created by Aurélie on 28/09/2016.
 */
public abstract class Card {

    private String name;
    private int damage;
    private boolean isHeal;
    public Card(String name, int damage, boolean isHeal)
    {

        this.name = name;
        this.damage = damage;
        this.isHeal = isHeal;
    }

    public Card()
    {

    }

    public int getDamage(){
        return this.damage;
    }

    public String getName(){
        return this.name;
    }
    public boolean getIsHeal() {
        return isHeal;
    }
}
