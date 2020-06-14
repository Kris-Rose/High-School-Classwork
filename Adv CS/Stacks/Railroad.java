import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * 
 *
 * @Krista Roberts
 * 
 * @9/4/19
 */
public class Railroad
{
    public static void main(String[] args){
        ArrayStack<Integer> holder = new ArrayStack();
        try{
            Scanner input = new Scanner( new File("railroad.txt"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("railroadOutput.txt"));
             boolean cont = true;
            int zeroCount = 0;
            int trainLength = input.nextInt();
            input.nextLine();
            
            while(input.hasNextLine()){
                while(cont){
                    String line = (input.nextLine());
                    boolean canOrder = true;
                    if(line.equals("0")){
                        zeroCount++;
                        //writer.write("\n");
                        System.out.println("");
                        
                        if(input.hasNextLine()){
                            trainLength = input.nextInt();
                            if(trainLength == 0){
                                zeroCount++;
                            }
                            if(input.hasNextLine()){
                                
                                input.nextLine();
                            }
                            
                        }
                        
                        
                    }
                    else{
                            String[] expectedString = line.split(" ");
                        //input
                        int[] expected = new int[trainLength];
                        for(int j = 0; j<expected.length;j++){
                            expected[j] = Integer.parseInt(expectedString[j]);
                        }
                        
                        
                        
                        holder.clear();
                        //b4 manipulated
                        int[] train = new int[trainLength];
                        for(int i = 0; i<trainLength;i++ ){
                            train[i] = i+1;
                        }
                        //after manipulated
                        int[] finished = new int[trainLength];
                        
                        int indexPush = 0;
                        int indexPop = 0;
                        int finishedLength = 0;
                        // to keep track of numbers
                        ArrayList<Integer> inStack = new ArrayList<Integer>();
                       
                        
                        //look for top and pop
                        while(finished[trainLength-1] == 0 && finishedLength<finished.length){
                            int toLookFor = expected[finishedLength];
                            
                            //check if already in stack(delete if dosn't work)
                            if(!holder.isEmpty() && inStack.indexOf(toLookFor) != -1){
                                //if first value in array
                                if(holder.peek() == toLookFor){
                                    finished[indexPop] = holder.pop();
                                    inStack.remove((Object)finished[indexPop]);
                                    indexPop++;
                                    finishedLength++;
                                }
                                else{
                                   while(holder.peek() != toLookFor){
                                      finished[indexPop] = holder.pop();
                                      inStack.remove((Object)finished[indexPop]);
                                      indexPop++;
                                      finishedLength++;
                                   } 
                                }
                                
                                
                                
                                
                            }
                            else{
                                
                                int toPop = 0;
                                //find how many numbers to pop
                                do{
                                    toPop++;
                                }
                                while(expected[toPop-1]>expected[toPop] && toPop<trainLength-2);
                                //find how many to push

                                int toPush =0;
                                
                                
                                
                                if(indexPush<expected.length){
                                    toPush =1;
                                    
                                    
                                    while(train[toPush-1 + indexPush] != toLookFor && (toPush+indexPush<expected.length ) ){
                                        toPush++;
                                    }    
                                }
                                
                                
                                
                                for(int pushed = 1; pushed<=toPush && indexPush<expected.length; pushed++){
                                    inStack.add(train[indexPush]); 
                                    holder.push(train[indexPush]);
                                    indexPush++;
                                }
                                for(int popped =1; popped<=toPop && holder.isEmpty() == false; popped++){
                                    finished[indexPop] = holder.pop();
                                    inStack.remove((Object)finished[indexPop]);
                                    indexPop++;
                                    finishedLength++;
                                }
                                
                            
                            }
                            
                            
                            
                            
                        }
                         
                        
                        
                        //check if ordered properly
                        for(int k = 0; k<trainLength;k++){
                           if(canOrder){
                                   if(expected[k] == finished[k]){
                                    canOrder = true;
                                }
                                else{
                                    canOrder = false;
                                }
                            }
                        }
                        if(canOrder){
                            System.out.println("Yes");
                            zeroCount =0;
                            //writer.write("yes" + "\n");
                        }
                        else{
                            System.out.println("No");
                            //writer.write("no" + "\n");
                        }
                        
                        
                    
                    }
                    
                    //break if two zeros and check if can order
                    if(zeroCount >= 2){
                        cont = false;
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
