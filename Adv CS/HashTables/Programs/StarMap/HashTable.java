
/**
 * Write a description of class HashTable here.
 *
 * Krista R
 * @11/11/19
 */
public class HashTable
{
    private int capacity;
    private Object[] table;
    private int size;
    private long collisions;
    private long numProbes;
    
    public HashTable(){
        capacity = 101;
        size = 0;
        table = new Object[101];
    }

    public HashTable(int initCap){        
        capacity = initCap;
        size = 0;
        table = new Object[capacity];
    }
    
    public Object getValue(int j){
        return ((Entry)table[j]).getValue();
    }
    
    public int getSize(){
        return size;
    }
    
    public long getCollisions(){
        return collisions;
    }
    
    public void setCollisions( long oof){
        collisions = oof;
    }
    
    public long getNumProbes(){
        return numProbes;
    }
    
    public void setNumProbes( long oof){
        numProbes = oof;
    }
    
    public boolean isNull(int j){
        if(table[j] == null || ((Entry)table[j]).isRemoved()){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public Object put(Object key, Object value){
        Object returnValue = null;
        if(size ==  capacity){
            return null;
        }
        else{
            Entry toPut = new Entry(key, value);
            int index = (key.hashCode()%capacity);
            //main loop
            
            //uncommented works
            boolean placed = false;
            
            
            while(placed == false && index< capacity){
                if(table[index] == null){
                    table[index] = toPut;
                    placed = true;
                    size++;
                    return returnValue;
                }
                else if(((Entry)table[index]).isRemoved() == false){
                    //entry not removed
                    if(((Entry)table[index]).key.equals(key)){
                        returnValue = ((Entry)table[index]).value;
                        table[index] = toPut;
                        placed = true;
                        return returnValue;
                    }
                    else{
                        index++;
                        collisions++;
                    }
                }
                else{
                    //replacing a previously removed value
                    table[index] = toPut;
                    placed = true;
                    boolean prevEntry = false;
                    size++;
                    //look for previous entries of key
                    while(prevEntry == false && index < size){
                        index++;
                        if(table[index] == null){
                            //no previous entry found
                            size++;
                            return returnValue;
                        }
                        else if((((Entry)table[index]).isRemoved() == false)){
                            if(((Entry)table[index]).key.equals(key)){
                                ((Entry)table[index]).remove();
                                return ((Entry)table[index]).getValue();
                            }
                        }
                    }
                }
                
                
            }
            
            return returnValue;
            
            /*
            
            //if empty
            if(table[index] == null){
                table[index] = toPut;
                size++;
                return returnValue;
            }
            else{
                //if dupiplicate key
                if(((Entry)table[index]).key.equals(key)){
                    returnValue = ((Entry)table[index]).value;
                    table[index] = toPut;
                    return returnValue;
                }
                else{
                    //if should add new value
                    boolean placed = false;
                    while(!( ((Entry)table[index]).key.equals(key)) || ((Entry)table[index]) == null){
                        index++;
                        //check for duplicates
                        if(((Entry)table[index]).key.equals(key) && (((Entry)table[index]).removed == false) && placed == false ){
                            returnValue = ((Entry)table[index]).value;
                            table[index] = toPut;
                            placed = true;
                            return returnValue;
                        }
                        if(((Entry)table[index]).key.equals(key) && (((Entry)table[index]).removed == false) && placed == true ){
                            value = ((Entry)table[index]).value;
                            ((Entry)table[index]).removed = true; 
                            size--;
                        }
                        
                    }
                }
                
                
            }
            
            return returnValue;
            */
        }
        
        
    }
    
    public Object remove(Object key){
        Object value = null;
        if(!(contain(key))){
            return value;
        }
        else{
            int index = (key.hashCode()%capacity);
            if(((Entry)table[index]).key.equals(key) && (((Entry)table[index]).removed == false)){
                value = ((Entry)table[index]).value;
                ((Entry)table[index]).removed = true;
                size--;
                return value;
                
            }
            else{
                while(!( ((Entry)table[index]).key.equals(key)) ){
                    index++;
                    numProbes++;
                    if(((Entry)table[index]).key.equals(key) && (((Entry)table[index]).removed == false)){
                        value = ((Entry)table[index]).value;
                        ((Entry)table[index]).removed = true; 
                        size--;
                    }
                    
                }
               
                return value;
            }
        }
        
        
    }
    
    public boolean contain(Object key){
        int index = (key.hashCode()%capacity);
        boolean found = false;
        while(found == false && index<table.length && !((Entry)table[index] == null)){
            
            if( !((Entry)table[index] == null) && ((Entry)table[index]).key.equals(key) && (((Entry)table[index]).removed == false )){
                found = true;
            }
            index++;
            numProbes++;
        }
        return found;
    }
    
    public Object get(Object key){
        Object value = null;
        if(!(contain(key))){
            return value;
        }
        else{
            int index = (key.hashCode()%capacity);
            if(((Entry)table[index]).key.equals(key) && (((Entry)table[index]).removed == false)){
                value = ((Entry)table[index]).value;
                return value;
                
            }
            else{
                while(!( ((Entry)table[index]).key.equals(key)) ){
                    index++;
                    if(((Entry)table[index]).key.equals(key) && (((Entry)table[index]).removed == false)){
                        value = ((Entry)table[index]).value;
                    }
                    
                }
               
                return value;
            }
        }
    }
    
    public String toString(){
        String bruh = "";
        for(int a = 0; a<table.length;a++){
            if(table[a] == (null) || ((Entry)table[a]).isRemoved()){
            }
            else{
                bruh += a + ":  " + table[a].toString() + "\n";
            }
            
        }
        
        return bruh;
    }
}
