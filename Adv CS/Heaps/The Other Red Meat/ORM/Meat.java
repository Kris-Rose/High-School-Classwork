
/**
 * decide which goat dies yes that is literally the assignment
 *
 * @Krista. R
 * @2/26/2020
 */
import java.io.*;
import java.util.*;

public class Meat
{
    public static void main(String[] args){
        try{
            Scanner input  = new Scanner(new File("goat.dat"));
            int cases = Integer.parseInt(input.nextLine());
            
            for(int a = 0; a<cases;a++){
                int numGoats = Integer.parseInt(input.nextLine());
                double extraDaysToCheck = 0;
                
                ArrayList< ArrayList<Integer> > goats = new ArrayList< ArrayList<Integer> >();
                //get data
                for(int b = 0;b<numGoats;b++){
                    String[] temp = input.nextLine().split(" ");
                    ArrayList<Integer> values = new ArrayList<Integer>();
                    
                    extraDaysToCheck += temp.length;
                    for(int c = 1; c<temp.length;c++){
                        values.add(Integer.parseInt(temp[c]));
                    }
                    goats.add(values);
                }
                
                //compare
                
                int lastDayEaten = 0;
                int goatsLeft = numGoats;
                
                int day = 1;
                boolean stuck = false;
                while(goatsLeft>0 && stuck == false){
                    int indexToRemove = -1;
                    int count = 0;
                    int smallest = (goats.get(0)).get(0);
                    
                    for(int b = 0;b<goats.size();b++){
                        if((goats.get(b)).get(0) < smallest){
                            indexToRemove = b;
                            smallest = (goats.get(b)).get(0);
                            count = 0;
                            
                        }
                        if((goats.get(b)).get(0) == smallest){
                            if(indexToRemove == -1){
                                indexToRemove = b;
                            }
                            count++;
                        }
                        
                        //change order
                        int temmp = (goats.get(b)).remove(0);
                        (goats.get(b)).add(temmp);
                        
                        
                    }
                    
                    
                    
                    
                    if(indexToRemove != -1 && count == 1){
                        lastDayEaten = day;
                        goatsLeft--;
                        
                        
                        extraDaysToCheck -= goatsLeft;
                        
                        goats.remove(indexToRemove);
                    }
                    if(day-lastDayEaten > extraDaysToCheck){
                        stuck = true;
                    }
                    day++;
                    
                    
                    
                    
                }
                
                
                System.out.println(goatsLeft + " " + lastDayEaten);
                
            }
            
            
        }
        catch(Exception E){
            System.out.println(E);
            E.printStackTrace();
        }
    }
}
