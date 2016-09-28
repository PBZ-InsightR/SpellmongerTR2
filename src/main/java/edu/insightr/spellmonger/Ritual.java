package edu.insightr.spellmonger;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by Aurélie on 21/09/2016.
 * Used to define rituals and what they do
 */
public class Ritual extends Card {

    /**
     * Constructor
     * @param name curse or blessing
     */
    public Ritual(String name, int damage, boolean isHeal){
        name = name;
        damage = 3;
        isHeal = (name.equals("blessing"));
    }


}
