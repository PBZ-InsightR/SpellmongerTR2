package edu.insightr.spellmonger;

/**
 * Created by AurÃ©lie on 21/09/2016. Used to define creatures and damages they
 * do
 * Update by Rodolphe on 29/09/2016.
 */
public abstract class Creature extends Card {

    private final int damage;

    //changement par rapport à avant, la classe créature est une classe intermédiaire
    //la créature en question ainsi que les dégats seront définis via l'héritage. 
    Creature(String name, int damage) {
        super(name);
        this.damage = damage;
    }

}
