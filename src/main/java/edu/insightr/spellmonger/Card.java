package edu.insightr.spellmonger;

/**
 * @author Aurélie
 * Used to have a Card Deck no matter the card
 * Created by Aur?lie on 28/09/2016.
 * update by Rodolphe on 29/09/2016.
 */
public abstract class Card {
    //la class Card sera la classe reference, comme on la derive en creature ou ritual, les damages se feront via l'heritage
    private final String name;

    public Card(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    public abstract int getDamages();
    public abstract int getHeal();
    public abstract boolean isShield();

}
