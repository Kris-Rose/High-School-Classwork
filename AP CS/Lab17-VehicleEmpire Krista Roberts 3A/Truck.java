
public class Truck extends Automobile
{
    int towing;
    public Truck( String version, int date, double price, int towing){
        super(price, date, version);
        this.towing = towing;
    }
    public double getPrice(){
        if(towing >= 5000){
            double discount = (getMSRP()/100)*15;
            
            return (getMSRP() - discount);
        }
        else{
            return getMSRP();
        }
    }
    
    
    public String getInfo(){
        return "" + year + " " + type + ", " + towing + " lbs. towing, $" + getPrice();
    }
}
