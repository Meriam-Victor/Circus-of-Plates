/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;
import object.PlateObject;

/**
 *
 * @author ranee
 */
public class SetMovement {

    public SetMovement() {
    }
    public void setMotion (PlateObject plate,List <GameObject> constant)
    { if (plate.isIsHorizontalOnly() == false) 
            {
                // move objects in horizontal motion on bars

                if ((plate.getX() < 250) && (plate.getY() < constant.get(1).getY())) 
                {
                    plate.setX(plate.getX() + 1 );
                    plate.setY(plate.getY());

                }
                else if ((plate.getX() >= 580) && (plate.getY() < constant.get(2).getY()))
                {
                    plate.setX(plate.getX()-1 );
                    plate.setY(plate.getY());
                }
                
                // When plate falls from bar
                if ((plate.getX() >= 250) && (plate.isLeftOrRight() == false))
                {
                    plate.setX(plate.getX() +1);
                    plate.setY(plate.getY() +1);
                }
                else if ((plate.getX() < 580) && (plate.isLeftOrRight() == true)) 
                {
                    plate.setX(plate.getX()-1);
                    plate.setY(plate.getY()+1);
                }
            }
}}
