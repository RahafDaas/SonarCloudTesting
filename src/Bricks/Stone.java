
package Bricks;

import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;


public class Stone extends Sprite implements BasicBrick{

    public Stone(int x, int y, BufferedImage Stone_Image) {
        this.setLocation(x, y);
        this.setImage(Stone_Image);
        // will not bounce when hit from down
        this.setID(4);
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
