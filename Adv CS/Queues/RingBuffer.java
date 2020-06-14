

/**
 * Write a description of class RingBuffer here.
 *
 * @Krista Roberts
 * @9-12-19
 */
public class RingBuffer<T>
{
    private int first;
    private int last;
    private T[] arrayQueue;
    private int size;
    
    public RingBuffer(int capacity)
    {
        arrayQueue = (T[])new Object[capacity];
        first = 0;
        last = 0;
        size = 0;
    }

    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return (size == 0);
    }
    
    public boolean isFull(){
        return (size == arrayQueue.length);
    }
    
    public void enqueue(T x){
        if(isFull()){
            throw new IllegalStateException();
        }
        
         
        arrayQueue[last] = x;
        last++;
        size++;
    
        if(last>= arrayQueue.length){
            last = 0;
        }
            
            
        
    }
    
    public T dequeue(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        else{
            T toReturn = arrayQueue[first]; 
            first++;
            if(first >= arrayQueue.length){
                first = 0; 
            }
            
            size--;
            return toReturn;
        }
        
    }
    
    public void clear(){
       while(!isEmpty()){
           dequeue();
        }
    }
    
    public T peek(){
        if(isEmpty()){
           throw new IllegalStateException();
        }
        return arrayQueue[first];
    }
}
