
/**
 * For part 2
 *
 * @Krista R
 * @10/8/19
 */
public class ActorLinkedList
{
    private Actor head;
    private int count;
    
    public ActorLinkedList()
    {
        head = null;
        count = 0;
    }
    
    public void add(Actor actor){
        if(head == null){
            head = actor; 
        }
        else{
            Actor current = head;
            while(!(current.getNextPtr() == null)){
               current = current.getNextPtr();   
            }
            current.setNextPtr(actor);
        }
        
        count++;
    }
    
    public Actor get(int index){
        Actor found = head;
        if(index> count-1){
            return null;
        }
        else if(index == 0){
            return found;
        }
        else{
            for(int h = 0;h< index;h++){
                found = found.getNextPtr();
            }
        }
        
        return found; 
    }
    
    
    public int size(){
        return count;
    }
}
