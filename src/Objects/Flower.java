/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class Flower extends AnimatedSprite implements BasicEnemy {

    Mario game;

    public Flower(int x, int y, BufferedImage[] storedImages, Mario M) {
        setLocation(x, y);
        setImages(storedImages);

        this.setAnimate(true);
        this.setLoopAnim(true);
        this.setAnimationTimer(new Timer(100));

        game = M;

        this.setID(4);

    }

    public void CollidedWithBrick_GoToLeft() {
    }

    public void CollidedWithBrick_GoToRight() {
    }

    public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
    }

    public void KilledByFireBall() {
    }

    public void bounce() {
    }

    public void setYloc(double d) {
    }

    public void CollidedWithShell() {
    }

    public void CollidedWithMovingShell() {
    }

    public void OtherEnemyTouchedFromRight() {
    }

    public void OtherEnemyTouchedFromLeft() {
    }

    public void CollidedWithMarioFromTOLeft() {
    }

    public void CollidedWithMarioTORight() {
    }

    public void EnemyJumperOnMario() {
    }

    public int Life() {
        return 0;
    }

    public void CollidedWithJumping_Brick() {
    }

    public boolean MariotoRight() {
        boolean positive;
        if (game.player.getX() < this.getX()) {
            positive = false;
        } else {
            positive = true;
        }

        return positive;
    }
}