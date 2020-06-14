
/**
 * 
 *for part 3
 * @Krista R
 * @10/8/19
 */
public class Node<T>
{
    // instance variables - replace the example below with your own
    private T data;
    private Node next;
    private Node prev;

    public Node()
    {
        data = null;
        next = null;
    }

    public Node(T data)
    {
        this.data = data;
        next = null;
    }
    
    public T get(){
        return data;
    }
    
    public void set(T data){
         this.data = data;
    }
    
    public Node getNextPtr(){
         return next;
    }
    
    public void setNextPtr(Node next){
         this.next = next;
    }
    
    public Node getPrevPtr(){
         return prev;
    }
    
    public void setPrevPtr(Node prev){
         this.prev = prev;
    }
    
    public String toString(){
        return data.toString();
    }
}
