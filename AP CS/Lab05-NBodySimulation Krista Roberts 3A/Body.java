import java.util.*;
public class Body
{
    public static final double G = 6.67E-11;  //Newtons' gravitational constant

    private double x, y; //planet's x and y coordinate position
    private double xVel, yVel;//x and y velocity
    private double mass;
    private double xNetForce, yNetForce; //net forces action on this planet
    private double xAccel, yAccel;
    private String image; //image of this planet (for drawing)

    //1
    public Body(double x,double y,double xVelocity,double yVelocity,double mass, String image){
        this.x = x;
        this.y =y ;
        this.xVel = xVelocity;
        this.yVel = yVelocity;
        this.mass = mass;
        this.image = image;
       }
       
    //2
    private double getDistance(Body other){
       double distance =0;
       distance = Math.sqrt(Math.pow( x - other.getX(), 2) + Math.pow(y - other.getY(), 2)  );
       return distance;
    }
    
    //3
    private double getPairwiseForce(Body other){
        double pairwiseForce = G*(mass*other.getMass())/Math.pow(getDistance(other), 2);
        return pairwiseForce;
    }
    
    //4
    private double getPairwiseForceX(Body other){
        double forceX = getPairwiseForce(other) * Math.cos((other.x  -  this.x)  /  getDistance(other));
        return forceX;
    }
     
    private double getPairwiseForceY(Body other){
        double forceY = getPairwiseForce(other) * Math.sin((other.y  -  this.y)  /  getDistance(other));
        return forceY;
    }
    
    public double theta(){
        double theta = Math.atan(y/x);
        return theta;
    }
    
    //5
    public void setNetForce(Body[] bodies)
    {
        double xTotalNetForce = 0;
        double yTotalNetForce = 0;
        xNetForce =  0;
        yNetForce =  0;
        
        for(int i = 0; i<bodies.length ; i++){
            if (this == bodies[i]){
                continue; 
            }
            xTotalNetForce += getPairwiseForceX(bodies[i]);
            yTotalNetForce += getPairwiseForceY(bodies[i]);
          }
        xNetForce =  xTotalNetForce;
        yNetForce =  yTotalNetForce;
    }
    
    
    
    //6
    /*  updates this body's accel, vel, and position, given the time step */
    public void update(double dt)
    {
       xAccel = xNetForce / mass;//accelerations
       yAccel = yNetForce / mass;
        
       xVel  +=  xAccel  *  dt;  //velocities
       yVel  +=  yAccel  *  dt; 
        
       x  +=  xVel  *  dt;//positions
       y  +=  yVel  *  dt;  
    }

    //7
    /* * Draws the body using the StdDraw library file's drawing method */
    public void draw()
    {
        StdDraw.picture(x, y, image);
    }







    public double getY(){
        return y;
       }
    
    
    public double getX(){
        return x;
       }

    public double getMass(){
        return mass;
       }

    






    }


	 