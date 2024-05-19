package Objects;

import Animations.DirectFalling;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.util.Utility;
import java.awt.image.BufferedImage;

public class SonOfABuitch extends AnimatedSprite implements BasicEnemy {

    boolean PositiveX = true;
    Mario game;
    int Movement;
    boolean goLeft = true;
    int Delay = 100;

    public SonOfABuitch(int x, int y, BufferedImage[] Enemy_Image, Mario g) {
        setLocation(x, 80);
        setImages(Enemy_Image);
        game = g;

        this.setID(115);

        Movement = 100; // -100 and +100
    }

    public void update(long l) {

        Delay--;
        if (Delay < 0) {
            ThrowSpikes();
            this.setFrame(0);
        }
        if (Delay > 1 & Delay < 10) {
            this.setFrame(1);
        }

        if (true) {   // not near to home and flag

            if (goLeft) {
                Movement--;
            } else {
                Movement++;
            }

            if (Movement < -100) {
                goLeft = false;
            } else if (Movement > 100) {
                goLeft = true;
            }

            this.setX(game.player.getX() + (Movement * 2));
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
        game.player.Jump(-8);
        game.AnimationGroup.add(new DirectFalling(this.getImage(), this.getX(), this.getY()));
        this.setActive(false);
    }

    public void KilledByFireBall() {
        game.playSound("music/smb_kick.wav");
        game.AnimationGroup.add(new DirectFalling(this.getImage(), this.getX(), this.getY()));
        this.setActive(false);
    }

    public void bounce() {
    }

    public void setYloc(double d) {
    }

    public void CollidedWithShell() {
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

    private void ThrowSpikes() {
        Delay = Utility.getRandom(1, 5) * 100;

        game.EnemyGroup.add(new SpikeyEgg((int) this.getX(), (int) this.getY(), game.bsLoader.getStoredImages("SpikeyEgg"), game, PositiveX));
    }

    public int Life() {
        return 0;
    }

    public void CollidedWithJumping_Brick() {
        // this doesnot collide with anything thats why the name
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
