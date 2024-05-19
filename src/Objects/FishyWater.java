package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;

public class FishyWater extends AnimatedSprite implements BasicEnemy {

    // 4 types of fish
    // 1 straight : reg green
    // 2 up down : red green
    // red speed max 
    Mario game;
    double Xspeed = 1;
    String type = "grey";
    boolean UpDown = false;
    int Up = 0, Down = 0;
    boolean goingUp = true;

    public FishyWater(int x, int y, Mario g, int Type) {
        game = g;
        switch (Type) {
            case 1:
                Xspeed = -0.5;
                type = "grey";
                UpDown = false;
                setImages(game.bsLoader.getStoredImages("FishGrey"));
                setAnimationTimer(new Timer(200));
                break;
            case 2:
                Xspeed = -0.5;
                type = "grey";
                UpDown = true;
                setImages(game.bsLoader.getStoredImages("FishGrey"));
                setAnimationTimer(new Timer(200));
                break;
            case 3:
                Xspeed = -1;
                type = "red";
                UpDown = false;
                setImages(game.bsLoader.getStoredImages("FishRed"));
                setAnimationTimer(new Timer(100));
                break;
            case 4:
                Xspeed = -1;
                type = "red";
                UpDown = true;
                setImages(game.bsLoader.getStoredImages("FishRed"));
                setAnimationTimer(new Timer(100));
                break;

        }
        Up = y - 32;
        Down = y + 32;
        setLocation(x, y);

        setAnimate(true);
        setLoopAnim(true);
        this.setAnimationFrame(0, 1);


        this.setID(112);
    }

    public void update(long l) {

        moveX(Xspeed);


        if (UpDown) {

            if (this.getY() < Up) {
                goingUp = false;

            }
            if (this.getY() > Down) {
                goingUp = true;

            }

            if (goingUp) {
                this.moveY(-0.5);
            }
            if (!goingUp) {
                this.moveY(0.5);
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
        game.AnimationGroup.add(new FallingDeadSprites(this.getX(), this.getY(), this.getImage(), MariotoRight()));
        this.setActive(false);

    }

    public void bounce() {
    }

    public void setYloc(double d) {
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
        MarioJumpedOnEnemy();
    }

    public void CollidedWithMarioTORight() {
        MarioJumpedOnEnemy();
    }

    public void EnemyJumperOnMario() {
        MarioJumpedOnEnemy();
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