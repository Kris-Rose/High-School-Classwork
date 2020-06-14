
/**
 * Write a description of class Entry here.
 *
 * @Krista R
 * @version (a version number or a date)
 */
public class Entry
{
    public Object key;
    public Object value;
    public boolean removed;

    
    public Entry(){
        key = null;
        value = null;
        removed = false;
    }

    public Entry(Object key, Object value){
        this.key = key;
        this.value = value;
    }
    
    public Object getValue(){
        return value;
    }
    
    public boolean isRemoved(){
        return removed;
    }
    
    public void remove(){
        removed = true;
    }
    
    public String toString(){
        String pair;
        if(removed){
            pair = "dummy";
        }
        else{
            pair = key  + " " + value; 
        }   
        return pair;
    }
    
    
}
