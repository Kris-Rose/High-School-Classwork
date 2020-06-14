
/**
 * For part 4
 *
 * @Krista R
 * @10/10/19
 */
public class LinkedList
{
    private Node head;
    private int count;
    
    public LinkedList()
    {
        head = null;
        count = 0;
    }
    
    public void add(Object data){
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
            Node current = new Node (data);
            current.setNextPtr(head);
            head = current;
        }
        
        count++;
    }
    
    public Object get(int index){
        Node found = head;
        if(index> count-1){
            return null;
        }
        else if(index == 0){
            return found.get();
        }
        else{
            for(int h = 0;h< index;h++){
                found = found.getNextPtr();
            }
        }
        
        return found.get(); 
    }
    
    
    public int size(){
        return count;
    }
}
