/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.specialization;

/**
 *
 * @author trung
 */
public abstract class SimplePlant extends Specialization {

    public SimplePlant(int weight) {
        super(weight);
        this.Type = "Plant";
        this.Name = "SimplePlant";
    }

    @Override
    public String getType() {
        return this.Type;
    }
}
