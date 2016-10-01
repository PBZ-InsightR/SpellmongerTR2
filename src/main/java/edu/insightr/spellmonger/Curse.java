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
class Curse extends Ritual {

    //curse fera 3 points de d?gats
    Curse() {
        super("Curse", -3);
    }
    
    //si une nouvelle carte permet de changer la valeur des d?gats c'est pr?vu.
    Curse(int damage) {
        super("Curse", -Math.abs(damage));
    }

}
