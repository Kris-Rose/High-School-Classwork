
/**
 * Write a description of class HashTable here.
 *
 * Krista R
 * @11/11/19
 */
public class HashTable
{
    private int size;
    private Object[] table;
    public HashTable(){
        size = 101;
        table = new Object[101];
    }

    public HashTable(int initCap){        
        size = initCap;
        table = new Object[size];
    }
    
    public Object put(Object key, Object value){
        Entry toPut = new Entry(key, value);
        int index = (key.hashCode()%size);
        if(table[index] == null){
            table[index] = toPut;
            return null;
        }
        else{
            Object returnedValue = table[index];
            table[index] = toPut;
            return returnedValue;
        }
    }
    
    public Object get(Object key){
        int index = (key.hashCode()%size);
        if(table[index] == null){
            return null;
        }
        else{
            return table[index];
        }
    }
    
    public String toString(){
        String bruh = "";
        for(int a = 0; a<table.length;a++){
            if(table[a] == (null)){
            }
            else{
                bruh += a + ":  " + table[a].toString() + "\n";
            }
            
        }
        
        return bruh;
    }
}
