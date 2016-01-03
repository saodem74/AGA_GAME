/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.specialization;

import Utils.Constants;

/**
 *
 * @author trung
 */
public class Tiger extends Rapacious {

    public Tiger(int weight) {
        super(weight);
        this.Name = Constants.TIGER;
        this.Type = Constants.TIGER;
    }

    @Override
    public boolean canEat(Specialization other) {
        String type = other.getType();

        return (type.equalsIgnoreCase(Constants.OMNIVOROUS)
                || type.equalsIgnoreCase(Constants.RAPACIOUS)
                || type.equalsIgnoreCase(Constants.PHYTOPHAGOUS))
                && (2 * this.weight > other.getWeight());
    }
}
