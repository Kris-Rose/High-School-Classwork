
/**
 * Write a description of class VIN here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VIN
{
   
    private String ID;

    
    public VIN()
    {
        ID = null;
    }
    
    public VIN(String s)
    {
        ID = s;
    }
    
    public String getID(){
        return ID;
    }
    
    @Override
    public boolean equals(Object o){
        boolean same = false;
        if(((VIN)o).getID().equals(ID) && ((VIN)o).hashCode() == hashCode()){
            same = true;
        }
        return same;
    }
    
    @Override
    public int hashCode(){
       int value = 0;
       for(int i = 0; i<ID.length();i++){
           value += Math.pow((ID.charAt(i))*i, 2);
       }
       return Math.abs(value);
    }
    
    @Override
    public String toString(){
       return ID; 
    }
}
