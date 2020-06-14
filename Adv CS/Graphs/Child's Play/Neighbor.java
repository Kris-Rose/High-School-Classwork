import java.util.*;
/**
 * list af all nodes that connect to main node
 *
 * Krista R
 * 4-30-2020
 */
public class Neighbor
{
    private int num;
    private Neighbor next;
    private Neighbor prev;
    private int weight;

    public Neighbor(int vnum, Neighbor next)
    {
        num = vnum;
        this.next = next;
    }

    public int getNum(){
        return num;
    }

    public Neighbor getNext(){
        return next;
    }
    
    public boolean hasNext(){
        if(next != null){
            return true;
        }
        else{
            return false;
        }
    }

    public void setNext(Neighbor next){
        this.next = next;
    }

    public void setPrev(Neighbor prev){
        this.prev = prev;
    }

    
}
