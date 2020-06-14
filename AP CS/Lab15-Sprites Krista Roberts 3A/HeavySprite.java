
public class HeavySprite extends MobileSprite
{
    public HeavySprite(double left, double top, int width, int height, String image, double vx, double vy, boolean alive, boolean overlap){
        super(left, top, width, height, image, vx, vy, alive, overlap);
        
    }
    
    public void step(World world){
        super.step(world);
        setTop(this.getTop()-.1);
    }
}
