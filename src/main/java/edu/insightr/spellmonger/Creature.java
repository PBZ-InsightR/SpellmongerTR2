package edu.insightr.spellmonger;

/**
 * Created by Aurélie on 21/09/2016.
 * Used to define creatures and damages they do
 */

public class Creature extends Card{


    /**
     * Constructor
     * @param name eagle, wolf or bear
     */
    public Creature(String name, int damage, boolean isHeal) {
        super(name,damage,isHeal);
        //this.getName() = name;
        switch (name) {
            case "eagle":
                damage = 1;
                break;
            case "wolf":
                damage = 2;
                break;
            case "bear":
                damage = 3;
                break;
            default:
                damage = 0;
                break;
        }
    }


}
