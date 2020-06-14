import java.util.*;
import java.io.*;
/**
 * Find cost of adding
 *
 * @Krista R
 * @3/5/2020
 */
public class MathCosts
{
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(new File("mathCosts.dat"));
            int toAdd = Integer.parseInt(input.nextLine() );
            while(toAdd != 0 && !input.hasNextLine()){
               int totalCost = 0; 
               int total = 0;
               PriorityQueue container = new PriorityQueue();
               
               String[] temp = input.nextLine().split(" ");
               int[] tem = new int[temp.length];
               for(int a = 0; a<temp.length; a++){
                   tem[a] = Integer.parseInt(temp[a]);
                }
               for(int b = 0; b<tem.length;b++){
                   container.add(tem[b]);
                }
               total = (int)(container.peek());
               container.remove();
               total += (int)(container.peek());
               container.remove();
               totalCost = total;
               
               
               while(container.size() != 0){
                   total += (int)(container.peek());
                   container.remove();
                   totalCost += total;
                   
               }
                
                
                
                
               System.out.println(totalCost);
               toAdd = Integer.parseInt(input.nextLine() );
            }
            
        
        }
        catch(Exception E){
            
        }
        
    }
}
