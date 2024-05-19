package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

public class FlyingTurtlePatrol extends AnimatedSprite implements BasicEnemy {

    boolean PositiveX = true;
    Mario game;
    int Up = 0;
    int Down = 0;
    private boolean FiyUp = false;
    int DistanceFromCenter = 4 * 32;
    int CenterX, CenterY;
    public boolean Green = false;

    public FlyingTurtlePatrol(int x, int y, Mario g, int Length) {
        game = g;
        this.setImages(game.bsLoader.getStoredImages("FlyingTurtlePatrol"));
        this.setLocation(x, y);
        Up = y;
        Down = y + (32 * Length);
        this.setID(101);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        this.setAnimationFrame(0, 1);

        CenterY = y + (32 * Length);
    }

    public void update(long l) {
//            if(this.getY() < Up){
//            this.GoDown();
//            
//        }if(this.getY() > Down){
//            this.GoUp();
//        }
//        
//        if(FiyUp){
//            moveY(-2);
//        }else{
        this.setY((Math.cos(game.SlowDistance) * DistanceFromCenter) + CenterY);
        moveY(game.SlowDistance);
//        }



        super.update(l);
    }

    public void bounce() {
    }

    public void MarioJumpedOnEnemy() {

        game.player.Jump(-8);

        game.EnemyGroup.add(new EnemyTurtle((int) this.getX(), (int) this.getY(), game, this.Green));

        this.setActive(false);

    }

    public void CollidedWithMovingShell() {
        game.playSound("music/smb_kick.wav");
        BufferedImage HorizontalFilpShell = game.bsLoader.getStoredImage("TurtelShellRed");
        HorizontalFilpShell = ImageUtil.flipHorizontal(HorizontalFilpShell);
        game.AnimationGroup.add(new FallingDeadSprites(this.getX(), this.getY(), HorizontalFilpShell, MariotoRight()));
        this.setActive(false);
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
//        PositiveX = false ;
//        this.setAnimationFrame(2, 3);
    }

    public void OtherEnemyTouchedFromLeft() {
//        PositiveX = true ;
//        this.setAnimationFrame(0, 1);
    }

    public void CollidedWithMarioFromTOLeft() {
        if (game.player.HasStar()) {
            CollidedWithMovingShell();
        } else {
            game.player.Decerease();
        }
    }

    public void CollidedWithMarioTORight() {
        if (game.player.HasStar()) {
            CollidedWithMovingShell();
        } else {
            game.player.Decerease();
        }
    }

    public void Kill() {
    }

    public void EnemyJumperOnMario() {
        if (game.player.HasStar()) {
            CollidedWithMovingShell();
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

    private void GoDown() {
        FiyUp = false;
    }

    private void GoUp() {
        FiyUp = true;
    }
}
