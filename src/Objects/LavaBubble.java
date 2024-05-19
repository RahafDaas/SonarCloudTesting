
package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;


public class LavaBubble   extends AnimatedSprite implements BasicEnemy{

    
    Mario game ;
    
    public int Gravity = 6;
    

    public LavaBubble(int x, int y, BufferedImage[] Enemy_Image, Mario g) {
        setLocation(x, y);
        setImages(Enemy_Image);
        game = g ;
        
        this.setID(116);
    }

        public void update(long l){
        moveY(Gravity);
        
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
        game.player.Decerease();
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
        game.player.Decerease();
    }

    public void CollidedWithMarioTORight() {
        game.player.Decerease();
    }

    public void EnemyJumperOnMario() {
        game.player.Decerease();
    }

    public int Life() {
        return 0 ; 
    }

    public void CollidedWithJumping_Brick() {
    }

         public boolean MariotoRight() {
        boolean positive ;
        if(game.player.getX() < this.getX()){
            positive = false ;
        }else{
            positive = true ;
        }
        
        return positive;
    }
    
}
