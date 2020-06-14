import java.util.*;
/**
 * 
 * Krista R
 * 4 - 30 - 2020
 */
public class Node
{
 
    private int num;
    private Neighbor adjList;
    boolean fallen;
    public Node(int num, Neighbor neighbors){
        this.num = num;
        this.adjList = neighbors;
        fallen = false;
    }

    public void fall(){
        fallen = true;
    }
    
    public int getNum(){
        return num;
    }

    public Neighbor getNeighbors(){
        return adjList;
    }

    public void addNeighbor(Neighbor nbr){
        if(adjList == null){
            adjList = nbr;
        }
        else{
            Neighbor temp = adjList;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(nbr);
            nbr.setPrev(temp);
        }

    }
}
