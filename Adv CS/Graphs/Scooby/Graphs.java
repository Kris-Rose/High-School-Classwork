
import java.io.*;
import java.util.*;
/**
 * main
 *
 * Krista R
 * 4-30-2020
 */
public class Graphs
{
    public static void main(String[] args){

        try{
            Scanner input = new Scanner(new File("scooby.txt"));
            int cases = Integer.parseInt(input.nextLine());
            for(int a = 0; a<cases ;a++){
                String temp = input.nextLine();
                String goal = input.nextLine();

                String[] paths = temp.split(" ");//input with connections
                ArrayList<Vertex> adjLists = new ArrayList<Vertex>(); //store the lists
                ArrayList names = new ArrayList(); // stores individual names and indexes

                //build graph
                for(int b = 0; b<paths.length; b++){
                    String roomOne = paths[b].substring(0,1);
                    Vertex first = new Vertex(roomOne, null);
                    String roomTwo = paths[b].substring(1);
                    Vertex second = new Vertex(roomTwo, null);

                    if( !(names.contains(roomOne))){
                        names.add(roomOne);
                        adjLists.add(first);
                    }
                    if(!(names.contains(roomTwo))){
                        names.add(roomTwo);
                        adjLists.add(second);
                    }

                    int firstNum = names.indexOf(roomOne);
                    int secondNum = names.indexOf(roomTwo);
                    
                    //add the vertexes as neighbors of each other
                    adjLists.get(firstNum).addNeighbor(new Neighbor(secondNum, null)); 
                    adjLists.get(secondNum).addNeighbor(new Neighbor(firstNum, null));
                }

                
                    //check if has a path
                boolean reached = false;
                String start = goal.substring(0,1); //names of start and goal from file
                String end = goal.substring(1);

                int startNum = names.indexOf(start);
                int endNum = names.indexOf(end);

                //checks to make sure to nodes are in the graph to begin with
                if(startNum != -1 && endNum != -1){
                    Neighbor main = adjLists.get(startNum).getNeighbors();
                    ArrayList checked = new ArrayList(); //names of routes already checked
                    checked.add(adjLists.get(startNum));
                    
                    do{
                        //checks all neighbors connected to the main node
                        reached = main.checkAllRoutes(endNum, adjLists, reached, checked);
                        do{
                            if(main.getNext() != null){
                                main = main.getNext();
                            }
                        }
                        while(!reached && checked.contains(adjLists.get(main.getNum()))); 
                        
                    }
                    while(!reached && main.getNext() != null );

                }

                
                if(reached){
                    System.out.println("yes");
                }
                else{
                    System.out.println("no");
                }

            }

        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }

        
    }
}
