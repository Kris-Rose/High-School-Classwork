import java.io.*;
import java.util.*;
/**
 * Find how many dominos were hand pushed
 *
 * @Krista R
 * @5-7-2020
 */
public class Main
{
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(new File("playJudgeCase1.dat"));
            int cases = Integer.parseInt(input.nextLine());
            for(int a = 0; a<cases ;a++){
                String[] temp = input.nextLine().split(" ");
                int numTiles = Integer.parseInt(temp[0]);
                int domConnections = Integer.parseInt(temp[1]);
                int handKnocked = Integer.parseInt(temp[2]);
                int fallen = 0;
                
                //building graph
                Node[] doms = new Node[numTiles];//build Nodes
                for(int c = 0; c<numTiles;c++){
                    doms[c] = new Node(c+1, null);
                } 
                for(int b = 0; b<domConnections;b++){//build connections
                    String[] te = input.nextLine().split(" ");
                    doms[Integer.parseInt(te[0])-1].addNeighbor(new Neighbor(Integer.parseInt(te[1]),null));
                }
                
                //put starting doms/nodes in an array
                int[] starters = new int[handKnocked];
                for(int e = 0; e<handKnocked;e++){
                    starters[e] = Integer.parseInt(input.nextLine());
                }
                
                
                //traversing with depth-first search
                ArrayStack<Integer> depthSearch = new ArrayStack<Integer>();
                boolean[] visited = new boolean[numTiles];
                for(int d = 0; d<handKnocked;d++){
                    if(!(visited[starters[d]-1] == true)){ //if the domino im knocking over hasn't already been knocked
                        depthSearch.push(starters[d]);
                        visited[starters[d]-1] = true;
                        fallen++;
                        
                        while(depthSearch.size() != 0){
                            int numChecking = depthSearch.peek();
                            Neighbor adjs = doms[numChecking-1].getNeighbors();
                            while(adjs != null){//adds all of adjacent nodes to stack
                                if(visited[adjs.getNum()-1] == false){ //only adds to stack if haven't already been there
                                    depthSearch.push(adjs.getNum());
                                    visited[adjs.getNum()-1] = true;
                                    fallen++;
                                    
                                }
                                adjs = adjs.getNext();
                            }
                            
                            //if have seen all of the node on top of stack's neighbors, remove from stack
                            Neighbor shouldHaveSeen = doms[depthSearch.peek()-1].getNeighbors();
                            boolean doneWithNode = true;
                            while(shouldHaveSeen != null ){//adds all of adjacent nodes to stack
                                if(visited[shouldHaveSeen.getNum()-1] == false){ //only moves of if hasn't seen all numbers
                                    doneWithNode = false;
                                    break;//dont need to continue cheaking and waste time
                                }
                                shouldHaveSeen = shouldHaveSeen.getNext();
                            }
                            if(doneWithNode){
                                numChecking = depthSearch.peek();
                                depthSearch.pop();
                            }
                        }
                        
                        
                    }
                }
                
                
                
                System.out.println(fallen);
            }
            
        }
        catch(Exception E){
            System.out.println(E);
            E.printStackTrace();
        }
        
    }
}
