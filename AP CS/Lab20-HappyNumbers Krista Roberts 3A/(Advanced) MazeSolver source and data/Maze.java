import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Maze
{
	private int[][] maze;
	private boolean exitFound;

	/** Make sure to look at the format of the mazes in the maze text files */
	public Maze(String fileName) throws IOException
	{
		Scanner in = new Scanner(new File(fileName)); //for getting next int from the maze text file

		//TODO
	}
	
	/**
	 * Helper method, makes the interface a little cleaner
	 * 
	 * The user doesn't have to know the solver should start at 0, 0
	 * 
	 * Also responsible for printing the final state of the maze
	 */
	public void solve()
	{
		this.hasExitPath(0, 0);
		System.out.println(this);
	}

	public void hasExitPath(int r, int c)
	{
		//TODO
	}

	public String toString()
	{
		String output = "";

		//TODO

		return output;
	}
}