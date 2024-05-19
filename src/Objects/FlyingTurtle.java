package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

public class FlyingTurtle extends AnimatedSprite implements BasicEnemy {

    boolean PositiveX = true;
    Mario game;
    public double Gravity = -6;
    String Color;

    public FlyingTurtle(String color, int x, int y, Mario g) {
        super(x, y);
        Color = color;
        game = g;
        if (Color.equals("normal")) {
            this.setImages(game.bsLoader.getStoredImages("FlyingTurtle"));
        } else {
            this.setImages(game.bsLoader.getStoredImages("FlyingTurtledark"));
        }
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        this.setAnimationFrame(0, 1);
        this.setID(101);
    }

    public void update(long l) {

        if (Gravity < 5) {
            Gravity += 0.25;
        }

        super.update(l);

        moveY(Gravity);
        if (PositiveX) {
            moveX(-1);
        } else {
            moveX(1);
        }
        super.update(l);
    }

    public void bounce() {
        Gravity = - 8;
    }

    public void MarioJumpedOnEnemy() {

        game.player.Jump(-8);

        if (Color.equals("normal")) {
            game.EnemyGroup.add(new EnemyTurtle((int) this.getX(), (int) this.getY(), game, true));
        } else {
            game.EnemyGroup.add(new EnemyTurtle((int) this.getX(), (int) this.getY(), game, true, this.Color));
        }

        this.setActive(false);

    }

    public void CollidedWithMovingShell() {
        // green 
        BufferedImage HorizontalFilpShell;

        if (Color.equals("normal")) {
            HorizontalFilpShell = game.bsLoader.getStoredImage("TurtelShell");
        } else {
            HorizontalFilpShell = game.bsLoader.getStoredImage("TurtelShelldark");
        }

        HorizontalFilpShell = ImageUtil.flipHorizontal(HorizontalFilpShell);
        game.AnimationGroup.add(new FallingDeadSprites(this.getX(), this.getY(), HorizontalFilpShell, MariotoRight()));
        this.setActive(false);
        game.playSound("music/smb_kick.wav");
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

    public void KilledByFireBall() {
        CollidedWithMovingShell();
    }

    public void setYloc(double d) {
        this.setY(d);
        bounce();
    }

    public void CollidedWithShell() {
        // change direction
    }

    public void OtherEnemyTouchedFromRight() {
        PositiveX = false;
        this.setAnimationFrame(2, 3);
    }

    public void OtherEnemyTouchedFromLeft() {
        PositiveX = true;
        this.setAnimationFrame(0, 1);
    }

    public void CollidedWithMarioFromTOLeft() {
        if (game.player.HasStar()) {
            CollidedWithMovingShell();
            this.setActive(false);
        } else {
            game.player.Decerease();
        }
    }

    public void CollidedWithMarioTORight() {
        if (game.player.HasStar()) {
            CollidedWithMovingShell();
            this.setActive(false);
        } else {
            game.player.Decerease();
        }
    }

    public void Kill() {
    }

    public void EnemyJumperOnMario() {
        if (game.player.HasStar()) {
            CollidedWithMovingShell();
            this.setActive(false);
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
