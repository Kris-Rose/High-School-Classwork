import java.util.*;
import java.io.*;
/**
 *sideways tree
 *
 * @Krista R
 * @2-12-2020
 */
public class Pretty
{
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(new File("pretty.txt"));
            String tree = input.nextLine();
            String[] temp = tree.split(", ");
            double[] trea = new double[temp.length];
            for(int a = 0;a<temp.length;a++){
                trea[a] = Double.parseDouble(temp[a]);
            }
            
            //builds the tree
            Node root = new Node(trea[0]);
            if(trea.length == 0){
                System.out.println("Empty Tree");
            }
            else{
                for(int b = 1;b<trea.length;b++){
                    int[] depth = new int[1];
                    depth[0] = 1;
                    root.add(trea[b], root, depth);
                }
            }
             
            //sorts tree
            root.printSideways(root);
            System.out.println();
            
            ArrayList inOrder = root.inOrder();
            System.out.println("In order: " + inOrder);
            
        }
        catch(Exception E){
            E.printStackTrace();
            System.out.print(E);
            
        }
        
        
        
        
    }
}
