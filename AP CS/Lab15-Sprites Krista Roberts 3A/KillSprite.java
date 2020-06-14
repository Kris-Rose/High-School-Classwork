
public class KillSprite extends DiesSprite{
     public KillSprite(double left, double top, int width, int height, String image, double vx, double vy, boolean alive,int topStep, boolean overlap){
        super(left, top, width, height, image, vx, vy, alive,topStep, overlap);
        
    }
    
    public void step(World world){
        super.step(world);
        for(int i = 0; i<world.getSprites().size() ;i++){
            if(checkOverlap(world.getSprites().get(i) )){
                world.getSprites().remove(i);
            }
        }
        
    }
        
        
        
        
    }

