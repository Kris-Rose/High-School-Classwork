
public class GenSprite extends MobileSprite{
    int stepCount;
    public GenSprite(double left, double top, int width, int height, String image, double vx, double vy, boolean alive, boolean overlap){
        super(left, top, width, height, image, vx, vy, alive, overlap);
        stepCount = 0;
    }
    
    public void step(World world){
        super.step(world);
        stepCount++;
        if(stepCount%100 == 0){
            world.getSprites().add(new KillSprite(this.left, this.top, 30, 30, "projectile.png",this.vx, this. vy, true, false));
        }
    
    }
    
    
    
}
