
public class StationarySprite extends Sprite
{
    
    public StationarySprite(double left, double top, int width, int height, String image, boolean dead, boolean overlap)
    {
        super(left, top, width, height, image, dead, overlap);
    }
    
    public void step(World world){}
}
