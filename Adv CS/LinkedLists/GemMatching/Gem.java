import java.awt.*;
import java.util.*;


enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
    
    public static GemType getRandomColor() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
    
}

public class Gem 
{   
    private GemType type;
    private int points;
    public Gem(){
        this.type = GemType.getRandomColor();
        Random random = new Random();
        points = random.nextInt(51);
        points = points - (points%5);
        //get points randomly
    }
    public Gem gemClone() throws  CloneNotSupportedException 
    { 
        return (Gem)super.clone(); 
    }
    public Gem(GemType type, int points){
        this.type = type;
        this.points= points;
    }
    
    public String toString(){
        String output =  type + " " + points + ", ";
        return output;
    }
    
    GemType getType(){
        return type;
    }
    
    int getPoints(){
        return points;
    }
    
    void draw(double x, double y){
        //get filename with switch statements
        String filename = "";
        switch(type){
            case GREEN:
                filename = "gem_green.png";
                break;
            case BLUE:
                filename = "gem_blue.png";
                break;
            case ORANGE:
                filename = "gem_orange.png";
                break; 
            default:
            
        }
        StdDraw.picture(x,y,filename);
        StdDraw.setPenColor(Color.WHITE );  
        StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
        String value = "" + points ;
        StdDraw.text(x, y, value);
    }
    
    
    /** Tester main method */
    public static void main(String [] args)
    {
      final int maxGems = 16;
      
      // Create a gem of each type
      Gem green  = new Gem(GemType.GREEN, 10);
      Gem blue   = new Gem(GemType.BLUE, 20);
      Gem orange = new Gem(GemType.ORANGE, 30);
      System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());        
      System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
      System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
      green.draw(0.3, 0.7);
      blue.draw(0.5, 0.7);
      orange.draw(0.7, 0.7);
      
      // A row of random gems
      for (int i = 0; i < maxGems; i++)
      {
          Gem g = new Gem();
          g.draw(1.0 / maxGems * (i + 0.5), 0.5);
      }
    }
}
