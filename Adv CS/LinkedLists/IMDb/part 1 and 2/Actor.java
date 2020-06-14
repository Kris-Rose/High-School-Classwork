
/**
 * 
 *for part 1 and 2
 * @Krista R
 * @10/4/19
 */
public class Actor
{
    // instance variables - replace the example below with your own
    private String name;
    private Actor next;

    public Actor()
    {
        name = null;
        next = null;
    }

    public Actor(String name)
    {
        this.name = name;
        next = null;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
         this.name = name;
    }
    
    public Actor getNextPtr(){
         return next;
    }
    
    public void setNextPtr(Actor next){
         this.next = next;
    }
    
    public String toString(){
        return name;
    }
}
