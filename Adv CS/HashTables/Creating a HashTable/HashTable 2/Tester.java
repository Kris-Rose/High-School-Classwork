import java.util.*; 
import java.io.*; 
/**
 * Write a description of class tester here.
 *
 * @Krista R
 * @11/13/19
 */
public class Tester
{
    public static void main(String[] args){
       
        try{
            Scanner input = new Scanner(new File("1 - put 50 items.txt"));
            HashTable container = new HashTable(101);
            while(input.hasNext()){
                int key = Integer.parseInt(input.next());
                String value = input.next() + " " + input.next();
                container.put(key, value);
            }
            
             
            input = new Scanner(new File("2 - remove 10 items.txt")); 
            while(input.hasNext()){
                int key = Integer.parseInt(input.next());
                String value = input.next() + " " + input.next();
                container.remove(key);
            }
            
            
            input = new Scanner(new File("3 - put (overwriting) 5 items.txt")); 
            while(input.hasNext()){
                int key = Integer.parseInt(input.next());
                String value = input.next() + " " + input.next();
                container.put(key, value);
            }
            
            input = new Scanner(new File("4 - put 10 items.txt")); 
            while(input.hasNext()){
                int key = Integer.parseInt(input.next());
                String value = input.next() + " " + input.next();
                container.put(key, value);
            }
            System.out.println(container.toString());
            
            
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        
        
        
        
       
    }
}
