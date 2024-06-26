
package Bricks;

import Animations.CoinAnim;
import Animations.FlowerAnim;
import Animations.LifeAnim;
import Animations.MashroomAnim;
import Gears.Codes;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;


public class InvisibleBrck  extends Sprite implements BasicBrick{

     Mario game ;

     String item ;
     
    public InvisibleBrck(int x , int y , String item, Mario g) {
        this.setLocation(x, y);
        this.setImage(ImageUtil.createImage(32, 32 , 3));
        
//        // System.out.println(ImageUtil.getImage(this.getClass().getResource("Images\\QuestionMark.png")).getWidth());
        
        this.setID(17);
        
        game = g ;
        
        this.item = item ;
    }

    public void HitFromDown() {
        
           game.BrickGroup.add(new Iron( (int)this.getX(), (int)this.getY() ,game.bsLoader.getStoredImages("Iron") , game));
    
                switch(Codes.GetCode(this.getInsideItem())){
                    
                    case 1:// Mashroom (flower )
                        // if big mario 2 or 3 ... then come out flower..else u\mushroom ...but will grow level
                        
                        if(game.player.getID() == 1 || game.player.getID() == 4){ // small mario .... come out mushroom
                        game.VolitileGroup.add(new MashroomAnim( (int)this.getX() , (int)this.getY() , game.bsLoader.getStoredImage("Mashroom") , game));
                        }
                        else if(game.player.getID() == 2 || game.player.getID() == 3){   // if big or filr mario .. come out flower
                            
                        game.VolitileGroup.add(new FlowerAnim((int)this.getX() , (int)this.getY(), game.bsLoader.getStoredImages("Flower") , game));

                        }
                        
                        break;
                    case 2: // CoinInside
                        game.AnimationGroup.add(new CoinAnim( (int)this.getX() , (int)this.getY() , game.bsLoader.getStoredImages("CoinAnim") , game));
                    
                    break;
                        
                    case -1 : // 1UP
                        
                        game.VolitileGroup.add(new LifeAnim( (int)this.getX() , (int)this.getY() , game.bsLoader.getStoredImages("1UP")[0] , game));

                        break ;
                }
                
                RemoveIt();
                
    }

    public void RemoveIt() {
        // cant .. just replact by iron
        this.setActive(false);
    }

    public String getInsideItem() {
        return item ;
        
        
        
    }

    public boolean isJump() {
        return false ;
    }
    
    
}
    
    