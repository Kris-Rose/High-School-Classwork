import java.util.*;
import java.io.*;
/**
 * To test LinkedList
 *
 * @Krista R
 * @10/10/19
 */
public class ListTester
{
    public static void main(String args[]){
        
        
        
        StackLinkedList movies = new StackLinkedList();
        String spiderman = new String("Spiderman");
        String avengers = new String("Avengers");
        String toyStory = new String ("Toy Story");
        String thePrincessBride = new String("The Princess Bride");
        String forrestGump = new String("Forrest Gump");
        
        movies.push(spiderman);
        movies.push(avengers);
        movies.push(toyStory);
        movies.push(thePrincessBride);
        movies.push(forrestGump);
        
        for(int a = 0; a<movies.size()-1; a++){
                System.out.println(movies.pop().toString() + "\n");
            }
        System.out.println( (String)movies.pop());    
        System.out.println();
        
        
        
        QueueLinkedList media = new QueueLinkedList();
        media.queue(spiderman);
        media.queue(avengers);
        media.queue(toyStory);
        media.queue(thePrincessBride);
        media.queue(forrestGump);
        
        for(int a = 0; a<media.size()-1; a++){
                System.out.println(media.dequeue().toString() + "\n");
            }
        System.out.println( (String)media.dequeue());  
    }   
}
