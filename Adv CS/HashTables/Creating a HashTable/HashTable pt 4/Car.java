
/**
 * 4 part 4
 *
 * @Krista R
 * @12-3-19
 */
public class Car
{
    private String VIN;
    private String year;
    private String make;
    private String countyOrigin;
    
    public Car(String VIN, String year, String make, String countyOrigin){
        this.VIN = VIN;
        this.year = year;
        this.make = make;
        this.countyOrigin = countyOrigin;
    }
    
    public String getVIN(){
        return VIN;
    }
    
    public String getYear(){
        return year;
    }
    
    public String getMake(){
        return make;
    }
    
    public String getCountyOrigin(){
        return countyOrigin;
    }
    
    public String toString(){
        return ("Vin: " + VIN + "\n Year: " + year + " \n Make: " + make + "\n countryOrigin: " + countyOrigin);
    }
}
