
/**
 * 
 *for part 3
 * @Krista R
 * @10/8/19
 */
public class Actor
{
    // instance variables - replace the example below with your own
    private String name;

    public Actor()
    {
        name = null;
    }

    public Actor(String name)
    {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
         this.name = name;
    }
    
    public String toString(){
        return (String)name;
    }
}
