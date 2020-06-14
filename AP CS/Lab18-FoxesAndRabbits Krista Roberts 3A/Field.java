import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field
{    
    private int depth, width;
    private Object[][] field;
    private ArrayList animals;

    /**
     * Represent a field of the given dimensions.
     * @param depth The depth of the field.
     * @param width The width of the field.
     */
    public Field(int depth, int width)
    {
        this.depth = depth;
        this.width = width;
        field = new Object[depth][width];
        animals = new ArrayList();
    }

    /** Empty the field */
    public void clear()
    {
        
        for(int i = 0; i < field.length; i++){
            for(int a = 0; a< field[i].length;a++){
               field[i][a] = null; 
            }
        }
        
        animals.clear();
    }

    public ArrayList getAnimals(){
        return animals;
    }
    
    
    /**
     * Place an animal at the given location.
     * If there is already an animal at the location it will
     * be lost.
     * @param animal The animal to be placed.
     * @param row Row coordinate of the location.
     * @param col Column coordinate of the location.
     */
    public void place(Object animal, int row, int col)
    {
        if (field[row][col] == null){
         }
        else{
            field[row][col] = animal;  
            animals.add(animal);
        }
        
    }

    /**
     * Place an animal at the given location.
     * If there is already an animal at the location it will
     * be lost.
     * @param animal The animal to be placed.
     * @param location Where to place the animal.
     */
    public void place(Object animal, Location location)
    {
        int r = location.getRow();
        int c = location.getCol();
        place(animal, r, c);
        
    }
    
    /**
     * Move an Object from one location in the field to another
     * @param oldLocation Object's old locat   ion
     * @param newLocation Object's new location
     */
    public void move(Location oldLocation, Location newLocation)
    {
        int r = oldLocation.getRow();
        int c = oldLocation.getCol();
        Object temp = field[r][c];
        remove(oldLocation);
        place(temp, newLocation);
    }
    
    /**
     * Remove an Object from a particular location
     * @param location
     */
    public void remove(Location location)
    {
        int r = location.getRow();
        int c = location.getCol();
        field[r][c] = null;
        animals.remove(getObjectAt(location));
    }
    
    /**
     * Return the animal at the given location, if any.
     * @param location Where in the field.
     * @return The animal at the given location, or null if there is none.
     */
    public Object getObjectAt(Location location)
    {
        int r = location.getRow();
        int c = location.getCol();
        return field[r][c];
    }

    /**
     * Return the animal at the given location, if any.
     * @param row The desired row.
     * @param col The desired column.
     * @return The animal at the given location, or null if there is none.
     */
    public Object getObjectAt(int row, int col)
    {
        return field[row][col];
    }

    /**
     * Generate a shuffled List of locations adjacent to the given one - will 
     * not include the location itself. All locations will lie within the grid.
     * @param location The location from which to generate adjacencies.
     * @return A randomized list of locations adjacent to that given.
     */
    public List<Location> adjacentLocations(Location location)
    {
        List<Location> place= new ArrayList<Location>();
        int r = location.getRow();
        int c = location.getCol();
        for(int i = r-1; i <= r+1; i++){
            for(int a = c-1; a<= c+1; a++){
                if(i==r && a==c){}
                else{
                    place.add(new Location(i, a));
                  }
            }
        }
        Collections.shuffle(place);
        return place;
    }

    /**
     * Try to find a free location that is adjacent to the given location. 
     * If there is none, return null. The returned location will be within 
     * the valid bounds of the field.
     * @param location The location from which to generate an adjacency.
     * @return A valid free location within the grid area, or null if all
     *         locations around are full.
     */
    public Location freeAdjacentLocation(Location location)
    {
        List<Location> places = adjacentLocations(location);
        boolean free = false;
        Location open = null;
        
        if(open == null){
            for(Location i: places){
               int r = i.getRow();
               int c = i.getCol();
               if(field[r][c] == null){ }
               else{
                  open = i;
               }
           }
        }
        return open;
            
    }

    @Override
    public String toString() //quick picture of the state of the field, for debugging
    {
        String result = "";
        
        for (int r = 0; r < this.depth; r++)
        {
            for (int c = 0; c < this.width; c++)
            {
                Object obj = this.field[r][c];
                
                if (obj instanceof Rabbit)
                    result += "R\t";
                else if (obj instanceof Fox)
                    result += "F\t";
                else
                    result += "x\t";
            }
            result += "\n";
        }
        
        return result;
    }
    
    public int getDepth() { return this.depth; }
    
    public int getWidth() { return this.width; }
}
