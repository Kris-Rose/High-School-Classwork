
/**
 * for part 6
 *
 * @Krista R.
 * @10/10/19
 */
public class Movie
{
    private int date;
    private String title;
    private LinkedList actors;
    private LinkedList directors;
    
    public Movie()
    {
       date = -1;
       title = ""; 
       directors = null;
       actors = null; 
    }
    
    public Movie(String title)
    {
       date = -1;
       this.title = title; 
       directors = null;
       actors = null; 
    }
    
    public Movie(int date, String title, LinkedList actors, LinkedList directors)
    {
        this.date = date;
        this.title = title;
        this.actors = actors;
        this.directors = directors;
    }
    
    public int getDate(){
        return date;
    }
    
    public void setdate(int date){
        this.date = date;
    }

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public LinkedList getActors(){
        return actors;
    }
    
    public void setActors(LinkedList actors){
        this.actors = actors;
    }
    
    public LinkedList getDirectors(){
        return directors;
    }
    
    public void setDirectors(LinkedList directors){
        this.directors = directors;
    }
    
    public String toString(){
        String toPrint = ("Name: " + title + "\nRelease Date: " + date);
        if(actors == null){
            toPrint += ("\nActors: none" );
        }
        else{
            toPrint += ("\nActors: " + actors.toString() );
        }
        
        if(directors == null){
            toPrint += ("\nDirectors: none");
        }
        else{
            toPrint += ("\nDirectors:" + directors.toString()  );
        }
        
        return (toPrint);
    }
    
}
