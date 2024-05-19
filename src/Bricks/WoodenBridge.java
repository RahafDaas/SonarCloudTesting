package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;

public class WoodenBridge extends Sprite implements BasicBrick {

    Mario game;

    public WoodenBridge(int x, int y, Mario g) {

        this.setLocation(x, y);
        game = g;
        this.setImage(game.bsLoader.getStoredImage("WoodenBridge"));
        this.setID(2);



    }

    public void HitFromDown() {
        // nothing will happen
    }

    public void RemoveIt() {
    }

    public String getInsideItem() {
        // its always empty
        return "empty";
    }

    public boolean isJump() {
        return false;
    }
}
