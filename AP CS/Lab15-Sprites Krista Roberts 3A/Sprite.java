import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;

public abstract class Sprite
{
    private double left;  //the x-coordinate of the left edge of the sprite
    private double top;   //the y-coordinate of the top edge of the sprite
    private int    width;
    private int    height;
    private String image;
    boolean alive;
    boolean overlap;

    public Sprite(double left, double top, int width, int height, String image, boolean dead, boolean overlap)
    {
        this.left   = left;
        this.top    = top;
        this.width  = width;
        this.height = height;
        alive = dead;
        this.setImage(image);
        this.overlap = overlap;
    }

    public abstract void step(World world);

    //-----------------Getters-------------------

    public double getLeft()   { return this.left; }

    public int    getWidth()  { return this.width; }

    public double getTop()    { return this.top; }

    public int    getHeight() { return this.height; }

    public String getImage()  { return this.image; }

    public boolean getAlive() {return this.alive; }
    
    public boolean getOverlap() {return this.overlap; }
    //-----------------Setters-------------------

    public void setLeft(double left) { this.left = left; }

    public void setTop(double top)   { this.top = top; }

    public void setWidth(int width)  { this.width = width; }

    public void setHeight(int height) { this.height = height; }

    public void setImage(String image) { this.image = image; }

    public void setAlive(boolean alive) { this.alive = alive; }
    
    public void setOverlap(boolean overlap) {this.overlap = overlap; }
    
    
    public boolean checkOverlap(Sprite s) {
        if (this.left == s.getLeft() && this.top == s.getTop()){
            return true;
        }
        else{
            return false;
        }
    }
}
