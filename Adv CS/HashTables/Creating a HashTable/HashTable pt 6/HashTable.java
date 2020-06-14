import java.util.*;
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
    private int maxListSize;
    private int numLists;
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
        numLists = 0;
    }

    public HashTable(int initCap){        
        capacity = initCap;
        size = 0;
        table = new Object[capacity];
        numLists = 0;
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
    
    public Object get(int j){
        return ((Entry)table[j]).getValue();
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
                                ((LinkedList)table[index]).remove(b);
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
            int index = (key.hashCode()%capacity);
            
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
            /*
            if(((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key) && (((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).removed == false)){
                value = ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).getValue();
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
                        value = ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).getValue();
                        ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).removed = true; 
                        size--;
                    }
                    
                }
               
                return value;
            }
            */
        }
        
        
    }
    
    public boolean contain(Object key){
        int index = (key.hashCode()%capacity);
        int og = index;
        boolean found = false;
        
        //search the linked list
        for(int b = 0;b< ((LinkedList)table[index]).size(); b++){
            if(((Entry)((LinkedList)table[index]).get(b)).key.equals(key)){
                found = true;
            }
            numProbes++;
        }
        
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
            
            for(int b = 0;b< ((LinkedList)table[index]).size(); b++){
                if(((Entry)((LinkedList)table[index]).get(b)).key.equals(key)){
                    value = ((Entry)((LinkedList)table[index]).get(b)).getValue();
                    numProbes++;
                    return value;
                }
                numProbes++;
            }
            return value;
            /*
            if(((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key) && (((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).removed == false)){
                value = ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).getValue();
                return value;
                
            }
            else{
                while(!( ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key))){
                    
                    numProbes++;
                    individualCollisions++;
                    if(((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).key.equals(key) && (((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).removed == false)){
                        value = ((Entry)table[(index + (int)Math.pow(individualCollisions, 2))%capacity]).getValue();
                    }
                    
                }
               
                return value;
            }
            */
        }
    }
    
    public String toString(){
        String bruh = "";
        for(int a = 0; a<table.length;a++){
            if(table[a] == (null) ){
            }
            else{
                
                
                bruh += a + ":  " + table[a].toString() + "\n";
            }
            
        }
        
        return bruh;
    }
}
