package edu.insightr.spellmonger;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Update by Rodolphe on 29/09/2016. 
 * Used to define rituals and what they do
 * le rituel est une classe intermédiare.
 * le type de rituel et ses dégats (ou soins) sont définis via l'héritage.
 */
class Ritual extends Card {

    //servira a dire le différentiel de dégats du rituel (+3 ou -3)
    private final int deltaPoints;

    /**
     * Constructor
     *
     * @param name curse or blessing
     */
    Ritual(String name, int delta) {
        super(name);
        this.deltaPoints = delta;
    }

    public int getDeltaPoints() {
        return deltaPoints;
    }
    
    public boolean isHeal() {
        return (getDeltaPoints() > 0);
    }
    
    public boolean isDamage() {
        return (getDeltaPoints() < 0);
    }
    

}
