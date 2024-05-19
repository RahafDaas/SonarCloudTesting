
package CheckPoint;

import com.golden.gamedev.object.Sprite;
import java.awt.Point;

public class CheckPoints extends Sprite implements BasicCheckPoints{

    public int NextLevel ;
    
    public Point NextLocation ; 
    
    
    /**
     * 
     * @param x 
     * @param y
     * @param NextLevel level number (eg for level 1-1 use 11 m for 1-2 use 12 etc)
     * @param NextLocation point where mario x and y location should be
     */
    public CheckPoints( double x, double y , int NextLevel, Point NextLocation  ) {
        super(x, y);
        this.NextLevel = NextLevel;
        this.NextLocation = NextLocation;
//        this.MarioStatus = MarioStatus;
        // System.out.println(x +" "+ y);
        this.setID(23);
        
    }


    public void update(long elapsedTime) {
        super.update(elapsedTime);
    }

    public int GetNextLevel() {
        return NextLevel ;
    }

    public Point GetNextLocation() {
        return NextLocation;
    }


    
}
