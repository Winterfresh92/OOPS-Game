package Object;


import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faaez
 */
public class Enemy extends CollidableObject{
    
    Enemy(String ref, float x, float y)
    {
        super(ref,x,y);
        this.solid = true;
    }
    
     public Enemy(String ref, float x, float y, boolean solid, boolean mobile) {
        super(ref, x, y);
        this.width = 64;
        this.height = 64;
        this.solid = solid;
        this.mobile = mobile;
    }
     
    public boolean hitBy(Player p)
    {
        Rectangle bounds = new Rectangle((int)x - 64/2, (int)y - 64/2, 64, 64);
        if(bounds.contains(new Point((int)p.getX(),(int)p.getY())))
        {
            return true;
        }
        else
            return false;
    }    
     
}
