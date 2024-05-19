package Objects;

import Animations.CoinAnim;
import SandBox.Mario;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;
import java.awt.image.BufferedImage;

public class Coin extends AdvanceSprite implements BasicEnemy {

    Mario game;

    public Coin(int x, int y, BufferedImage[] storedImages, Mario M) {
        setLocation(x, y);
        setImages(storedImages);
        int[] animation = {0, 0, 0, 0, 1, 2, 1, 0};
        this.setAnimationFrame(animation);
        this.setAnimate(true);
        this.setLoopAnim(true);
        this.setAnimationTimer(new Timer(150));

        game = M;

        this.setID(21);

    }

    public void CollidedWithBrick_GoToLeft() {
    }

    public void CollidedWithBrick_GoToRight() {
    }

    public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
        super.setActive(false);
        game.parent.CoinInc();
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
//        game.Score();
        super.setActive(false);
        game.parent.CoinInc();
    }

    public int Life() {
        return 0;
    }

    public void CollidedWithJumping_Brick() {

        game.AnimationGroup.add(new CoinAnim((int) this.getX(), (int) this.getY(), game.bsLoader.getStoredImages("CoinAnim"), game));

        this.setActive(false);
        game.parent.CoinInc();
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
