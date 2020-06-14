
public class Helicopter extends Aircraft implements Leaseable
{
    boolean canShootMissiles;  
    
    public Helicopter( String version, int date,double cost, int people,  boolean canShootMissiles)
    {
        super(cost, version, date, people);
        this.canShootMissiles = canShootMissiles;
    }
    
    public double getPrice(){
        if(canShootMissiles){
            double addon = (super.getPrice()/100) * 25;
            return super.getPrice()+addon;
        }
        else{
            return super.getPrice();
        }
    }
    
    public String getInfo(){
        String display = super.getInfo() + ", $" + getPrice();
        if(canShootMissiles){
            display += "\nShoots missiles ";
        }
        else{
            display += "\nDoes not shoot missiles ";
        }
        
        return display;
    }
    
    public double getMonthlyPayment(){
        return getPrice()/60;
    }
}
