
public class DiesSprite extends MobileSprite{
    int stepCount;
    int maxStep;
    public DiesSprite(double left, double top, int width, int height, String image, double vx, double vy, boolean alive, int topStep, boolean overlap ){
        super(left, top, width, height, image, vx, vy, alive, overlap);
        stepCount = 0;
        maxStep = topStep;
    }
    
    public void step(World world){
        super.step(world);
        stepCount++;
        if (stepCount>maxStep){
            setAlive(false);
        }
    }
    
}
