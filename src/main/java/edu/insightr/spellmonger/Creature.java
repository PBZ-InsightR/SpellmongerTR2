package edu.insightr.spellmonger;

/**
 * Created by Aur?lie on 21/09/2016. Used to define creatures and damages they
 * do
 * Update by Rodolphe on 29/09/2016.
 */
public class Creature extends Card {

    private final int damage;

    Creature(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getDamages() {
        return damage;
    }
    public int getHeal() { return 0; }

}
