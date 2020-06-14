
/**
 * 
 *
 * @Krista R
 * @10/18/19
 */
public class StackLinkedList<T>
{
    private Node<T> head;
    private int count;
    
    public StackLinkedList()
    {
        head = null;
        count = 0;
    }
    
    public void push(T data){
        if(head == null){
            head = new Node(data); 
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
           //adds at start
           
            Node current = new Node (data);
            current.setNextPtr(head);
            head = current;
        }
        
        count++;
    }
    
    public T peek(){
       return head.get();
    }
    
    public T pop(){
        Node found = head;
        try{
            head = head.getNextPtr();
        
        }
        catch(Exception E){
            
        }
        
        return (T)found.get(); 
    }
    
    
    public int size(){
        return count;
    }
}
