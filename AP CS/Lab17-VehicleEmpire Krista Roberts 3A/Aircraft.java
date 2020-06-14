
public abstract class Aircraft implements Vehicle
{
    double price; 
    String type;
    int year;
    int passengers;
    
    public Aircraft(double cost, String version, int date, int people){
        price = cost;
        year = date;
        type = version;
        passengers = people;
        
    }
    
    public double getPrice(){
        return price;
    }
    public int getYear(){
        return year;
    }
    public String getType(){
        return type;
    }
    public int getPassengers(){
        return passengers;
    }
    
    public String getInfo(){
        return "" + year + " " + type + ", " + passengers + " passengers" ;
    }
    }

