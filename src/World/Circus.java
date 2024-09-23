
package World;
import Facade.AddingPlates;
import Facade.LeftIntersection;
import Facade.RightIntersection;
import Facade.SetControlPosition;
import Facade.SetMovement;
import Facade.removeControl;
import Facade.update;
import Strategy.IStrategy;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import factory.Factory;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import object.BarObject;
import object.ClownObject;
import object.PlateObject;
import object.ImageObject;

public class Circus implements World 
{

    private static final int MAX_TIME = 1 * 60 * 1000;	// 1 minute
    private  int score = 0;
    
    private long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    private int HighScore;
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private List<GameObject> control = new LinkedList<GameObject>();
    private final List<GameObject> left = new LinkedList<GameObject>();
    private final List<GameObject> right = new LinkedList<GameObject>();
    //  private boolean x;
    private int indexL = 0;
    private int indexR = 0;
    int j;
    private IStrategy strategy;
    int i =0;
private int  counter =0;
// Facade design pattern
update updateFacade = new update();
removeControl removeFacade = new removeControl();
SetMovement setM = new SetMovement();
SetControlPosition setC = new SetControlPosition();
RightIntersection rIntersect = new RightIntersection();
LeftIntersection lIntersect = new LeftIntersection();
AddingPlates addPlates = new AddingPlates();
   
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

  
    

    public Circus(int screenWidth, int screenHeight,IStrategy strategy) throws FileNotFoundException 
    {   this.strategy = strategy;
        width = screenWidth;
        height = screenHeight;
        Factory factory = Factory.getInstance();
        
        // set background picture
    
        ImageObject background = new ImageObject(0,0, "/circus.png");
        constant.add(background); 
        
        // Add player --> clown
        control.add(factory.getShape(330, 433, "clown"));
         
        // Add stable objects (bars)
        constant.add(new BarObject(screenWidth / 2 - 450, screenHeight / 2 - 300, 250, true, Color.BLACK));
        constant.add(new BarObject(screenWidth / 2 + 200, screenHeight / 2 - 250, 250, true, Color.BLACK));
 addPlates.addMoving(moving, height, width);
       
try {
            File highScoreFile = new File("HighScore.txt");
            if (highScoreFile.createNewFile()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(highScoreFile));
                writer.write("0");
                writer.close();
                this.HighScore = 0;
            } else {
                FileReader fread = new FileReader(highScoreFile);
                BufferedReader reader = new BufferedReader(fread);
                setHighScore(fread.read());
                reader.close();
                fread.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }}
        
        
        
        
   
    public int getHighScore() 
    {
        return HighScore;
    }

    public void setHighScore(int HighScore) throws IOException 
    {
        // Check if incoming score is bigger than set HighScore
        if (HighScore > this.HighScore)
        {
            this.HighScore = HighScore;
            BufferedWriter writer = new BufferedWriter(new FileWriter("HighScore.txt"));
            writer.write(HighScore);
            writer.close();
        }
    }
    


    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
   
    private void updateLeft() 
      { if(updateFacade.updateList(left)==true)
      {control =  removeFacade.removeControlupdate(left, control);
                score++;}
    }
      private void updateRight() 
      { if(updateFacade.updateList(right)==true)
      {control =  removeFacade.removeControlupdate(right, control);
                score++;}
    }

    @Override
    public boolean refresh() 
    {

        boolean timeout = System.currentTimeMillis() - startTime > strategy.getTimeout()*1000*60; // time end and game over
        GameObject clown = control.get(0);
 Iterator<GameObject> iterator = moving.iterator();
 while(iterator.hasNext())
        { 
            PlateObject plate = (PlateObject) iterator.next();
            setM.setMotion(plate, constant);
 setC.Setposition(right, left, (ClownObject) clown);
  lIntersect.LeftIntersect((ClownObject) clown, left, iterator, control, plate,this);
                updateLeft();
            rIntersect.RightIntersect((ClownObject) clown, right, iterator, control, plate,this);
                    updateRight();
            if (left.size()==strategy.getPlates())
                return false;
            else if(right.size()==strategy.getPlates())
                return false;            
        }

        
        try {
            setHighScore(score);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Circus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
       
        return !timeout;
    }

    @Override
    public String getStatus() 
    {
        return "Please Use Arrows To Move   |   HighScore = " + HighScore 
                + "   |   Score=" + score + "   |   Time="
                + Math.max(0, (strategy.getTimeout()*60*1000 - (System.currentTimeMillis() - startTime)) / 1000);
    }

    @Override
    public int getSpeed() {
            return 10;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }

   
}
