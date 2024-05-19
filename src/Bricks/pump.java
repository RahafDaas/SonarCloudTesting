
package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;


public class pump extends Sprite implements BasicBrick{

    public pump(BufferedImage storedImage, int x, int y, Mario g) {
        super(storedImage , x , y );
    }

    public void HitFromDown() {
    }

    public void RemoveIt() {
    }

    public String getInsideItem() {
        return null ;
    }

    public boolean isJump() {
        return false ;
    }
    
}
