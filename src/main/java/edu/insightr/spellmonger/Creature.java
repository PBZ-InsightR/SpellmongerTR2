package edu.insightr.spellmonger;


/**
 * @author Aurélie
 * Created by Aur?lie on 21/09/2016. Used to define creatures and damages they
 * do
 * Update by Rodolphe on 29/09/2016.
 */
public class Creature extends Card {

    public static final String CREA_EAGLE = "Eagle";
    public static final String CREA_WOLF = "Wolf";
    public static final String CREA_BEAR = "Bear";

    private final int damage;

    Creature(String name) {
        super(name);
        //on n'accepte que les creatures que l'on connait
        switch (name) {
            case CREA_EAGLE:
                damage = 1;
                break;
            case CREA_WOLF:
                damage = 2;
                break;
            case CREA_BEAR:
                damage = 3;
                break;
            default:
                throw new IllegalArgumentException("incorrect value");
        }
    }

    public boolean isShield() {
        return false;
    }

    public int getDamages() {
        return damage;
    }

    public int getHeal() {
        return 0;
    }

}
