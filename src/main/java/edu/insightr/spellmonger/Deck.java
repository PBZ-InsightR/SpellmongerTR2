package edu.insightr.spellmonger;

import java.util.ArrayList;

/** Used to set Deck
 * Created by Rod on 30/09/2016.
 */
class Deck  {
    private ArrayList<Creature> creatures;

    Deck() {
        this.creatures = new ArrayList<>();
    }

    void addCard(Card c) {
        this.creatures.add((Creature) c);
    }

    public void removeCard(Card c) {
        this.creatures.remove(c);
    }

    int getDamages() {
        int total=0;
        for (Creature c : this.creatures) {
            total += c.getDamages();
        }
        return total;
    }

    int getSize(){
        return this.creatures.size();
    }

}
