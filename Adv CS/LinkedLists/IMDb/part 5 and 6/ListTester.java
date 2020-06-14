import java.util.*;
import java.io.*;
/**
 * To test LinkedList for part 5 and 6
 *
 * @Krista R
 * @10/10/19
 */
public class ListTester
{
    public static void main(String args[]){
        //5
        LinkedList hollywood = new LinkedList();
        try{
            Scanner reader = new Scanner(new File("actors.txt"));
            
            while(reader.hasNextLine()){
                hollywood.add(new Actor(reader.nextLine()));
            }
            
            for(int a = 0; a<hollywood.size(); a++){
                System.out.println(hollywood.get(a).toString());
            }
            System.out.println("\n" + ((Actor)hollywood.get(0)).getName());
        }
        catch(Exception E){
            
        }
        
        //6
        LinkedList movies = new LinkedList();
        Movie spiderman = new Movie("Spiderman");
        Movie avengers = new Movie("Avengers");
        Movie toyStory = new Movie ("Toy Story");
        Movie thePrincessBride = new Movie("The Princess Bride");
        Movie forrestGump = new Movie("Forrest Gump");
        
        movies.add(spiderman);
        movies.add(avengers);
        movies.add(toyStory);
        movies.add(thePrincessBride);
        movies.add(forrestGump);
        
        for(int a = 0; a<movies.size(); a++){
                System.out.println(movies.get(a).toString() + "\n");
            }
        System.out.println( ((Movie)movies.get(0)).getTitle());    
            
            
    }   
}
