
/**
 * Write a description of class Entry here.
 *
 * @Krista R
 * @version (a version number or a date)
 */
public class Entry
{
    private Object key;
    private Object value;

    
    public Entry(){
        key = null;
        value = null;
    }

    public Entry(Object key, Object value){
        this.key = key;
        this.value = value;
    }
    
    public String toString(){
        String pair =  key  + " " + value; 
        return pair;
    }
    
    
}
