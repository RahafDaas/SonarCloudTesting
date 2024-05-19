
package Objects;

import Animations.DirectFalling;
import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

public class Rocket extends Sprite implements BasicEnemy{

    Mario game ;
    
    double XSpeed = -5 ;
    
    public Rocket(double x, double y, String direction, BufferedImage bufferedImage , Mario g) {
        
        if("gotoleft".equals(direction) ){
             XSpeed = -3 ;
             this.setImage(bufferedImage);
        }else{
             XSpeed = 3 ;
             this.setImage(ImageUtil.flipHorizontal(bufferedImage));
        }
        
        this.setLocation(x, y);
        
        this.setID(109);
        
        game = g ;
        
        // System.out.println("Rocket " + x +" " +y);
        
    }

    public void update(long l){
            
        this.moveX(XSpeed);
        
        RemoveIfTooAway();
        
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
        game.playSound("music/smb_kick.wav");
        game.player.Jump(-8);
        game.AnimationGroup.add(new DirectFalling( this.getImage() , this.getX() , this.getY() ));
        this.setActive(false);
        
    }



    public void KilledByFireBall() {
    }

    private void RemoveIfTooAway() {
        
        if(this.getScreenX() < -32){
            this.setActive(false);
        }
        if(this.getScreenX() > 840){
            this.setActive(false);
        }
    }

    public void bounce() {
    }

    public void setYloc(double d) {
    }

    public void CollidedWithShell() {
    }

    public void CollidedWithMovingShell() {
        game.playSound("music/smb_kick.wav");
        game.AnimationGroup.add(new FallingDeadSprites(this.getX() , this.getY() , this.getImage() , false));
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
