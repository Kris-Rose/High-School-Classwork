import java.util.*;
import java.io.*;
/**
 *trees
 *
 * @Krista R
 * @12-29-19
 */
public class Plant
{
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(new File("plant.dat"));
            while(input.hasNextLine()){
                String next = input.nextLine();
                int numCases = Integer.parseInt(next);
                input.nextLine();
                next = input.nextLine();
                double totalTrees = 0;
                
                for(int i = 0; i<numCases;i++){
                    
                    HashMap forest = new HashMap();
                    ArrayList<String> species = new ArrayList();
                    totalTrees = 0;
                    
                    if(!(species.contains(next))){
                        species.add(next);
                        forest.put(next, 1.0);
                        totalTrees++;
                    }
                    else{
                        double num  = (double)forest.get(next);
                        num += 1.0;
                        forest.put(next, num);
                        totalTrees++;
                    }
                    //next = input.nextLine();
                    //get all species names once and list of projects &&
                    int count = 0;
                    while( !(next.equals(""))  && input.hasNextLine() ){
                        if(count ==  0 && i!= 0){
                            next = input.nextLine();
                            if(!(species.contains(next))){
                                species.add(next);
                                forest.put(next, 1.0);
                                totalTrees++;
                            }
                            else{
                                double num  = (double)forest.get(next);
                                num += 1.0;
                                forest.put(next, num);
                                totalTrees++;
                            }
                        }
                        if(next.equals("")){
                            break;
                        }
                        
                        next = input.nextLine();
                        if(next.equals("")){
                            break;
                        }
                        if(!(species.contains(next))){
                            species.add(next);
                            forest.put(next, 1.0);
                            totalTrees++;
                        }
                        else{
                            double num  = (double)forest.get(next);
                            num += 1.0;
                            forest.put(next, num);
                            totalTrees++;
                        }
                        count++;
                        
                    }
                    
                    Collections.sort(species);
                    
                    double percent = 0;
                    
                    
                    for(int a =0;a<species.size();a++){
                        double temp = (double)forest.get(species.get(a));
                        percent = (((double)forest.get(species.get(a)))/totalTrees)*100;
                        //format percent
                        System.out.println(species.get(a) + " " + String.format("%.4f", percent) );
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    if(input.hasNextLine()){
                        
                        next = input.nextLine();
                        
                    }
                    
                    System.out.println();
                    
                }
                
                
                
                
            }
            
            
            
        }
        catch(Exception E){
            E.printStackTrace();
            System.out.println(E);
        }
    }

    
}
