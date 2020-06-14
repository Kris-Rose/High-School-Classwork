
public class Car extends Automobile
{
    double mpg;
    public Car( String version, int date, double price, double mpg)
    {
        super(price, date, version);
        this.mpg = mpg;
    }
    public double getPrice(){
        if(mpg >= 30){
            double discount = getMSRP()/10;
            
            return (getMSRP() - discount);
        }
        else{
            return getMSRP();
        }
    }
    
    public String getInfo(){
        return "" + year + " " + type + ", " + mpg + "mpg, $" + getPrice();
    }
}
