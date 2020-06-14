
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
    //num of entries currently in table
    private int size;
    //for total insertions
    private long collisions;
    //for inputing and removing individual entries to do quadratic probing 
    private long individualCollisions;
    //for total searches
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
    
    public Object put(Object key, Object value){
        Object returnValue = null;
        individualCollisions = 0;
        if(size ==  capacity){
            return null;
        }
        else{
            Entry toPut = new Entry(key, value);
            int temp = key.hashCode();
            int index = (key.hashCode()%capacity);
            //main loop
            
            //uncommented works
            boolean placed = false;
            
            
            while(placed == false ){
                if(table[(index + (int)Math.pow(individualCollisions, 2))%capacity] == null){
                    table[(index + (int)Math.pow(individualCollisions, 2))%capacity] = toPut;
                    placed = true;
                    size++;
                    return returnValue;
                }
                else if(((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).isRemoved() == false){
                    //entry not removed
                    if(((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key)){
                        returnValue = ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).value;
                        table[(index + (int)Math.pow(individualCollisions, 2))%capacity] = toPut;
                        placed = true;
                        return returnValue;
                    }
                    else{
                        
                        individualCollisions++;
                        collisions++;
                    }
                }
                else{
                    //replacing a previously removed value
                    table[(index + (int)Math.pow(individualCollisions, 2))%capacity] = toPut;
                    placed = true;
                    boolean prevEntry = false;
                    size++;
                    //look for previous entries of key
                    while(prevEntry == false && individualCollisions < size){
                        individualCollisions++;
                        if(table[(index + (int)Math.pow(individualCollisions, 2))%capacity] == null){
                            //no previous entry found
                            size++;
                            return returnValue;
                        }
                        else if((((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).isRemoved() == false)){
                            if(((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key)){
                                ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).remove();
                                return ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).getValue();
                            }
                        }
                        else{
                           //a value has been removed-> no prevoious value found 
                           size++;
                           return returnValue;
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
        individualCollisions = 0;
        if(!(contain(key))){
            return value;
        }
        else{
            int index = (key.hashCode()%capacity);
            
            if(((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key) && (((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).removed == false)){
                value = ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).value;
                ((Entry)table[index + (int)Math.pow(individualCollisions, 2)]).removed = true;
                size--;
                return value;
                
            }
            else{
                int temp = (index + (int)Math.pow(individualCollisions, 2))%capacity;
                while(!( ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key)) ){
                    
                    individualCollisions++;
                    numProbes++;
                    if(((Entry)table[index + (int)Math.pow(individualCollisions, 2)]).key.equals(key) && (((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).removed == false)){
                        value = ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).value;
                        ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).removed = true; 
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
        individualCollisions = 0;
        while(found == false && index<table.length && !((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity] == null)){
            
            if( !((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity] == null) && ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key) && (((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).removed == false )){
                found = true;
            }
            
            individualCollisions++;
            numProbes++;
        }
        individualCollisions = 0;
        return found;
    }
    
    public Object get(Object key){
        Object value = null;
        individualCollisions = 0;
        if(!(contain(key))){
            return value;
        }
        else{
            int index = (key.hashCode()%capacity);
            if(((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key) && (((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).removed == false)){
                value = ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).value;
                return value;
                
            }
            else{
                while(!( ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key))){
                    
                    numProbes++;
                    individualCollisions++;
                    if(((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key) && (((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).removed == false)){
                        value = ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).value;
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
