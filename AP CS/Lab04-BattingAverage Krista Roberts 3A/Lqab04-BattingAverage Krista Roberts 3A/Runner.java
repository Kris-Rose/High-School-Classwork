import java.util.*;
import java.io.*;
//4
public class Runner{
    public static void main(String[] args) throws IOException{
        
        try{
            Scanner test = new Scanner(new File("players.txt"));
            
            int p = 0;
            boolean gotIt = false;
            while(test.hasNext() && gotIt == false){
                if(test.hasNextInt()){
                    p = test.nextInt();
                    gotIt = true;
                }
            }
            Team liberty = new Team(p);
           
            while(test.hasNext()){
                for(int a = 0; a<liberty.teamLength();a++){
                    
                    String name = test.next();
                    int number = test.nextInt();
                    int atBats = test.nextInt();
                    int hits = test.nextInt();
                    liberty.addPlayer(new Player(name, number, atBats, hits), a);
                }
            
            
            }
        
        
            liberty.printTeamStats();
        }
        catch(FileNotFoundException e){
            System.out.println("\n players.txt is not accessable in this folder. Please check the file name and location.\n" + e );
        }
        
        
        int[] nums = {1, 3, 5, 4, 7, 4, 5};
            System.out.println(Arrays.toString(fix45(nums)));
        
        
            
            
        }
    static int[] fix45(int[] nums){   
        int[] fixed = new int[nums.length];
        int fours = 0;
        int fives = 0;
        int count = 0;
        int tempcount = 0;
        int[] temps = new int[nums.length];
        for (int a: nums){
            if(a == 4){
                fours++;
                fixed[count] = nums[count];
                fixed[count+1] = 5;
                if(nums[count+1]!= 5){
                    temps[tempcount] = nums[count+1];
                    tempcount++;
                }
            }
            if(a == 5){
                fives++;
            }
            count++;
        }
         System.out.println(Arrays.toString(fixed));
        
        count = 0;
        if(fours == fives){
            for(int b : nums){
                if(b == 4){
                    
                    count++;
                    
                }
                else{
                      if (b == 5){
                          count++;
                        }
                      else{
                          if(fixed[count] == 4 || fixed[count] == 5){
                              count++;
                            }
                            else{
                              fixed[count] = nums[count]; 
                              count++;  
                            }
                        }
                    
                }
            }
            
            count = 0;
            tempcount = 0;
            for(int c: fixed){
                if(c == 0){
                    fixed[count] = temps[tempcount];
                    tempcount++;
                }
                count++;
                
            }
            
            
            
            
            return fixed;
        }
        else{
            System.out.println("Error: Your array must have an equal number of 4s and 5s.");
            return nums;
        }
        
    }
    }
    
    

