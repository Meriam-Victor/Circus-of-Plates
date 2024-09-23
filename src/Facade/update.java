/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import World.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.LinkedList;
import java.util.List;
import object.PlateObject;

/**
 *
 * @author ranee
 */
public class update {

    public update() {
       
            
    }
    public boolean updateList(List list) 
    {
        if (list.size() >= 3) {
            PlateObject p1 = (PlateObject) list.get(list.size() - 1);
            PlateObject p2 = (PlateObject) list.get(list.size() - 2);
            PlateObject p3 = (PlateObject) list.get(list.size() - 3);
            return ((p1.getColorCode() == p2.getColorCode()) && (p2.getColorCode() == p3.getColorCode())) ;
              }
        return false;
    }

}
