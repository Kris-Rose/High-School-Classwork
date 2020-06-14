import java.util.*;
/**
 * 
 * Krista R
 * 4 - 30 - 2020
 */
public class Vertex
{
 
    private String name;
    private Neighbor adjList;
    public Vertex(String name, Neighbor neighbors){
        this.name = name;
        this.adjList = neighbors;
    }

    public String getName(){
        return name;
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
