/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.insightr.spellmonger;

/**
 *
 * Created by Rodolphe on 29/09/2016
 * 
 */
public class Blessing extends Ritual {
    
    //Blessing soigne de 3 points
    Blessing() {
        super("Blessing", 3);
    }
    
    //si une nouvelle carte permet de changer la valeur des soins c'est prévue.
    Blessing(int heal) {
        super("Blessing", Math.abs(heal));
    }
    
    
}
