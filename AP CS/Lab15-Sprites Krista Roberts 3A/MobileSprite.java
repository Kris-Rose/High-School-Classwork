
public class MobileSprite extends Sprite
{
    private double vx,vy;
    
    public MobileSprite(double left, double top, int width, int height, String image, double vx, double vy, boolean alive, boolean overlap){
        super(left, top, width, height, image, alive, overlap);
        this.vx = vy;
        this.vy = vy;
    }
    
    public double getVx(){
        return vx;
    }
    public double getVy(){
        return vy;
    }
    public double setVx(double xVel){
        vx = xVel;
        return vx;
    }
    public double setVy(double yVel){
        vy = yVel;
        return vy;
    }
    
    public void step(World world){
        setLeft(this.getLeft() + vx);
        setTop(this.getTop() + vy);
        
        if (getLeft() < 0) //bounce off left edge
			vx = Math.abs(vx);
		
		if (getLeft() + getWidth() >= world.getWidth()) //bounce off right edge
			vx = -Math.abs(vx);
		
		if (getTop() < 0) //bounce off top edge
			vy = Math.abs(vy);
		
		if (getTop() + getHeight() >= world.getHeight()) //bounce off bottom edge
			vy = -Math.abs(vy);

    }
}
