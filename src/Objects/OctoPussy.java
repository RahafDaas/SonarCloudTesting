package Objects;

import Animations.DirectFalling;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import java.awt.Point;

public class OctoPussy extends AnimatedSprite implements BasicEnemy {

    // two typer 
    // 1 follow 2 dont follow
    // follow only if mario above them
    boolean PositiveX = true;
    Mario game;
    Point CheckPoint;
    private int Wait = 0;
    private int DownFrame;

    public OctoPussy(int x, int y, Mario g) {
        game = g;
        setLocation(x, y);
        setImages(game.bsLoader.getStoredImages("OctoPussy"));

        this.setID(111);


        CheckPoint = new Point((int) this.getX() - 64, (int) this.getY());


    }

    public void update(long l) {

        Wait--;


        if (this.getY() > 9 * 32) {
            Wait = 0;
            if (game.player.getX() < this.getX()) {
                CheckPoint.x = (int) this.getX() - 64;
            } else {
                CheckPoint.x = (int) this.getX() + 64;
            }


            CheckPoint.y = (int) this.getY() - 64;
            DownFrame = 0;
        }
        if (this.getX() == CheckPoint.getX() & this.getY() == CheckPoint.getY()) {

            Wait = 40;
            if (game.player.getX() < this.getX()) {
                CheckPoint.x = (int) this.getX() - 64;
            } else {
                CheckPoint.x = (int) this.getX() + 64;
            }

            if (game.player.getY() < this.getY()) {
                CheckPoint.y = (int) this.getY() - 32;
            } else {
                Wait = 4000;
            }
            DownFrame = 0;
        }

        if (Wait <= 0) {
            this.moveTo(l, CheckPoint.getX(), CheckPoint.getY(), 0.1);
        } else {
            this.moveY(1);

            DownFrame++;
            if (DownFrame > 5 & DownFrame < 20) {
                this.setFrame(1);
            } else {
                this.setFrame(0);
            }

        }

        super.update(l);
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
        game.AnimationGroup.add(new DirectFalling(this.getX(), this.getY(), this.getImage()));
        this.setActive(false);

    }

    public void bounce() {
    }

    public void setYloc(double d) {
        this.setY(d);
    }

    public void CollidedWithShell() {
        // change direction
    }

    public int getType() {
        return this.getID();
    }

    public void CollidedWithMovingShell() {
        KilledByFireBall();
    }

    public void CollidedWithBrick_GoToLeft() {
    }

    public void CollidedWithBrick_GoToRight() {
    }

    public void OtherEnemyTouchedFromRight() {
    }

    public void OtherEnemyTouchedFromLeft() {
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
