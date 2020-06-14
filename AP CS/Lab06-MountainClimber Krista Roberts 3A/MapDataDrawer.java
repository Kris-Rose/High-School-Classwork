import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MapDataDrawer
{
    /** the 2D array containing the elevations */
    private int[][] grid;
    private int cols;
    private int rows;
    

    /** constructor, parses input from the file into grid */
    public MapDataDrawer(String fileName) throws IOException
    {
        try{
            Scanner console = new Scanner(new File(fileName));
            rows = console.nextInt();
            cols = console.nextInt();
            grid = new int[rows][cols];
            for(int a = 0; a<grid.length; a++){
                for(int b = 0; b<grid[a].length; b++ ){
                    grid[a][b] = console.nextInt();
                }
            }
            
        }
        catch(Exception e){
            System.out.println("ding dong you were wrong");
        }
        
    }

    /** @return the min value in the entire grid */
    public int findMin()
    {
        int min = grid[0][0];
        for(int a = 0; a<grid.length; a++){
            for(int b = 0; b<grid[a].length; b++ ){
                if(grid[a][b]<min ){
                    min = grid[a][b];
                }
            }
        }
        return min;
    }

    /** @return the max value in the entire grid */
    public int findMax()
    {
        int max = grid[0][0];
        for(int a = 0; a<grid.length; a++){
            for(int b = 0; b<grid[a].length; b++ ){
                if(grid[a][b]>max ){
                    max = grid[a][b];
                }
            }
        }
        return max;
    }

    /**
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap(Graphics g)
    {
        //TODO
    }

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row)
    {
        //TODO

        return -1;
    }

    /** @return the index of the starting row for the lowest-elevation-change path in the entire grid. */
    public int indexOfLowestElevPath(Graphics g)
    {
        //TODO

        return 0;
    }
    
    public int getRows()
    {
        
        return rows;
    }
    
    public int getCols()
    {
        
        return cols;
    }
}
