package edu.insightr.spellmonger;

/**
 * Created by Aurélie on 21/09/2016.
 * Used to define creatures and damages they do
 */

public class Creature {
    private String name;
    private int damage;

    public Creature(String name) {
        this.name = name;
        switch (name) {
            case "eagle":
                this.damage = 1;
                break;
            case "wolf":
                this.damage = 2;
                break;
            case "bear":
                this.damage = 3;
                break;
            default:
                this.damage = 0;
                break;
        }
    }
}
