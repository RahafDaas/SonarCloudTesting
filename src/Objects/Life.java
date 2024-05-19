
package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class Life extends AnimatedSprite implements BasicEnemy{

    
    boolean PositiveX  = true ;
    
    Mario game ;
    
    public int Gravity = 8;

    // its overlaping the ron and has to cum up slowly
    public Life(int x, int y, BufferedImage[] storedImage , Mario g) {
        
        super(storedImage , x , y );
        this.setAnimate(true);
        this.setLoopAnim(true);
        
        this.setAnimationTimer(new Timer(300));
        
        
        this.setID(12);
        
        PositiveX  = false ;
        
    }
    
    public void update(long l){
        moveY(Gravity);
        if( PositiveX  ){
        moveX(-2);
        }else {
        moveX(2); 
        }
        super.update(l);
    }

    public void CollidedWithBrick_GoToLeft() {
        PositiveX  = true ;
    }

    public void CollidedWithBrick_GoToRight() {
        PositiveX  = false ;
    }

    public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
//        game.player.IncreaseLife();
        this.setActive(false);
    }



    public void KilledByFireBall() {
    }

    public void bounce() {
    }

    public void setYloc(double d) {
        this.setY(d);
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
//        game.player.IncreaseLife();
        this.setActive(false);
    }

    public void CollidedWithMarioTORight() {
//        game.player.IncreaseLife();
        this.setActive(false);
    }

    public void EnemyJumperOnMario() {
        this.setActive(false);
    }

    public int  Life() {
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