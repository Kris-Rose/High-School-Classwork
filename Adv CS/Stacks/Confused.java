import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * comparing parentheses
 *
 * Krista Roberts
 * 8/30/19
 */
public class Confused
{
    public static void main(String[] args){
        ArrayStack<String> holder = new ArrayStack();
        try{
            Scanner input = new Scanner( new File("confused.txt"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"));
            
            int numLines = 0;
            numLines = input.nextInt();
            input.nextLine();
            boolean valid = false;
            boolean errorThrownOrOutOfOrder = false;
            
            while(input.hasNextLine()){
                for(int i = 0; i<numLines; i++){
                    String line = (input.nextLine());
                    holder.clear();
                    valid = false;
                    errorThrownOrOutOfOrder = false;
                    
                    String[] values = line.split("");
                    for(int j = 0; j<values.length; j++){
                        holder.push(values[j]);
                    }
                        
                    int numOpenParen = 0;
                    int numOpenBrack = 0;
                    int numClosedParen = 0;   
                    int numClosedBrack = 0;   
                    
                    String single = "";
                    while(holder.isEmpty() == false){
                          try{
                            single = holder.pop();
                        }
                        catch(Exception e){
                            System.out.println(e);
                            errorThrownOrOutOfOrder = true;
                            break;
                        } 
                      
                        switch(single){
                          case "(":
                              numOpenParen++;
                              break;
                          case ")":
                              numClosedParen++;
                              break;    
                          case "[":
                              numOpenBrack++;
                              break;    
                          case "]":
                              numClosedBrack++;
                              break;  
                          case " ":
                              break;   
                          case "":
                              break;
                          default:
                                //writer.write("Invalid Input" +"\n");
                                System.out.println("Invalid Input");
                          
                        }
                        
                        //closed should be greater than open because we're reading the code backwards from the stack
                        if(numClosedParen < numOpenParen || numClosedBrack < numOpenBrack){
                           errorThrownOrOutOfOrder = true;
                        }
                        
                              
                    }
                    
                    if(numOpenParen == numClosedParen && numOpenBrack ==numClosedBrack){
                        valid = true;
                    }
                    
                    if(errorThrownOrOutOfOrder == false && valid == true){
                        //writer.write("Yes" + "\n");
                        System.out.println("Yes");
                    }
                    else if(errorThrownOrOutOfOrder == true || valid == false){
                        //writer.write("No \n");
                        System.out.println("No");
                    }
                    
                }
                
                
                
                
            }
            //writer.close();
        
        
         }
        catch(Exception e){
            System.out.println("Exception" + e);
        }    
     
    }
}
