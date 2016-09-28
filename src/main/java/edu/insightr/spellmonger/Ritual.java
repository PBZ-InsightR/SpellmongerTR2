package edu.insightr.spellmonger;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by Aurélie on 21/09/2016.
 * Used to define rituals and what they do
 */
class Ritual extends Card {
    private boolean isHeal;

    /**
     * Constructor
     * @param name curse or blessing
     */
    Ritual(String name){
        super(name);
        this.damage = 3;
        this.isHeal = (name.equals("blessing"));
    }

    public boolean IsHeal() {
        return this.isHeal;
    }

}
