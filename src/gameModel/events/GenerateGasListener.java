/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.events;

import java.util.EventListener;

/**
 *
 * @author trung
 */
public interface GenerateGasListener extends EventListener {

    public void generateGas(GenerateGasEvent event);

}
