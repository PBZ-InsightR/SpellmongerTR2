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
public class Curse extends Ritual {

    //curse fera 3 points de dégats
    Curse() {
        super("Curse", -3);
    }
    
    //si une nouvelle carte permet de changer la valeur des dégats c'est prévu.
    Curse(int damage) {
        super("Curse", -Math.abs(damage));
    }

}
