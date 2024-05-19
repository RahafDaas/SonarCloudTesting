
package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

public class MovingHelmetShell extends Sprite implements BasicEnemy{

    boolean PositiveX = true ;
    
    Mario game ;
    
    public int Gravity = 5;
    
    String Color ;
    
//    MovingHelmetShell(double x, double y, BufferedImage storedImage, Mario g, boolean b) {
//        super(storedImage , x , y  );
//        this.setID(107);
//        
//        PositiveX = b ;
//        
//        game = g ;
//    }

    public MovingHelmetShell(double x, double y, String color, Mario g, boolean b) {
        game = g ;
        Color = color ;
        
        if("normal".equals(Color)){
            
        this.setImage(game.bsLoader.getStoredImage("HelmetShell"));
        
        }else if("dark".equals(Color)){
            
        this.setImage(game.bsLoader.getStoredImage("HelmetShelldark"));
        
        }else if("white".equals(Color)){
            
        this.setImage(game.bsLoader.getStoredImage("HelmetShellwhite"));
        
        } 
        this.setLocation(x, y);
        this.setID(107);
        PositiveX = b ;
    }

     public void update(long l){
        moveY(Gravity);
        if(PositiveX){
        moveX(-5);
        }else {
        moveX(5); 
        }
        super.update(l);
    }
            
    public void CollidedWithBrick_GoToLeft() {
        PositiveX = true ;
        if(this.getScreenX() > -500 & this.getScreenX() < 1200){
        game.playSound("music/smb_bump.wav");
        }
        
    }

    public void CollidedWithBrick_GoToRight() {
        PositiveX = false ;
        if(this.getScreenX() > -500 & this.getScreenX() < 1200){
        game.playSound("music/smb_bump.wav");
        }
    }

    public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
        
        game.player.Jump(-8);
        
        game.EnemyGroup.add(new HelmetShell(this.getX() , this.getY() , this.Color , game , MariotoRight() ));

        this.setActive(false);
    }



    public void KilledByFireBall() {
    }

    public void bounce() {
        Gravity = 6;
    }

    public void setYloc(double d) {
        this.setY(d);
    }

    public void CollidedWithShell() {
        
    }

    public void CollidedWithMovingShell() {
        game.playSound("music/smb_kick.wav");
        game.AnimationGroup.add(new FallingDeadSprites(this.getX() , this.getY() , this.getImage(), MariotoRight() ));
        
        this.setActive(false);
        
        
    }

    public void OtherEnemyTouchedFromRight() {
        
    }

    public void OtherEnemyTouchedFromLeft() {
       
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
        if(PositiveX ){     // invert direction
            PositiveX = false ;
        }else{
            PositiveX = true ;
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
