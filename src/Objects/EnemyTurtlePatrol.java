package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class EnemyTurtlePatrol extends AnimatedSprite implements BasicEnemy {

    boolean PositiveX = true;
    Mario game;
    public int Gravity = 3;
    boolean Standing = true;
    int Left = 0;
    int right = 0;
    public boolean Green = false;

    public EnemyTurtlePatrol(int x, int y, Mario g, int Length) {
        game = g;
        this.setImages(game.bsLoader.getStoredImages("EnemyTurtlePatrol"));
        this.setLocation(x, y);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        this.setAnimationFrame(0, 1);
        Left = x;
        right = x + (32 * Length);


        this.setID(102);
    }

    public void update(long l) {

        if (this.getX() < Left) {
            this.CollidedWithBrick_GoToRight();

        }
        if (this.getX() > right) {
            this.CollidedWithBrick_GoToLeft();
        }
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

    public void MarioJumpedOnEnemy() {

        game.player.Jump(-8);

        game.EnemyGroup.add(new TurtelShell(this.getX(), this.getY()+16 , game, MariotoRight(), Standing, Green, "normal"));
//            
        this.setActive(false);

    }

    public void KilledByFireBall() {

        game.playSound("music/smb_kick.wav");

        if (this.Green) {
            game.AnimationGroup.add(new FallingDeadSprites(this.getX(), this.getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));

        } else {
            game.AnimationGroup.add(new FallingDeadSprites(this.getX(), this.getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
        }
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

    public void OtherEnemyTouchedFromRight() {
        PositiveX = true;
        this.setAnimationFrame(0, 1);
        // System.out.println("Turtle OtherEnemyTouchedFromRight");
    }

    public void OtherEnemyTouchedFromLeft() {
        PositiveX = false;
        this.setAnimationFrame(2, 3);
        // System.out.println("Turtle OtherEnemyTouchedFromLeft");
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
        game.EnemyGroup.add(new TurtelShell(this.getX(), this.getY() + 16, game, this.MariotoRight(), false, "Jump", this.Green));
        Standing = false;
        this.setActive(false);
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
