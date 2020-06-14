import java.util.*;
/**
 * Write a description of class HashTable here.
 *
 * Krista R
 * @1/14/20/19
 */
public class HashTableB
{
    private int capacity;
    private Object[] table;
    //num of entries currently in table
    private int size;
    private int maxListSize;
    private int numLists;
    //for total insertions
    private long collisions;
    //for inputing and removing individual entries to do quadratic probing 
    private long individualCollisions;
    //for total searches
    private long numProbes;
    
    public HashTableB(){
        capacity = 101;
        size = 0;
        table = new Object[101];
    }

    public HashTableB(int initCap){        
        capacity = initCap;
        size = 0;
        table = new Object[capacity];
    }
    
    public int getSize(){
        return size;
    }
    
    public int getCapacity(){
        return capacity;
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
    
    public Object getValue(int j){
        return ((LinkedList)table[j]);
    }
    
    public int getMaxList(){
       int list = 0; 
       for(int b = 0;b< table.length; b++){
            if(((LinkedList)table[b]) != null){
                if( ((LinkedList)table[b]).size() > list ){
                    list = ((LinkedList)table[b]).size();
                }
            }
        }
       return list;
    }
    
    public long getNumLists(){
        numLists = 0;
        for(int b = 0;b< table.length; b++){
            if(((LinkedList)table[b]) != null){
                if( ((LinkedList)table[b]).size() != 0 ){
                    numLists++;
                }
            }
            
            
        }
        
        return numLists;
    }
    
    public boolean isNull(int j){
        if(table[j] == null ){
            return true;
        }
        else if( (((LinkedList)table[j]).size() == 0)){
            return true;
        }
        else{
            return false;
        }
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
            int index = Math.abs((key.hashCode()%capacity));
            //main loop
            
            
            boolean placed = false;
            
            
            while(placed == false ){
                if(table[index ] == null){
                    table[index] = new LinkedList<Entry>();
                    ((LinkedList)table[index]).addFirst(toPut);
                    placed = true;
                    size++;
                    return returnValue;
                }
                else {
                    //already has a linked list
                    
                        //check for duplicates
                        
                        
                        
                        for(int b = 0;b< ((LinkedList)table[index]).size(); b++){
                            if(((Entry)((LinkedList)table[index]).get(b)).key.equals(key)){
                                returnValue = ((Entry)((LinkedList)table[index]).get(b)).getValue();
                                //((LinkedList)table[index]).remove(b);
                            }
                        }
                        ((LinkedList)table[index]).addFirst(toPut);
                        // if no duplicates/rewrites increase size
                        if(returnValue == null){
                            size++;
                        }
                        placed = true;
                        //collision bc linkedlist was already at index
                        collisions++;
                        return returnValue;
                    
                        
                    
                }
                
                
                
            }
            
            return returnValue;
            
        }
        
        
    }
    
    public Object remove(Object key){
        Object value = null;
        individualCollisions = 0;
        if(!(contain(key))){
            return value;
        }
        else{
            int index = Math.abs(key.hashCode()%capacity);
            
            for(int b = 0;b< ((LinkedList)table[index]).size(); b++){
                if(((Entry)((LinkedList)table[index]).get(b)).key.equals(key)){
                    value = ((Entry)((LinkedList)table[index]).get(b)).getValue();
                    ((LinkedList)table[index]).remove(b);
                    size--;
                    numProbes++;
                    if(((LinkedList)table[index]).size() == 0){
                        table[index] = null;
                    }
                    
                    return value;
                    
                }
                numProbes++;
            }
            return value;
           
        }
        
        
    }
    
    public boolean contain(Object key){
        int index = Math.abs((key.hashCode()%capacity));
        int og = index;
        boolean found = false;
        if(table[index] == null){
            return found;
        }
        
        //search the linked list
        for(int b = 0;b< ((LinkedList)table[index]).size(); b++){
            if(((Entry)((LinkedList)table[index]).get(b)).key.equals(key)){
                found = true;
            }
            numProbes++;
        }
        
        return found;
    }
    
    public Object getList(int b){
        Object value = null;
        individualCollisions = 0;
        if(table[b] == (null)){
            return value;
        }
        else{
            
            value = (LinkedList)table[b];
            
            
            return value;
            
        }
    }
    
    public Object get(Object key){
        Object value = null;
        individualCollisions = 0;
        if(!(contain(key))){
            return value;
        }
        else{
            int index = Math.abs(key.hashCode()%capacity);
            value = (LinkedList)table[index];
            
            
            return value;
            
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
