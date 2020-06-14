import java.util.*;
import java.io.*;
/**
 *
 *
 * @Krista R
 * @10-15-19
 */
public class IMDb
{
    public static void main(String[] args){
        //reading Actor List
        LinkedList hollywood = new LinkedList();
        try{
            Scanner reader = new Scanner(new File("actors.txt"));
            
            while(reader.hasNextLine()){
                hollywood.add(new Actor(reader.next() + " "+ reader.next()));
            }
            //printing
            
            for(int a = 0; a<hollywood.size(); a++){
                System.out.println(hollywood.get(a).toString());
            }
            System.out.println("\n" + ((Actor)hollywood.get(0)).getName());
            
        }
        catch(Exception E){
            
        }
        
        //reading Movie List
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
            
            //printing
            /*
            for(int a = 0; a<movies.size(); a++){
                System.out.println(movies.get(a).toString() + "\n");
            }
            System.out.println( ((Movie)movies.get(0)).getTitle());  
            */
        }
        catch(Exception E){
            System.out.println(E);
        } 
        
        //traversing actor list
        for(int a = 0; a<hollywood.size(); a++){
            System.out.println(hollywood.get(a).toString());
            Actor main = (Actor)hollywood.get(a);
            for(int b = 0; b<movies.size(); b++){
                LinkedList actors = ((Movie)movies.get(b)).getActors();
                for(int c = 0; c<actors.size(); c++){
                    
                    Actor comparing = (Actor)actors.get(c);
                    if((((Actor)actors.get(c)).getName()).equals( ((Actor)hollywood.get(a)).getName() )){
                        System.out.println("\t" + ((Movie)movies.get(b)).getDate() + " " + ((Movie)movies.get(b)).getTitle());
                    }
                    
                }
            }
                
                
        }
        
    }
}
