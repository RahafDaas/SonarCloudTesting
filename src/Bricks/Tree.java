
package Bricks;

import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;


public class Tree  extends Sprite implements BasicBrick{

    public Tree(int x, int y, BufferedImage Stone_Image) {
        this.setLocation(x, y);
        this.setImage(Stone_Image);
        // will not bounce when hit from down
        this.setID(22);
    }

    public Tree(BufferedImage bufferedImage, int x, int y) {
        this(x , y , bufferedImage );
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
