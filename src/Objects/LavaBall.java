
package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import java.awt.Color;
import java.awt.Graphics2D;

public class LavaBall extends AnimatedSprite implements BasicEnemy{

    Mario game ;
    
    double gravity = -10 ;
    private int timer;
    
    public LavaBall(double x, double y , Mario g) {
        super(x, 14*32);
        game = g ;
        this.setImages(game.bsLoader.getStoredImages("LavaBall"));
        
        this.setFrame(0);
    }

    public void update(long elapsedTime) {
        
        if(gravity < 10){
            gravity = gravity + 0.4 ;
            
        }
        
        if(this.getY() > 500){
            
            Jump();
//            gravity = 0 ;
            
        }else{
            this.moveY(gravity);
        }
        
        
        if(gravity >0){
            this.setFrame(0);
        }else{
            this.setFrame(1);
        }
        
        
        
        super.update(elapsedTime);
    }

    private void Jump() {
        
        timer-- ;
        if(timer < 0){
        timer = com.golden.gamedev.util.Utility.getRandom(2, 7)*20;
        this.setY(500);
        gravity = com.golden.gamedev.util.Utility.getRandom(-17, -14);
//        gravity = -17 ;
        }
    }

    public void CollidedWithBrick_GoToLeft() {
        
    }

    public void CollidedWithBrick_GoToRight() {
        
    }

     public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
        
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
