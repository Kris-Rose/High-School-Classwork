
public abstract class Automobile implements Vehicle{
    double MSRP; 
    String type;
    int year;
    
    public Automobile(double price, int date, String version){
        MSRP = price;
        year = date;
        type = version;
    }
    
    public double getMSRP(){
        return MSRP;
    }
    public int getYear(){
        return year;
    }
    public String getType(){
        return type;
    }
    
    public String getInfo(){
        return "" + year + " " + type;
    }
    
}
