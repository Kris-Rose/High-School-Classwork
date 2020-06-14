

/**
 * Represent a location in a rectangular grid.
 */
public class Location
{
    private int row;
    private int col;

    /**
     * Represent a row and column.
     * @param row The row.
     * @param col The column.
     */
    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }


    /**
     * Use the top 16 bits for the row value and the bottom for
     * the column. Except for very big grids, this should give a
     * unique hash code for each (row, col) pair.
     * @return A hashcode for the location.
     */
    @Override
    public int hashCode()
    {
        //don't mess with this
        return (row << 16) + col;
    }
    
    public int getCol(){
        return col; 
    }
    public int getRow(){
       return row; 
    }
    
    public String toString(){
        return "" + row + ", " + col;
    }
    
    public boolean equals(Location a){
        if(this.row == a.getRow() && this.col == a.getCol()){
            return true;
        }
        else{
            return false;
        }
    }
}
