
public class Airplane extends Aircraft
{
    boolean hasFirstClass;
    
    public Airplane( String version, int date,double cost, int people, boolean hasFirstClass)
    {
        super(cost, version, date, people);
        this.hasFirstClass = hasFirstClass;
    }

    public double getPrice(){
        if(hasFirstClass){
            double addon = super.getPrice()/10;
            return super.getPrice()+addon;
        }
        else{
            return super.getPrice();
        }
    }
    
    public String getInfo(){
        String display = super.getInfo() + ", $" + getPrice();
        if(hasFirstClass){
            display += "\nHas first class ";
        }
        else{
            display += "\nNo first class ";
        }
        
        return display;
    }
    
}
