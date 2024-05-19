
package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;


public class HelmetShell extends Sprite implements BasicEnemy{


    Mario game ;
    
    boolean PositiveX = true ;
    
    String Color  ;
    

    HelmetShell(double x, double y, String color, Mario g, boolean direction) {
        
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
        this.setID(106);
        PositiveX = direction ;
        
    }
    
    public void update(long l){
//        moveY(6);
        
        super.update(l);
    }

    public void CollidedWithBrick_GoToLeft(){
    }
    
    public void CollidedWithBrick_GoToRight(){
    }
    

    public int getType() {
        return this.getID();
    }

    public void MarioJumpedOnEnemy() {
        game.playSound("music/smb_kick.wav");
//        game.player.Jump(-8);
        if(game.getPlayer().getX() < this.getX()){
        game.EnemyGroup.add(new MovingHelmetShell(game.getPlayer().getX()+game.getPlayer().getWidth() , this.getY() , this.Color , game , false ));
        }else{
        game.EnemyGroup.add(new MovingHelmetShell(game.getPlayer().getX()- this.getWidth() , this.getY() , this.Color , game , true ));
        }
        this.setActive(false);
        
    }



    public void KilledByFireBall() {
        
//         game.AnimationGroup.add(new FallingDeadSprites(this.getX() , this.getY() , this.getImage()));
//
//         this.setActive(false);
         
    }

    public void bounce() {
    }

    public void setYloc(double d) {
        this.setY(d);
    }

    public void CollidedWithShell() {
        
    }

    public void CollidedWithMovingShell() {
        game.playSound("music/smb_kick.wav");
        game.AnimationGroup.add(new FallingDeadSprites(this.getX() , this.getY() , this.getImage() , MariotoRight() ));

        this.setActive(false);
    }

    public void OtherEnemyTouchedFromRight() {
    }

    public void OtherEnemyTouchedFromLeft() {
    }

    public void CollidedWithMarioFromTOLeft() {
        game.playSound("music/smb_kick.wav");
        game.EnemyGroup.add(new MovingHelmetShell(game.getPlayer().getX()+game.getPlayer().getWidth(), this.getY() , this.Color , game , false ));
            
        this.setActive(false);
        
    }

    public void CollidedWithMarioTORight() {
        game.playSound("music/smb_kick.wav");
        game.EnemyGroup.add(new MovingHelmetShell(game.getPlayer().getX()- this.getWidth()  , this.getY() , this.Color , game , true ));
            
        this.setActive(false);
        
    }

    public void EnemyJumperOnMario() {
    }

    public int Life() {
        return 0 ;
    }

    public void CollidedWithJumping_Brick() {
//        game.playSound("music/smb_kick.wav");
        HelmetShell temp = new HelmetShell(this.getX() , this.getY() , this.Color , game , MariotoRight() );
        temp.setImage(ImageUtil.flipHorizontal(temp.getImage()));
        game.EnemyGroup.add(temp);
            
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
