package edu.insightr.spellmonger;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by Aurélie on 21/09/2016.
 * Used to define rituals and what they do
 */
public class Ritual {
    private String name;
    private int damage;
    private boolean isHeal;

    public Ritual(String name){
        this.name = name;
        this.damage = 3;
        isHeal = (name.equals("blessing")) ? true : false;
    }
}
