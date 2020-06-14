import java.io.*;
import java.util.Scanner;

public class NBodySimulation
{
    private Body[] bodies;    //stores all the bodies in the simulation
    private int    numBodies; //number of bodies in this simulation
    private double uRadius;   //radius of the universe
    private String fileName;  //file providing the input
    
    //1
    public NBodySimulation(String nameOfFile) throws IOException
    {
        fileName = nameOfFile;
        try{
           Scanner universe = new Scanner(new File(fileName)); 
           numBodies = universe.nextInt();
           uRadius = universe.nextDouble();
           bodies = new Body[numBodies];
           
           double xPosition = 0;
           double yPosition = 0;
           double xVel = 0;
           double yVel = 0;
           double mass = 0;
           String name = "";
           
           
           
           boolean counter = true;
           for(int a = 0; a<bodies.length; a++){
               xPosition = universe.nextDouble();
               yPosition = universe.nextDouble();
               xVel = universe.nextDouble();
               yVel = universe.nextDouble();
               mass = universe.nextDouble();
               name = universe.next();
               
               bodies[a] = new Body (xPosition, yPosition, xVel, yVel, mass, name);
            }
        }
        catch(FileNotFoundException e){
            
        }
            
        
        

        initCanvas(); //don't move, should be the last line of the constructor
    }

    
    
    /** initialize the drawing canvas */
    private void initCanvas()
    {
        StdDraw.setScale(-uRadius, uRadius); //set canvas size / scale
        StdDraw.picture(0, 0, "starfield.jpg"); //paint background

        //below is a for-each loop, which we will cover in the next lab
        //more info is available in the powerpoints, for the curious
        for (Body body : bodies)
            body.draw();
    }

    /**
     * run the n-bodies simulation
     * @param T total time to run the simulation, in seconds
     * @param dt time step, in seconds
     */
    public void run(double T, double dt)
    {
        for(int i = 0; i<T; i += dt){
            
            for (Body body : bodies){
                body.setNetForce(bodies);
                body.update(dt);
                
            }
            StdDraw.picture(0, 0, "starfield.jpg");
            for (Body body : bodies)
            body.draw();
            StdDraw.show(10); 
        }
        
        
        
    }
}
