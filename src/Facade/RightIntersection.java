/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import World.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.Iterator;
import java.util.List;
import object.ClownObject;
import object.PlateObject;

/**
 *
 * @author ranee
 */
public class RightIntersection {

    public RightIntersection() {
    }
    private boolean intersect(GameObject o1, GameObject o2) {
        boolean cond1 = (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth());
        boolean cond2 = (Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight());
        return cond1 && cond2;}
    private boolean intersectRight(GameObject o,ClownObject clown) 
    {
      // ClownObject clown = (ClownObject) control.get(0);
        return (Math.abs(o.getX() - (clown.getX() + 200)) <= o.getWidth() - 5
                && o.getY() == clown.getY() - 2);

    }
    public void RightIntersect (ClownObject clown, List <GameObject> right,Iterator iterator,List <GameObject> control,PlateObject plate,Circus c)
    {
         if (right.isEmpty() == true) 
            {
                if (intersectRight(plate,clown) == true) 
                {
                    // if it is a normal plate i.e: not golden or bomb
                    if (plate.getColorCode() > 0 && plate.getColorCode() < 100) 
                    {
                        plate.setIsHorizontalOnly(true);
                        plate.setX(clown.getX() + 175);
                        plate.setY(clown.getY());
                        plate.setType(1);
                        right.add(plate);
                        control.add(plate);
//                        moving.remove(i);
                     iterator.remove();
                    }

                }
            } 
            else 
            {
                if (intersect(right.get(right.size() - 1), plate) == true) {
                    if (plate.getColorCode() == 0) 
                    {
                        for (int k = 0; k < right.size(); k++) 
                        {
                            control.remove(right.get(k));
                        }
                        right.clear();
                       
                        // indexL=0;
                    } 
                    else if (plate.getColorCode() == 100)
                    {
                       c.setScore(c.getScore()+2);
                        iterator.remove();
                    } 
                    else 
                    {
                        plate.setIsHorizontalOnly(true);
                        plate.setX(clown.getX() + 175);
                        plate.setY(468 + right.size() * 11);
                        plate.setType(1);
                        right.add(plate);
                        
                        control.add(plate);
//                        moving.remove(i);
 iterator.remove();
    }}}}}

