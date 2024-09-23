/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.LinkedList;
import java.util.List;
import object.PlateObject;

/**
 *
 * @author ranee
 */
public class removeControl {

    public removeControl() {
    }
   public List<GameObject> removeControlupdate(List list,List control)
   {
        if (list.size() >= 3) {
            PlateObject p1 = (PlateObject) list.get(list.size() - 1);
            PlateObject p2 = (PlateObject) list.get(list.size() - 2);
            PlateObject p3 = (PlateObject) list.get(list.size() - 3);
            if ((p1.getColorCode() == p2.getColorCode()) && (p2.getColorCode() == p3.getColorCode()))
            {for (int i = 0; i < 3; i++) 
                {
                    list.remove(list.size() - 1);
                }

                
                LinkedList<GameObject> newControl = new LinkedList<>();
                newControl.add((GameObject) control.get(0));
                for (int i = 1; i < control.size(); i++) 
                {
                    int curr_id = ((PlateObject) (control.get(i))).getId();
                    if (curr_id != p1.getId() && curr_id != p2.getId() && curr_id != p3.getId()) 
                    {
                        newControl.add((GameObject) control.get(i));
                    }
                }
                control = newControl;
              }
   }
        return control;
}}
