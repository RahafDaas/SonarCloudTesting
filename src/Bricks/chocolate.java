package Bricks;


import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;


public class chocolate extends Sprite implements BasicBrick{


    public chocolate(int x, int y, BufferedImage storedImage) {
        
        this.setLocation(x, y);
        this.setImage(storedImage);
        
        this.setID(2);
        
        
    }

    public void HitFromDown() {
    }

    public void RemoveIt() {
    }

    public String getInsideItem() {
         return "empty" ;
    }

    public boolean isJump() {
        return false ;
    }

 
    
}
