
/**
 * 
 *
 * Krista Roberts
 * 1/8/2020
 */
public class Star
{
    
    private double xCoor;
    private double yCoor;
    private double zCoor;
    private int HDnum;
    private double magnitude;
    private int HRnum;
    private String name;

    public Star(double xCoor,double yCoor,double zCoor,int HDnum,double magnitude,int HRnum,String name){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.zCoor = zCoor;
        this.HDnum = HDnum;
        this.magnitude = magnitude;
        this.HRnum = HRnum;
        this.name = name;
    }
    
    public Star(double xCoor,double yCoor,double zCoor,int HDnum,double magnitude,int HRnum){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.zCoor = zCoor;
        this.HDnum = HDnum;
        this.magnitude = magnitude;
        this.HRnum = HRnum;
        name = "";
    }
    
    public Star(){
        this.xCoor = 0;
        this.yCoor = 0;
        this.zCoor = 0;
        this.HDnum = 0;
        this.magnitude = 0;
        this.HRnum = 0;
        name = "";
    }
    
    public double getMag(){
        return magnitude;
    }
    
    public double getX(){
        return xCoor;
    }
    
    public double getY(){
        return yCoor;
    }
    
    public int getHDnum(){
        return HDnum;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean hasName(){
        if(name.equals("")){
            return false;
        }
        else{
            return true;
        }
    }
}
