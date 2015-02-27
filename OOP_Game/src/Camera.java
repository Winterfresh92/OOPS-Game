/* Kevin Stubblefield
 * Last Updated: February 24, 2015
 * Known Bugs: None (Character may not be centered in the screen)
*/
public class Camera {
    private float x, y;
    
    public Camera(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void update(Player player) {
        x = -player.getX() - player.getWidth() / 2 + Game.WIDTH / 2;
        y = -player.getY() - player.getHeight() + Game.HEIGHT / 2;
    }
    
    public void setX(float x)
    {
        this.x = x;
    }
    
    public void setY(float y)
    {
        this.y = y;
    }
    
    public float getX()
    {
        return this.x;
    }
    
    public float getY()
    {
        return this.y;
    }
}
