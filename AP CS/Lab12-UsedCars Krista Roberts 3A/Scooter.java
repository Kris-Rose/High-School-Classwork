
public class Scooter extends Vehicle{
    private double speed;
    public Scooter(String t, int y, double p, double s){
        super(t, y, p);
        speed = s;
    }
    public double getSpeed(){
        return speed;
    }
    @Override 
    public String getInfo(){
        return (super.getInfo() + ", " + speed + " mph, $" + getPrice() );
    }
    
}
