import java.util.*;
import java.io.*;
/**
 * count symmetry
 *
 * Krista R
 * 1/29/2020
 */
public class TREE
{
    public static final void main(String arg[]) throws IOException{
        //try{
        Scanner input = new Scanner(new File("righttree.dat"));
        int numTrees = Integer.parseInt(input.nextLine());
        for(int a = 0;a<numTrees;a++){
            //set up tree array
            String temp = input.nextLine();
            String[] meh = temp.split("");
            int[] tree = new int[meh.length];
            for(int b = 0;b<tree.length;b++){
                tree[b] = Integer.parseInt(meh[b]);
            }

            int numLeft = 0;
            int numRight = 0;
            boolean right = true;
            if(tree.length == 1){
                System.out.println("Tree " + (a+1) + " is a right-tree"); 
            }
            else{

                //check every node
                for(int c = 0; c<tree.length; c++){
                    numLeft = 0;
                    numRight = 0;

                    //hard code for c= 0 bc multipying by 0 messes it up
                    if(c == 0){
                        //check if has left or right
                        if((tree.length>= (2)) && tree[1] == 1){
                            numLeft++;
                        }
                        if((tree.length>= (3)) && tree[2] == 1){
                            numRight++;
                        }
                        //check lefts (if left node has a left or a right)
                        if((tree.length>= ((2)*2)) && tree[3] == 1){
                            numLeft++;
                        } 
                        if((tree.length>= ((2)*2+1)) && tree[4] == 1){
                            numLeft++;
                        } 
                        //check rights (if right node has a left or a right)
                        if((tree.length>= (6)) &&tree[5] == 1){
                            numRight++;
                        }
                        if((tree.length>= (7)) &&tree[6] == 1){
                            numRight++;
                        }

                            
                    }
                    else{
                        //check if has left or right
                        int d = (c+1);
                        if((tree.length>= (d*2)) && tree[(d*2)-1] == 1){
                            numLeft++;
                        } 
                        int tep = (d*2+1);
                        if((tree.length>= (d*2+1)) && tree[(d*2)] == 1){
                            numRight++;
                        } 
                        //check lefts (if left node has a left or a right)
                        if((tree.length>= ((d*2)*2)) && tree[((d*2)*2)-1] == 1){
                            numLeft++;
                        } 
                        if((tree.length>= ((d*2)*2+1)) && tree[(d*2)*2] == 1){
                            numLeft++;
                        } 
                        //check rights (if right node has a left or a right)
                        if((tree.length>= ((d*2+1)*2)) &&tree[((d*2+1)*2)-1] == 1){
                            numRight++;
                        }
                        if((tree.length>= ((d*2+1)*2 +1)) &&tree[((d*2+1)*2)] == 1){
                            numRight++;
                        }

                    }

                        
                        
                    /*
                    //check every node's left branches
                    for(int d = c;d < tree.length;d++){

                    }
                    //check every node's right branches
                    for(int d = c;d < tree.length;d++){

                    }
                     */

                    if(numRight<numLeft){
                        right = false;
                    }
                }

                if(right){
                    System.out.println("Tree " + (a+1) + " is a right-tree"); 
                }
                else{
                    System.out.println("Tree " + (a+1) + " is not a right-tree"); 
                }

            }

                
                
        }
        // }
        // catch(Exception E){
        // E.printStackTrace();
        // System.out.print(E);
        // }

    }
    
}
