
/**
 * 
 *
 * @Krista R
 * @10/18/19
 */
public class QueueLinkedList<T>
{
    private Node<T> head;
    private Node<T> tail;
    private int count;
    
    public QueueLinkedList()
    {
        head = null;
        tail = null;
        count = 0;
    }
    
    public void queue(T data){
        if(head == null){
            head = new Node(data);
            tail = head;
        }
        else{
            /*
             * adds to end, wrong and inefficient
            Node current = head;
            while(!(current.getNextPtr() == null)){
               current = current.getNextPtr();   
            }
            current.setNextPtr(new Node (data));
            */
            //current is reference
            Node current = new Node (data);
            current.setNextPtr(head);
            head.setPrevPtr(current);
            head = current;
        }
        
        count++;
    }
    
    public T dequeue(){
        Node<T> found = tail;
        tail = tail.getPrevPtr();
        
        return (T)found.get(); 
    }
    
    public T peek(){
        if( tail.get() == null){
            throw new IllegalStateException();
        }
        else{
             return tail.get();
        }
       
    }
    
    public int size(){
        return count;
    }
}
