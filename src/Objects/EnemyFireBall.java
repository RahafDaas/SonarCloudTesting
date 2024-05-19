package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class EnemyFireBall extends AnimatedSprite implements BasicEnemy {

    Mario game;
    int DistanceFromCenter;
    int CenterX, CenterY;
    boolean AntiClockWise = true;

    public EnemyFireBall(int x, int y, BufferedImage[] Enemy_Image, Mario g) {
        setLocation(x, y);
        CenterX = x;
        CenterY = y;
        setImages(Enemy_Image);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        this.setAnimationFrame(0, 3);
        game = g;

        this.setID(114);
    }

    public EnemyFireBall(int CenterX, int CenterY, int dis, Mario game, boolean Anticlockwise) {

        this(CenterX, CenterY, game.bsLoader.getStoredImages("FireBall"), game);

        DistanceFromCenter = dis;

        AntiClockWise = Anticlockwise;

    }

    public void update(long l) {

        if (AntiClockWise) {
            this.setX((Math.sin(game.Distance) * DistanceFromCenter) + CenterX);
            this.setY((Math.cos(game.Distance) * DistanceFromCenter) + CenterY);
        } else {
            this.setX((Math.sin(game.InvertDistance) * DistanceFromCenter) + CenterX);
            this.setY((Math.cos(game.InvertDistance) * DistanceFromCenter) + CenterY);
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

    public void MarioJumpedOnEnemy() {
        if (game.player.HasStar()) {
        } else {
            game.player.Decerease();
        }
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
        if (game.player.HasStar()) {
        } else {
            game.player.Decerease();
        }
    }

    public void CollidedWithMarioTORight() {
        if (game.player.HasStar()) {
        } else {
            game.player.Decerease();
        }
    }

    public void EnemyJumperOnMario() {
        if (game.player.HasStar()) {
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