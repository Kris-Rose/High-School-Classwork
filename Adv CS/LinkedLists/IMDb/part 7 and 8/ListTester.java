import java.util.*;
import java.io.*;
/**
 * To test LinkedList for part 5 and 6 and 7
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
        /*LinkedList movies = new LinkedList();
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
            */
        //7
        LinkedList movies = new LinkedList();
        try{
            Scanner reader = new Scanner(new File("movies.txt"));
            while(reader.hasNextLine()){
                Scanner movie = new Scanner(reader.nextLine());
                int date = movie.nextInt();
                
                String title = "";
                String nextOne = movie.next();
                String nextTwo = movie.next();
                String nextThree = movie.next();
                while(!(nextTwo.substring(nextTwo.length()-1).equals(",")) && !(nextOne.substring(nextOne.length()-1).equals(",")) ){
                    if(!nextThree.substring(nextThree.length()-1).equals(",")){
                        title += (nextOne + " " + nextTwo+ " ");
                    }
                    else{
                        title += (nextOne + " " );
                    }
                    
                    
                    nextOne = nextThree;
                    
                    if(nextOne.substring(nextOne.length()-1).equals(",")){
                        break;
                    }
                    nextTwo = movie.next();
                    nextThree = movie.next();
                }
                
                
                LinkedList actors = new LinkedList();
                String firstName = "";
                if(nextTwo.substring(nextTwo.length()-1).equals(",")){
                    actors.add(new Actor( (nextOne + " " + nextTwo.substring(0,nextTwo.length()-1)) ) );
                    firstName = nextThree;
                }
                else{
                    actors.add(new Actor( (nextTwo + " " + nextOne.substring(0,nextOne.length()-1)) ) );
                    firstName = movie.next();
                }
                
                while(!firstName.equals("Dir:")){
                    
                    String secondName = movie.next();
                    
                    if(secondName.substring(secondName.length()-1).equals(",")){
                        actors.add( new Actor( firstName + " " + secondName.substring(0, secondName.length()-1)  )  );
                    }
                    else{
                        actors.add( new Actor( firstName + " " + secondName)  );
                    }
                    
                    firstName = movie.next();
                }
                
                
                firstName = "";
                LinkedList directors = new LinkedList();
                while(movie.hasNext()){
                    firstName = movie.next();
                    String secondName = movie.next();
                    
                    if(secondName.substring(secondName.length()-1).equals(",")){
                        directors.add( new Actor( firstName + " " + secondName.substring(0, secondName.length()-1)  )  );
                    }
                    else{
                        directors.add( new Actor( firstName + " " + secondName)  );
                    }
                }
                movies.add( new Movie(date,title,actors, directors));
                
                
            }
            
            for(int a = 0; a<movies.size(); a++){
                System.out.println(movies.get(a).toString() + "\n");
            }
            System.out.println( ((Movie)movies.get(0)).getTitle());  
        }
        catch(Exception E){
            System.out.println(E);
        } 
        
        
        
    }   
}
