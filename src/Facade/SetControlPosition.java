/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;
import object.ClownObject;

/**
 *
 * @author ranee
 */
public class SetControlPosition {

    public SetControlPosition() {
    }
    public void Setposition (List<GameObject>  right, List<GameObject> left,ClownObject clown)
    {
         for (int k = 0; k < left.size(); k++) 
            {
                left.get(k).setX(clown.getX() + 17);
            }
            for (int k = 0; k < right.size(); k++) 
            {
                right.get(k).setX(clown.getX() + 175);
            } 
    }
}
