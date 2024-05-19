package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class Star extends AnimatedSprite implements BasicEnemy {

    boolean PositiveX = true;
    Mario game;
    public double Gravity = -5;
    private double XSpeed;

    // its overlaping the ron and has to cum up slowly
    public Star(int x, int y, BufferedImage[] storedImage, Mario g) {
        super(storedImage, x, y);
        game = g;
        this.setAnimate(true);
        this.setLoopAnim(true);

        this.setAnimationTimer(new Timer(100));


        this.setID(20);

        PositiveX = false;
        XSpeed = 2;

    }

    public void update(long l) {
        if (Gravity < 5) {
            Gravity = Gravity + 0.25;
        }
        moveY(Gravity);

        if (PositiveX) {
            moveX(-1.5);
        } else {
            moveX(1.5);
        }

        if (getY() > 700D) {
            setActive(false);
        }
        super.update(l);
    }

    public void bounce() {
        Gravity = -6;
    }

    public void CollidedWithBrick_GoToLeft() {
        PositiveX = true;
    }

    public void CollidedWithBrick_GoToRight() {
        PositiveX = false;
    }

    public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
        game.player.STAR();
        super.setActive(false);

    }

    public void KilledByFireBall() {
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
        game.player.STAR();
        super.setActive(false);

    }

    public void CollidedWithMarioTORight() {
        game.player.STAR();
        super.setActive(false);

    }

    public void EnemyJumperOnMario() {
        game.player.STAR();
        super.setActive(false);

    }

    public int Life() {
        return 0;
    }

    public void setYloc(double d) {
        bounce();
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
