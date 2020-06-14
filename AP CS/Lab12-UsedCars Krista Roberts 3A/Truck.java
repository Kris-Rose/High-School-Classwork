public class Truck extends Vehicle {
    private int towing; 
    
    public Truck(String t, int y, double p, int towing){
        super(t, y, p);
        this.towing = towing;
    }
    public boolean canTowBoat(){
        if(towing>=2000){
            return true;
        }
        else{
            return false;
        }
    }
    @Override 
    public String getInfo(){
        return (super.getInfo() + ", "  +towing+ " towing, $" + getPrice() );
    }
}
