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
public class Buffalo extends Phytophagous {

    public Buffalo(int weight) {
        super(weight);
        this.Name = Constants.BUFFALO;
        this.Type = Constants.BUFFALO;
    }

    @Override
    public boolean canEat(Specialization other) {
        return super.canEat(other)
                || other.getName().equalsIgnoreCase(Constants.MOSS)
                && 1.5 * this.weight > other.getWeight();
    }

}
