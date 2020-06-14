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
            Scanner input = new Scanner(new File("Sample Data Part 1 - Array Size 101 .txt"));
            HashTable container = new HashTable(101);
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
