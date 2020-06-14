import java.util.*;
import java.io.*;
/**
 * add columns of trees
 *
 * Krista R.
 * 1/31/20
 */
public class RAKE
{
    public static void main(String arg[]){
        try{
            Scanner input = new Scanner(new File("rake.dat"));
            
            String tree = "";
            int blah = 1;
            while(!(tree.equals("-1")) && blah< 3){
                tree = input.nextLine(); 
                System.out.println("Case " + blah + ":");
                blah++;
                
                String[] tem = tree.split(" ");
                int[] oak = new int[tem.length];
                for(int a = 0; a<oak.length;a++){
                   oak[a] = Integer.parseInt(tem[a]); 
                }
                
                Node root = new Node(oak[0]);
                Node temp = root;
                int[] index = new int[1];
                index[0] = 1;
                //builds the tree
                temp.addLeft(index, oak, temp);
                    
                
                
                /*
                for(int b = 1;b<oak.length;b++){
                    temp.setLeft(oak[b]);
                    temp = temp.getLeft();
                    if(oak[b] == -1){
                        temp = temp.getParent();
                        b++;
                        if(b<oak.length && oak[b] != -1){
                            temp.setRight(oak[b]);
                            temp = temp.getLeft();
                        }
                        
                    }
                    
                }
                */
                
                int[] columns = new int[oak.length];
                index[0] = columns.length/2;
                
                columns[index[0]] = temp.getData();
                int[] teb = new int[1];
                teb[0] = 1;
                temp.RackeLeft(index, columns, temp, teb, oak);
                
                
                
                
                for(int a = 0;a<columns.length;a++){
                    if(columns[a] != 0){
                        System.out.print(columns[a] + " ");
                    }
                    
                }
             
                System.out.println();
               System.out.println();
            }
            
            
            
            
            
            
            
            
            
            
            
            
        }
        catch(Exception E){
            E.printStackTrace();
            System.out.print(E);
        }
        
        
    }
}
