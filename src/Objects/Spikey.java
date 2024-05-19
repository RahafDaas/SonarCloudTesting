package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class Spikey extends AnimatedSprite implements BasicEnemy {

    boolean PositiveX = true;
    Mario game;
    public int Gravity = 5;

    public Spikey(int x, int y, BufferedImage[] Enemy_Image, Mario g) {
        setLocation(x, y);
        setImages(Enemy_Image);
        setAnimationTimer(new Timer(160));
        setAnimate(true);
        setLoopAnim(true);

        game = g;

        this.setID(117);

        if (this.MariotoRight()) {
            PositiveX = false;
            this.setAnimationFrame(2, 3);
        } else {
            PositiveX = true;
            this.setAnimationFrame(0, 1);
        }
    }

    public void update(long l) {
        moveY(Gravity);
        if (PositiveX) {
            moveX(-1);
        } else {
            moveX(1);
        }
        super.update(l);
    }

    public void CollidedWithBrick_GoToLeft() {
        PositiveX = true;
        this.setAnimationFrame(0, 1);
    }

    public void CollidedWithBrick_GoToRight() {
        PositiveX = false;
        this.setAnimationFrame(2, 3);

    }

    public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
        if (game.player.HasStar()) {
            KilledByFireBall();
        } else {
            game.player.Decerease();
        }
    }

    public void KilledByFireBall() {
        game.playSound("music/smb_kick.wav");
        game.AnimationGroup.add(new FallingDeadSprites(this.getX(), this.getY(), this.getImage(), MariotoRight()));
        this.setActive(false);

    }

    public void bounce() {
        Gravity = 6;
    }

    public void setYloc(double d) {
        this.setY(d);
    }

    public void CollidedWithShell() {
    }

    public void CollidedWithMovingShell() {
        KilledByFireBall();
    }

    public void OtherEnemyTouchedFromRight() {
        PositiveX = true;
        this.setAnimationFrame(0, 1);
    }

    public void OtherEnemyTouchedFromLeft() {
        PositiveX = false;
        this.setAnimationFrame(2, 3);
    }

    public void CollidedWithMarioFromTOLeft() {
        if (game.player.HasStar()) {
            KilledByFireBall();
        } else {
            game.player.Decerease();
        }
    }

    public void CollidedWithMarioTORight() {
        if (game.player.HasStar()) {
            KilledByFireBall();
        } else {
            game.player.Decerease();
        }
    }

    public void EnemyJumperOnMario() {
        if (game.player.HasStar()) {
            KilledByFireBall();
        } else {
            game.player.Decerease();
        }
    }

    public int Life() {
        return 0;
    }

    public void CollidedWithJumping_Brick() {
        if (PositiveX) {     // invert direction
            PositiveX = false;
            this.setAnimationFrame(2, 3);
        } else {
            PositiveX = true;
            this.setAnimationFrame(0, 1);
        }

        bounce();
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
