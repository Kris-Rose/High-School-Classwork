public class Car extends Vehicle{
    private double mpg; 
    
    public Car(String t, int y, double p, double mpg){
        super(t, y, p);
        this.mpg = mpg;
    }
    public boolean greatGasMileage(){
        if(mpg>=36){
            return true;
        }
        else{
            return false;
        }
    }
    @Override 
    public String getInfo(){
        return (super.getInfo() + ", "  +mpg+ " mpg, $" + getPrice() );
    }
}
