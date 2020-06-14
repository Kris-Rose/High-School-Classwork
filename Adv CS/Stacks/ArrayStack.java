
public class ArrayStack<T>// implements IStack
{
    private int topIndex;
    private T[] container;
    
    public ArrayStack(){
        topIndex = -1;
        container =(T[]) new Object [100];
    }
    
        
        
    
    
    
    
    /**
     * The push method should verify there is space on the stack before
     *      taking action. If stack is full, push does nothing.
     *      
     * @param  y    the T value to be pushed on the stack
     */
    public void push(T value){
        
        if(isFull()){
         throw new IllegalStateException("Full Stack");
        }
        else{
         topIndex++;
         container[topIndex] = value;
        }
    }
    
    /**
     * The pop method should verify there is a valid value on the stack
     *      before taking action. 
     * Removes and returns the value on the top of the stack.
     * If stack is empty, pop returns zero.
     * 
     * @return  the value from the top of the stack 
     */
    public T pop(){
     T toPop;
     if(isEmpty()){
            throw new IllegalStateException("Invalid");
            
     }
      else{
         toPop = container[topIndex];
         topIndex--;
         return toPop;
     }
    }
    
    /**
     * The peek method should verify there is a valid value on the stack
     *      before taking action. 
     * Returns the value on the top of the stack.
     * If the stack is empty, peek returns zero.
     * 
     * @return  the value from the top of the stack
     */
    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Empty Stack"); 
        }
        else{
            return container[topIndex];
        }
    }
    
    /**
     * Returns the number of values on the stack.
     * 
     * @return    number of values on the stack 
     */
    public int size(){
        return topIndex+1;
    }
    
    /**
     * Returns true if the stack is empty & false otherwise
     * 
     * @return     true if no values are stored on the stack,
     *             false otherwise
     */
    public boolean isEmpty(){
        if(topIndex <= -1){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Returns true if the stack is full & false otherwise
     * 
     * @return     true if no more values will fit on the stack,
     *             false otherwise
     */
    public boolean isFull(){
        if(topIndex>=99){
           return true; 
        }
        else{
           return false; 
        }
    }
    
    /**
     * Places the stack in an empty condition 
     */
    public void clear(){
        topIndex = -1;   
    }
    
    /**
     * Returns a formatted string of the stack's logical contents.
     * 
     * @return     logical stack contents as a string
     */
    public String toString(){
        String contents = "";
        for(int j = 0; j<=topIndex; j++){
           contents+= container[j] + " "; 
        }
        return contents;
    }
    
    
    
    
    /**
     * Returns a formatted string of the underlying array contents.
     * 
     * @return     array contents as a string
     */
    public String ArrayToString(){
        String contents = "";
        for(int j = 0; j<size(); j++){
            contents+= container[j] + " "; 
        }
        return contents;
    }


    
}
