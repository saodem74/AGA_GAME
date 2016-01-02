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
public abstract class Protozoan extends Specialization {

    public Protozoan(int weight) {
        super(weight);
        this.Type = "Animal";
        this.Name = "Protozoan";
    }

    @Override
    public String getType() {
        return this.Type;
    }

}
