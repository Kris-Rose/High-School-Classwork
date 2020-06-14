public class Point 
{
	private double  x, y;
	private boolean visited;
	
	/** get the Euclidean distance between two points */
	public double getDistance(Point other)
	{
		double dist = Math.sqrt(Math.pow(x - other.getX(), 2) + Math.pow(y - other.getY(), 2));
		return dist;
	}
	
	public void setVisited(boolean beenThere){
	    visited = beenThere;
	}
	public double getX(){
	    return x;
	   }
	public double getY(){
	    return y;
	   }
	
	
	
	@Override
	public String toString()
	{
		return "x: " + x + ", y: " + y;
	}
}
