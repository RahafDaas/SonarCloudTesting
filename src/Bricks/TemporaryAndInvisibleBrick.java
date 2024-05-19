package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

public class TemporaryAndInvisibleBrick extends Sprite implements BasicBrick {

    int Gravity = -5;
    boolean Jump = true;
    Mario game;
    int delay = 10;

    TemporaryAndInvisibleBrick(int x, int y, BufferedImage storedImage, Mario g) {

        this.setLocation(x, y);
        this.setImage(storedImage);
        game = g;

        this.setID(2);

    }

    public void update(long l) {
        delay--;
        if (delay < 0) {
            this.setActive(false);
        }
        if (Gravity >= 4) {
            Jump = false;
        } else {
            Gravity = Gravity + 1;
            this.moveY(Gravity);
        }

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
        return Jump;
    }
}
