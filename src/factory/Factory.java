package factory;


import eg.edu.alexu.csd.oop.game.GameObject;
import object.ClownObject;
import object.PlateObject;

public class Factory {
 private static Factory fac;
    private Factory() {
    }
    public static Factory getInstance ()
    {  if(fac == null)
        return new Factory();
    return fac;
    }

    public GameObject getShape( int x, int y,String shape) {
        int ColorCode;
        if (shape == null) {
            return null;
        }
        
            else if (shape.equals("clown")) {
                
            return new ClownObject(x, y, "/clown6.png");
        }
                 else if(shape.equals("plate")) {
                    ColorCode = (int) (Math.random()*10 - 3);
                    if(ColorCode<=0)
                        ColorCode = 1;
                        System.out.println(ColorCode);
                    PlateObject p= new PlateObject(x,y, "/Plate" + ColorCode + ".png");
                    p.setColorCode(ColorCode);
            return p;
        }
                    
              else if(shape.equals("golden plate")) {
                     
                    PlateObject p= new PlateObject(x,y,"/Plate" + 7 + ".png");
                    p.setColorCode(100);
            return p;
        }
      
         else if(shape.equals("bomb")) {
                    PlateObject p= new PlateObject(x,y,"/bomb2.png");
                    p.setColorCode(0);
            return p;}
         
  
          else if(shape.equals("bat")) {
                     ColorCode = (int) (Math.random()*10 - 3);
                      if(ColorCode<=0)
                        ColorCode = 1;
                    PlateObject p= new PlateObject(x,y,"/Batman" + ColorCode  + ".png");
                    p.setColorCode(ColorCode);
            return p;}
        
        return null;
       
    }
}
