import java.util.*;
/**
 * basically the node class
 *
 * Krista R
 * 4-30-2020
 */
public class Neighbor
{
    private int vertexNum;
    private Neighbor next;
    private Neighbor prev;
    private int weight;

    public Neighbor(int vnum, Neighbor next)
    {
        vertexNum = vnum;
        this.next = next;
    }

    public int getNum(){
        return vertexNum;
    }

    public Neighbor getNext(){
        return next;
    }

    public void setNext(Neighbor next){
        this.next = next;
    }

    public void setPrev(Neighbor prev){
        this.prev = prev;
    }

    public boolean checkAllRoutes(int end, ArrayList vertexes, boolean found, ArrayList seen){
        if(vertexNum == end){
            found = true;
            return true;
        }
        if(!(seen.contains(vertexes.get(vertexNum))) && !found){ //seen doesn't gontain the node we just entered
            seen.add(vertexes.get(vertexNum));

            String toSeeWhereIAm = ((Vertex)(vertexes.get(vertexNum))).getName();
            //if found stop else can cont.
            if(found ){
                return found;
            }
            else{
                Neighbor nbrs = ((Vertex)(vertexes.get(vertexNum))).getNeighbors();
                do{
                    
                    if(!(seen.contains(vertexes.get(nbrs.getNum())))){ //if haven't already checked this path
                        found = nbrs.checkAllRoutes( end, vertexes, found, seen);
                    }
                    nbrs = nbrs.getNext();
                    //checks all routes for a specific neighbor
                   
                }while (nbrs != null && !found); //nbrs.getNext() != null && !found
            }
            
        }//doesn't need an else bc if it has seen it it just finishes the method
         
        return found;
    }
}
