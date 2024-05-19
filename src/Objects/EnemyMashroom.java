package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.VolatileSingleImage;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

public class EnemyMashroom extends AnimatedSprite implements BasicEnemy {

    boolean PositiveX = true;
    Mario game;
    public int Gravity = 5;

    public EnemyMashroom(int x, int y, BufferedImage[] Enemy_Image, Mario g) {
        setLocation(x, y);
        setImages(Enemy_Image);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        this.setAnimationFrame(0, 1);
        game = g;

        this.setID(100);
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

    public void MarioJumpedOnEnemy() {
        if (game.player.HasStar()) {
            KilledByFireBall();
        } else {
            game.player.Jump(-8);

            VolatileSingleImage DeadMushroom = new VolatileSingleImage(ImageUtil.resize(this.getImage(), 32, 16), this.getX(), this.getY() + 16, 100);

            game.VolitileGroup.add(DeadMushroom);

            this.setActive(false);
        }
    }

    public void KilledByFireBall() {

        game.AnimationGroup.add(new FallingDeadSprites(this.getX(), this.getY(), this.getImage(), MariotoRight()));
        this.setActive(false);
        game.playSound("music/smb_kick.wav");

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
        PositiveX = true;
        this.setAnimationFrame(0, 1);
    }

    public void CollidedWithBrick_GoToRight() {
        PositiveX = false;
        this.setAnimationFrame(0, 1);

    }

    public void OtherEnemyTouchedFromRight() {
        PositiveX = true;
        this.setAnimationFrame(0, 1);
    }

    public void OtherEnemyTouchedFromLeft() {
        PositiveX = false;
        this.setAnimationFrame(0, 1);
    }

    public void CollidedWithMarioFromTOLeft() {
        if (game.player.HasStar()) {
            KilledByFireBall();
        } else {
            game.player.Decerease();
//             // System.out.println("Decerease");
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
//             // System.out.println("Decerease");
        }
    }

    public int Life() {
        return 0;
    }

    public void CollidedWithJumping_Brick() {
        KilledByFireBall();

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
