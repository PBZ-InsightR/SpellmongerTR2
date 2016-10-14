package edu.insightr.spellmonger;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.HashMap;
import java.util.Map;

/**
 * Update by Rodolphe on 29/09/2016.
 * Used to define rituals and what they do
 * le rituel est une classe intermediare.
 */
public class Ritual extends Card {

    public static final String RITUAL_POISON = "Poison";
    public static final String RITUAL_SHIELD = "Shield";
    public static final String RITUAL_MEDICINE = "Medicine";

    //servira a dire le differentiel de degats du rituel (+3 ou -3)
    private final int deltaPoints;

    /**
     * Constructor
     *
     * @param name Poison, shield, medicine
     */
    Ritual(String name) {
        super(name);
        //on n'accepte que les rituels que l'on connait
        switch (name) {
            case RITUAL_POISON:
                deltaPoints = -3;
                break;
            case RITUAL_SHIELD:
                deltaPoints = 0;
                break;
            case RITUAL_MEDICINE:
                deltaPoints = 3;
                break;
            default:
                throw new IllegalArgumentException("incorrect value");
        }
    }

    protected int getDeltaPoints() {
        return deltaPoints;
    }

    private boolean isHeal() {
        return (getDeltaPoints() > 0);
    }

    public boolean isShield() {
        return getDeltaPoints() == 0;
    }

    public int getDamages() {
        return (isHeal() ? 0 : -(getDeltaPoints()));
    }

    public int getHeal() {
        return (isHeal() ? getDeltaPoints() : 0);
    }

}
