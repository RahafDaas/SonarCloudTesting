package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class plant extends AnimatedSprite implements BasicEnemy {

    Mario game;
    int Upheight = 48;
    int DownHeight = 48;
    boolean MoveUp = true;
    boolean MarioIsNear = false;
    boolean CanStopMovingUp = false;

    public plant(BufferedImage storedImage[], int x, int y, Mario g) {
        this.setLocation(x, y);
        this.setID(110);

        game = g;

        this.setImages(storedImage);

        Upheight = y - 96;
        DownHeight = y;

        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
    }

    public void update(long l) {

        if (this.getY() < Upheight) {
            MoveUp = false;
        }
        if (this.getY() > DownHeight) {

            MoveUp = true;

        }

        if (MoveUp) {

            if (game.player.getX() > this.getX() - 100 & game.player.getX() < this.getX() + 100) {
                MarioIsNear = true;
            } else {
                MarioIsNear = false;
            }

            if (this.getY() > DownHeight - 32) { // is down
                CanStopMovingUp = true;
            } else {
                CanStopMovingUp = false;
            }

            if (MarioIsNear && CanStopMovingUp) {
            } else {
                this.moveY(-0.5); // moving  up
            }
//            }
        } else {
            this.moveY(0.5);
        }

        super.update(l);

    }

    public void CollidedWithBrick_GoToLeft() {
    }

    public void CollidedWithBrick_GoToRight() {
    }

    public int getType() {
        return this.getID();
    }

    public void setActive(boolean b) {
        super.setActive(false);
    }

    public void MarioJumpedOnEnemy() {
        if (game.player.HasStar()) {
            KilledByFireBall();
        } else {
            if (game.player.getY() + game.player.getHeight() > this.getY() + 16) {
                game.player.Decerease();
            }
        }
    }

    public void KilledByFireBall() {
        super.setActive(false);
        game.playSound("music/smb_kick.wav");
    }

    public void bounce() {
    }

    public void setYloc(double d) {
    }

    public void CollidedWithShell() {
        KilledByFireBall();
    }

    public void CollidedWithMovingShell() {

        KilledByFireBall();
    }

    public void OtherEnemyTouchedFromRight() {
    }

    public void OtherEnemyTouchedFromLeft() {
    }

    public void CollidedWithMarioFromTOLeft() {
        if (game.player.HasStar()) {

            KilledByFireBall();
        } else {
            if (game.player.getY() + game.player.getHeight() > this.getY() + 16) {
                game.player.Decerease();
            }
        }
    }

    public void CollidedWithMarioTORight() {
        if (game.player.HasStar()) {

            KilledByFireBall();
        } else {
            if (game.player.getY() + game.player.getHeight() > this.getY() + 16) {
                game.player.Decerease();
            }
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
