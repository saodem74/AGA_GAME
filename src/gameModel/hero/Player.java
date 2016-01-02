/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameModel.hero;

/**
 *
 * @author trung
 */
public class Player extends Bacterium{
    private static String name = "Play";
    private int score;
    private static Player _instance;
    
    Player(){
        score = 0;
    }
    
    public static Player _instance(){
        if (_instance == null){
            _instance = new Player();
        }
        return _instance;
    }
    
}
