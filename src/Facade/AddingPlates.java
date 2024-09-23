
package Facade;

import eg.edu.alexu.csd.oop.game.GameObject;
import factory.Factory;
import java.util.List;
import object.PlateObject;

/**
 *
 * @author ranee
 */
public class AddingPlates {

    public AddingPlates() {
    }
    public List<GameObject> addMoving (List moving,int screenHeight, int width)
    {
          Factory factory = Factory.getInstance();
           for(int i =0; i<100 ;i++)
        {  PlateObject p;
            if((int)(Math.random()*10%7 )== 0)
            { p  =(PlateObject) factory.getShape(-30 * (3 * i), screenHeight - 675,"bomb");
               p.setLeftOrRight(false);
               p.setColorCode(0);
               moving.add(p);}
            else if ((int)(Math.random()*10 % 9 )== 0)
            {p  =(PlateObject) factory.getShape(-30 * (3 * i), screenHeight - 660,"golden plate");
               p.setLeftOrRight(false);
               p.setColorCode(100);
               moving.add(p);
            }
            else if ((int)(Math.random()*100 % 5)==0 || (int)(Math.random()*100 % 2)==0)
           {  p  =(PlateObject) factory.getShape(-30 * (3 * i), screenHeight - 660,"bat");
               p.setLeftOrRight(false);
               moving.add(p);
               //moving.add(factory.getShape(-30 * (3 * i), screenHeight - 675,"bat"));
            }
            else {
               p  =(PlateObject) factory.getShape(-30 * (3 * i), screenHeight - 660,"plate");
               p.setLeftOrRight(false);
               moving.add(p);
                
        }}
        for(int i =0; i<100 ;i++)
        {  PlateObject p1;
            if((int)(Math.random()*10%7 )== 0)
            { p1  =(PlateObject) factory.getShape(width + 70 * i, screenHeight - 635,"bomb");
               p1.setLeftOrRight(true);
               p1.setColorCode(0);
               moving.add(p1);}
            else if ((int)(Math.random()*10 % 9 )== 0)
            {p1  =(PlateObject) factory.getShape(width + 70 * i, screenHeight - 610,"golden plate");
               p1.setLeftOrRight(true);
               p1.setColorCode(100);
               moving.add(p1);
            }
            else if ((int)(Math.random()*100 % 5)==0 || (int)(Math.random()*100 % 2)==0)
           {  p1 =(PlateObject) factory.getShape(width + 70 * i, screenHeight - 610,"bat");
               p1.setLeftOrRight(true);
               moving.add(p1);
               //moving.add(factory.getShape(-30 * (3 * i), screenHeight - 675,"bat"));
            }
            else {
               p1  =(PlateObject) factory.getShape(width + 70 * i, screenHeight - 610,"plate");
               p1.setLeftOrRight(true);
               moving.add(p1);
                
        }}
          return moving;
    }
    
}
