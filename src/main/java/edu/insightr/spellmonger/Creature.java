package edu.insightr.spellmonger;

/**
 * Created by Aur?lie on 21/09/2016. Used to define creatures and damages they
 * do
 * Update by Rodolphe on 29/09/2016.
 */
abstract class Creature extends Card {

    private final int damage;

    //changement par rapport ? avant, la classe cr?ature est une classe interm?diaire
    //la cr?ature en question ainsi que les d?gats seront d?finis via l'h?ritage. 
    Creature(String name, int damage) {
        super(name);
        this.damage = damage;
    }

}
