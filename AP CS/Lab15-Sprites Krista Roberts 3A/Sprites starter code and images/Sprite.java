import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;

public class Sprite
{
	private double left;  //the x-coordinate of the left edge of the sprite
	private double top;   //the y-coordinate of the top edge of the sprite
	private int    width;
	private int    height;
	private String image;

	public Sprite(double left, double top, int width, int height, String image)
	{
		this.left   = left;
		this.top    = top;
		this.width  = width;
		this.height = height;

		this.setImage(image);
	}

	public void step(World world)
    {
        //nothing to see here at the moment
    }

	//-----------------Getters-------------------

	public double getLeft()   { return this.left; }

	public int    getWidth()  { return this.width; }

	public double getTop()    { return this.top; }

	public int    getHeight() { return this.height; }

	public String getImage()  { return this.image; }

	//-----------------Setters-------------------

	public void setLeft(double left) { this.left = left; }

	public void setTop(double top)   { this.top = top; }

	public void setWidth(int width)  { this.width = width; }

	public void setHeight(int height) { this.height = height; }

	public void setImage(String image) { this.image = image; }

}
