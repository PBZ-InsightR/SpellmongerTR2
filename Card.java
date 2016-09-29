package edu.insightr.spellmonger;

/**
 * Used to have a Card Deck no matter the card
 * Created by AurÃ©lie on 28/09/2016.
 * update by Rodolphe on 29/09/2016.
 */
public abstract class Card {
    //la class Card sera la classe référence, comme on la dérive en blessing ou creature, les damages se feront via l'héritage
    private final String name;

    public Card(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }
    
}
