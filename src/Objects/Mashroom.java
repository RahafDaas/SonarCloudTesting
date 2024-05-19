
package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class Mashroom  extends AnimatedSprite implements BasicEnemy{

    
    boolean PositiveX  = true ;
    
    Mario game ;
    
    public double Gravity = 5;
    

    // its overlaping the ron and has to cum up slowly
    public Mashroom(int x, int y, BufferedImage[] storedImage , Mario g) {
        
        super(storedImage , x , y );
        this.setAnimate(true);
        this.setLoopAnim(true);
        
        this.setAnimationTimer(new Timer(300));
        
        
        this.setID(3);
        
        PositiveX  = false ;
        
    }
    
    public void update(long l){
        if(Gravity < 5) {
            Gravity += 0.5;
        }
        moveY(Gravity);
        if(PositiveX ){
        moveX(-2);
        }else {
        moveX(2); 
        }
        super.update(l);
    }

    public void CollidedWithBrick_GoToLeft() {
        PositiveX = true ;
    }

    public void CollidedWithBrick_GoToRight() {
        PositiveX  = false ;
    }

    public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
        game.player.Grow();
        this.setActive(false);
    }



    public void KilledByFireBall() {
    }

    public void bounce() {
        Gravity = -5;
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
         game.player.Grow();
        this.setActive(false);
    }

    public void CollidedWithMarioTORight() {
         game.player.Grow();
        this.setActive(false);
    }

    public void EnemyJumperOnMario() {
         game.player.Grow();
        this.setActive(false);
    }

    public int Life() {
        return 0 ;
    }

    public void CollidedWithJumping_Brick() {
        if(PositiveX  ){     // invert direction
            PositiveX  = false ;
        }else{
            PositiveX  = true ;
        }
        
        bounce();
        
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