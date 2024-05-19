
package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.util.ImageUtil;


public class Helmet extends AnimatedSprite implements BasicEnemy{

    boolean PositiveX = true ;
    
    Mario game ;
    
    public int Gravity = 5;
    
    String Color  ;
    
    public Helmet(int x, int y, String color , Mario g) {
        Color = color ;
        game = g ;
        
        if("normal".equals(Color)){
            
        this.setImages(game.bsLoader.getStoredImages("Helmet"));
        
        }else if("dark".equals(Color)){
            
        this.setImages(game.bsLoader.getStoredImages("Helmetdark"));
        
        }else if("white".equals(Color)){
            
        this.setImages(game.bsLoader.getStoredImages("Helmetwhite"));
        
        } 
            
        this.setLocation(x, y);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        this.setAnimationFrame(0, 1);
        this.setID(105);
        
    }

        public void update(long l){
        moveY(Gravity);
        if(PositiveX){
        moveX(-1);
        }else {
        moveX(1); 
        }
        super.update(l);
    }
            
    public void MarioJumpedOnEnemy() {
        
            game.player.Jump(-8);
            
            game.EnemyGroup.add(new HelmetShell(this.getX() , this.getY() , this.Color , game , MariotoRight() ));
        
            this.setActive(false);
        
         
    }

    public void CollidedWithShell() {
        // change Direction
    }

    public void CollidedWithMovingShell() {
        
        game.playSound("music/smb_kick.wav");
        
        game.AnimationGroup.add(new FallingDeadSprites(this.getX() , this.getY() , this.getImage() , MariotoRight() ));

        this.setActive(false);
    }

    public void CollidedWithBrick_GoToLeft() {
        PositiveX = true ;
        this.setAnimationFrame(0, 1);
    }

    public void CollidedWithBrick_GoToRight() {
        PositiveX = false ;
        this.setAnimationFrame(2, 3);
    }
    
    public int getType() {
        return this.getID();
    }




    public void KilledByFireBall() {
    }

    public void bounce() {
    }

    public void setYloc(double d) {
        this.setY(d);
    }

    public void OtherEnemyTouchedFromRight() {
        PositiveX = true ;
        this.setAnimationFrame(0, 1);
    }

    public void OtherEnemyTouchedFromLeft() {
        PositiveX = false ;
        this.setAnimationFrame(2, 3);
    }

    public void CollidedWithMarioFromTOLeft() {
        if(game.player.HasStar()){
        CollidedWithMovingShell();
        }else{
            game.player.Decerease();
        }
    }

    public void CollidedWithMarioTORight() {
        if(game.player.HasStar()){
        CollidedWithMovingShell();
        }else{
            game.player.Decerease();
        }
    }

    public void EnemyJumperOnMario() {
        if(game.player.HasStar()){
        CollidedWithMovingShell();
        }else{
            game.player.Decerease();
        }
    }

    public int Life() {
        return 0 ;
    }

    public void CollidedWithJumping_Brick() {
//        game.playSound("music/smb_kick.wav");
        game.EnemyGroup.add(new HelmetShell(this.getX() , this.getY() , this.Color , game , MariotoRight() ));
            
        this.setActive(false);
        
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
