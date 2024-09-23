/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import World.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Iterator;
import java.util.List;
import object.ClownObject;
import object.PlateObject;

/**
 *
 * @author ranee
 */
public class LeftIntersection {

    public LeftIntersection() {
    }
     private boolean intersectLeft(GameObject o,ClownObject clown) {
       // ClownObject clown = (ClownObject) control.get(0);

        return (Math.abs(clown.getX() - o.getX()) <= o.getWidth() - 5
                && o.getY() == clown.getY() - 2);
    }

    private boolean intersect(GameObject o1, GameObject o2) {
        boolean cond1 = (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth());
        boolean cond2 = (Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight());
        return cond1 && cond2;}
        public void LeftIntersect (ClownObject clown, List <GameObject> left,Iterator iterator,List <GameObject> control,PlateObject plate,Circus c)
        {
                if (left.isEmpty() == true) 
            {
                if (intersectLeft(plate,clown) == true) 
                {

                    if (plate.getColorCode() > 0 && plate.getColorCode() < 100) 
                    {
                        PlateObject p = plate;
                        control.add(plate);
                        iterator.remove();
                        plate.setIsHorizontalOnly(true);
                        plate.setX(clown.getX() + 25);
                        plate.setY(clown.getY());
                        plate.setType(1);
                        left.add(plate);
                     
                    }
                }
            } 
            
            else if (intersect(left.get(left.size() - 1), plate) == true)
            {
                if (plate.getColorCode() == 0) 
                {
                    for (int k = 0; k < left.size(); k++) 
                    {
                        control.remove(left.get(k));
                    }
                    left.clear();
                 
                } 
                else if (plate.getColorCode() == 100) 
                {
                  c.setScore(c.getScore()+2);
//                    moving.remove(i);
                   iterator.remove();
                } 
                else 
                {
//                    moving.remove(i);
                     iterator.remove();
//                    PlateObject p = (PlateObject) m;
                    plate.setX(clown.getX());
                    plate.setIsHorizontalOnly(true);
                    plate.setY(left.get(left.size() - 1).getY() - plate.getWidth());
                    plate.setType(1);
                    control.add(plate);
                    left.add(plate);
                    
                }
        }

}}
    
